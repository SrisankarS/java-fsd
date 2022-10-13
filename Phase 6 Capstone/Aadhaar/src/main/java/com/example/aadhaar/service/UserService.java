package com.example.aadhaar.service;

import com.example.aadhaar.enums.CardStatus;
import com.example.aadhaar.exception.BadRequestException;
import com.example.aadhaar.model.AadhaarCard;
import com.example.aadhaar.model.User;
import com.example.aadhaar.repository.AadhaarCardRepository;
import com.example.aadhaar.repository.UserRepository;
import com.example.aadhaar.security.TokenService;
import com.example.aadhaar.vo.AadhaarResponse;
import com.example.aadhaar.vo.UserLoginRequest;
import com.example.aadhaar.vo.UserRegistrationRequest;
import com.example.aadhaar.vo.UserResponse;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static java.lang.String.format;


@RequiredArgsConstructor
public class UserService {
    private static final String EXISTING_CARD_MESSAGE = "Aadhaar card with status %s and request number %s already present for user %s";
    private final UserRepository userRepository;
    private final AadhaarCardRepository aadhaarRepository;
    private final TokenService tokenService;

    public UserResponse login(UserLoginRequest loginRequest){
        Optional<User> user = userRepository.findByMobileNoAndPassword(loginRequest.getMobileNo(), loginRequest.getPassword());
        if(user.isPresent()){
            String authToken = tokenService.getToken(user.get());
            return UserResponse.builder().withMessage("Login Success").withAuthorizationToken(authToken).withUser(user.get()).build();
        }
        throw new BadRequestException("mobile number and password doesn't match");
    }

    public UserResponse register(UserRegistrationRequest registrationRequest){
        Optional<User> user = userRepository.findByNameAndMobileNo(registrationRequest.getName(), registrationRequest.getMobileNo());
        if(user.isEmpty()){
            User savedUser = userRepository.save(User.from(registrationRequest));
            return UserResponse.builder().withMessage("Registration Success").withUser(savedUser).build();
        }
        throw new BadRequestException("User already exist please login");
    }

    public AadhaarResponse apply(String token){
        User user = tokenService.getUserWithToken(token);
        Optional<AadhaarCard> appliedCard = aadhaarRepository.findByUserId(user.getId());
        if(appliedCard.isEmpty()) {
            AadhaarCard aadhaarCard = aadhaarRepository.save(AadhaarCard.builder().withUser(user).withStatus(CardStatus.PENDING.getValue()).build());
            return AadhaarResponse.builder().withMessage("Application of aadhaar card is successful").withAadhaarCard(aadhaarCard).build();
        }
        AadhaarCard existingCard = appliedCard.get();
        throw new BadRequestException(format(EXISTING_CARD_MESSAGE,
                existingCard.getStatus(), existingCard.getId(), user.getName()));
    }
}
