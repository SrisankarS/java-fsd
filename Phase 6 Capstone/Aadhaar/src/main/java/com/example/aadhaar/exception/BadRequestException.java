package com.example.aadhaar.exception;

import lombok.AllArgsConstructor;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
