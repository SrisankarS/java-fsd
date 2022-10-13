package com.example.aadhaar.security;

import com.example.aadhaar.exception.BadRequestException;
import com.example.aadhaar.model.User;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TokenService {
    private final Map<User, UUID> tokens = new ConcurrentHashMap<>();

    public String getToken(User user){
        if(Objects.isNull(tokens.get(user))){
            synchronized (this) {
                if(Objects.isNull(tokens.get(user))) {
                    UUID uuid = UUID.randomUUID();
                    tokens.put(user, uuid);
                }
            }
        }
        return tokens.get(user).toString();
    }

    public User getUserWithToken(String token){
        UUID providedToken = UUID.fromString(token.replace("Bearer ", ""));
        return tokens.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(providedToken))
                .findFirst().map(Map.Entry::getKey)
                .orElseThrow(() -> new BadRequestException("Token provided with the request is invalid"));
    }

    public boolean isValidToken(String token){
        UUID providedToken = UUID.fromString(token);
        return tokens.containsValue(providedToken);
    }

    public void removeToken(User user){
        tokens.remove(user);
    }
}
