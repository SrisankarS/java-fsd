package com.example.aadhaar.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@Slf4j
@RestControllerAdvice
public class AadhaarControllerAdvice {

    public static final String REQUEST_BODY = "requestBody";

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> ErrorMessage genericExceptionHandler(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        return ErrorMessage.builder()
                .withMessage(ex.getMessage())
                .withDate(LocalDate.now())
                .withStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .withRequestBody(request.getAttribute(REQUEST_BODY, RequestAttributes.SCOPE_REQUEST))
                .build();
    }

    @ExceptionHandler(value = {BadRequestException.class, HttpMessageNotReadableException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public <T> ErrorMessage badRequestExceptionHandler(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        return ErrorMessage.builder()
                .withMessage(ex.getMessage())
                .withDate(LocalDate.now())
                .withStatus(HttpStatus.BAD_REQUEST.value())
                .withRequestBody(request.getAttribute(REQUEST_BODY, RequestAttributes.SCOPE_REQUEST))
                .build();
    }
}
