package com.example.aadhaar.vo;

import com.example.aadhaar.model.AadhaarCard;
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
public class AadhaarResponse {
    private final String message;
    private final AadhaarCard aadhaarCard;
}
