package com.project.UserAuthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.project.UserAuthentication.controllers.AuthenticationController;
import com.project.UserAuthentication.entities.User;
import com.project.UserAuthentication.exceptions.UserNotFoundException;
import com.project.UserAuthentication.services.AuthenticationService;

@SpringBootApplication
@Import({
      AuthenticationController.class,
      UserNotFoundException.class,
      AuthenticationService.class,
      User.class
})
public class AuthenticationApplication {

   public static void main(String[] args) {
      SpringApplication.run(AuthenticationApplication.class, args);
   }

}