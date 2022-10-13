package com.example.aadhaar.configuration;

import com.example.aadhaar.repository.AadhaarCardRepository;
import com.example.aadhaar.service.CardService;
import com.example.aadhaar.service.UserService;
import com.example.aadhaar.repository.UserRepository;
import com.example.aadhaar.security.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public TokenService tokenService() {
        return new TokenService();
    }

    @Bean
    public UserService userService(UserRepository userRepository,
                                   AadhaarCardRepository aadhaarRepository,
                                   TokenService tokenService) {
        return new UserService(userRepository, aadhaarRepository, tokenService);
    }

    @Bean
    public CardService cardService(AadhaarCardRepository aadhaarCardRepository, TokenService tokenService){
        return new CardService(aadhaarCardRepository, tokenService);
    }
}
