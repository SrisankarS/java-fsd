package com.example.aadhaar.service;

import com.example.aadhaar.enums.CardStatus;
import com.example.aadhaar.exception.BadRequestException;
import com.example.aadhaar.model.AadhaarCard;
import com.example.aadhaar.model.User;
import com.example.aadhaar.repository.AadhaarCardRepository;
import com.example.aadhaar.security.TokenService;
import com.example.aadhaar.vo.AadhaarResponse;
import com.example.aadhaar.vo.AadhaarUpdateRequest;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static java.lang.String.format;

@RequiredArgsConstructor
public class CardService {
    private final AadhaarCardRepository cardRepository;
    private final TokenService tokenService;

    public AadhaarResponse approve(int aadhaarRequestId, String token){
        User user = tokenService.getUserWithToken(token);
        if(!user.isAdmin()){
            throw new BadRequestException("Only an admin can approve a aadhaarRequest");
        }
        Optional<AadhaarCard> toApproveCard = cardRepository.findById(aadhaarRequestId);
        if(toApproveCard.isPresent()){
            AadhaarCard aadhaarCard = toApproveCard.get();
            if(CardStatus.ISSUED.equals(aadhaarCard.getStatus())){
                throw new BadRequestException(format("The Aadhaar request number %d is already approved", aadhaarRequestId));
            }
            aadhaarCard.setStatus(CardStatus.ISSUED.getValue());
            aadhaarCard.setIssueDate(LocalDate.now());
            aadhaarCard.setAadhaarNumber(aadhaarNumberGenerator(aadhaarCard.getUser().getMobileNo()));
            cardRepository.save(aadhaarCard);
            return AadhaarResponse.builder().withMessage("Aadhaar status is approved").withAadhaarCard(aadhaarCard).build();
        }
        throw new BadRequestException(format("The Aadhaar request number %d is invalid", aadhaarRequestId));
    }

    public List<AadhaarCard> pendingForApproval(){
        return cardRepository.findByStatusIn(List.of(CardStatus.PENDING.getValue(), CardStatus.DUPLICATE_PENDING.getValue()));
    }

    public AadhaarResponse status(String token) {
        User user = tokenService.getUserWithToken(token);
        AadhaarCard aadhaarCard = cardRepository.findByUserId(user.getId()).orElseThrow(() -> new RuntimeException("Aadhaar not applied yet"));
        return AadhaarResponse.builder().withAadhaarCard(aadhaarCard).build();
    }

    public AadhaarResponse update(AadhaarUpdateRequest updateRequest, String token) {
        User user = tokenService.getUserWithToken(token);
        AadhaarCard aadhaarCard = updatedAadhaarCard(updateRequest, user);
        cardRepository.save(aadhaarCard);
        return AadhaarResponse.builder().withAadhaarCard(aadhaarCard).build();
    }

    public AadhaarResponse duplicate(String token) {
        User user = tokenService.getUserWithToken(token);
        AadhaarCard aadhaarCard = cardRepository.findByUserId(user.getId()).orElseThrow(() -> new RuntimeException("Aadhaar not applied yet"));
        aadhaarCard.setStatus(CardStatus.DUPLICATE_PENDING.getValue());
        cardRepository.save(aadhaarCard);
        return AadhaarResponse.builder().withAadhaarCard(aadhaarCard).build();
    }

    private String aadhaarNumberGenerator(long mobileNumber){
        return String.valueOf(mobileNumber) + generateRandom(2);
    }

    private static long generateRandom(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }

    private AadhaarCard updatedAadhaarCard(AadhaarUpdateRequest updateRequest, User user) {
        AadhaarCard aadhaarCard = cardRepository.findByUserId(user.getId()).orElseThrow(() -> new RuntimeException("Aadhaar not applied yet"));
        User aadhaarUser = aadhaarCard.getUser();
        if(updateRequest.getMobileNo() != null){
            aadhaarUser.setMobileNo(updateRequest.getMobileNo());
        }
        if(updateRequest.getAddress() != null){
            aadhaarUser.setAddress(updateRequest.getAddress());
        }
        if(updateRequest.getDob() != null){
            aadhaarUser.setDob(updateRequest.getDob());
            aadhaarUser.setPassword(updateRequest.getDob().toString());
        }
        return aadhaarCard;
    }
}
