package com.example.aadhaar.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import static java.lang.String.format;

@Getter
@RequiredArgsConstructor
public enum Gender {
    @JsonProperty("male")
    MALE("male"),
    @JsonProperty("female")
    FEMALE("female");
    private final String value;

    /**
     * Returns the matching gender enum type for the given string value.
     *
     * @param value - string value of the gender
     * @return - Gender
     */
    public Gender genderOf(String value) {
        return Arrays
                .stream(values())
                .filter(gender -> gender.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(format("Invalid Gender %s", value)));
    }
}
