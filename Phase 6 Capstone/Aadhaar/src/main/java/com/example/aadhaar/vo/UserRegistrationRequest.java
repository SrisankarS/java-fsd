package com.example.aadhaar.vo;

import com.example.aadhaar.enums.Gender;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class UserRegistrationRequest {
    @NotNull
    private final String name;
    @NotNull
    private final LocalDate dob;
    @NotNull
    private final String address;
    @Email
    @NotNull
    private final String email;
    @Range(min = 6000000000L, max=9999999999L)
    @Positive
    private final long mobileNo;
    @NotNull
    private final Gender gender;
}
