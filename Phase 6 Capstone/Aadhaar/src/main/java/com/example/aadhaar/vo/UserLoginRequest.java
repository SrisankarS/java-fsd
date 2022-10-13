package com.example.aadhaar.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@RequiredArgsConstructor
@JsonIgnoreProperties(value = "password", allowSetters = true)
public class UserLoginRequest {
    @Range(min = 6000000000L, max=9999999999L)
    @Positive
    private final long mobileNo;
    @Size(min = 6, message = "password should be at least six characters long")
    private final String password;
}
