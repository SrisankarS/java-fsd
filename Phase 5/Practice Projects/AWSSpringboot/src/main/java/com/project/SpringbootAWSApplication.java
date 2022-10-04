package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootAWSApplication {

	@GetMapping("/")
	
	public String home(){
		return "Hello Welcome to AWS World";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootAWSApplication.class, args);
	}

}
