package com.example.aadhaar.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@Getter
@Builder(setterPrefix = "with")
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
    private final LocalDate date;
    private final String message;
    private final Object requestBody;
    private final int status;
}
