package com.example.aadhaar.vo;

import com.example.aadhaar.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Singular;

import java.util.List;

@Getter
@Builder(setterPrefix = "with")
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    private final String message;
    private final String authorizationToken;
    private final User user;
}
