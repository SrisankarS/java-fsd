package com.example.aadhaar.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AadhaarUpdateRequest {
    private String address;
    private LocalDate dob;
    @Range(min = 6000000000L, max=9999999999L)
    @Positive
    private Long mobileNo;
}
