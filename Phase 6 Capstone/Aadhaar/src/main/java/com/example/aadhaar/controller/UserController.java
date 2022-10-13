package com.example.aadhaar.controller;

import com.example.aadhaar.service.UserService;
import com.example.aadhaar.vo.AadhaarResponse;
import com.example.aadhaar.vo.UserLoginRequest;
import com.example.aadhaar.vo.UserRegistrationRequest;
import com.example.aadhaar.vo.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

import static com.example.aadhaar.exception.AadhaarControllerAdvice.REQUEST_BODY;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public UserResponse login(@Valid @RequestBody UserLoginRequest loginRequest, WebRequest request){
        request.setAttribute(REQUEST_BODY, loginRequest, RequestAttributes.SCOPE_REQUEST);
        return userService.login(loginRequest);
    }

    @PostMapping("/citizens")
    public UserResponse register(@Valid @RequestBody UserRegistrationRequest registrationRequest, WebRequest request){
        request.setAttribute(REQUEST_BODY, registrationRequest, RequestAttributes.SCOPE_REQUEST);
        return userService.register(registrationRequest);
    }

    @GetMapping("/aadhaarCard/apply")
    public AadhaarResponse apply(@RequestHeader String authorization){
        return userService.apply(authorization);
    }

}
