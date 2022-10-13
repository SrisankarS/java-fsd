package com.example.aadhaar.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import static java.lang.String.format;

@Getter
@RequiredArgsConstructor
public enum CardStatus {
    ISSUED("issued"),
    PENDING("pending"),

    DUPLICATE_PENDING("duplicate");

    private final String value;

    public CardStatus statusOf(String value) {
        return Arrays
                .stream(values())
                .filter(status -> status.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(format("Invalid Status %s", value)));
    }
}
