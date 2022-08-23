package com.project.UserAuthentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.project.UserAuthentication.entities.User;
import com.project.UserAuthentication.exceptions.UserNotFoundException;
import com.project.UserAuthentication.repositories.AuthenticationRepository;
import com.project.UserAuthentication.services.AuthenticationService;

@DataJpaTest
//@ActiveProfiles("test")
public class AuthenticationCodeTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private AuthenticationService authService;

	@Autowired
	private AuthenticationRepository authRepo;
 
	private User testUser;
	
	@BeforeEach
	private void Setup() {
		testUser = new User("dummy", "dummy@test.edu", "TestDummy");
		System.out.println(testUser.toString());
		entityManager.persist(testUser);
		entityManager.flush();
	}

	@Test
	public void shouldGetUserByName() {
		User test = authService.GetUserByName("dummy");
		assertEquals(testUser.getName(), test.getName());
	}

	@Test
	public void shouldFindUserByName() throws UserNotFoundException {
		Optional<User> temp = authRepo.findUserByName("dummy");
		User tempUser = (temp.isPresent()) ? temp.get() : new User();
		assertEquals(testUser.getName(), tempUser.getName());
		tempUser = new User();
		assertFalse(testUser.getName().equals(tempUser.getName()));
	}
	
	@Test
	public void shouldValidateUser() {
		// incorrect username
		User input = new User("dumbo", "TestPassword");	
		Optional<User> temp = authRepo.findUserByName(input.getName());
		User tempUser = (temp.isPresent()) ? temp.get() : new User();
		assertFalse(testUser.getName().equals(input.getName()));
		
		// incorrect password but correct username
		input.setName("dummy");
		temp = authRepo.findUserByName(input.getName());
		tempUser = (temp.isPresent()) ? temp.get() : new User();
		assertFalse(authService.isValidPassword(tempUser.getPassword(), input.getPassword()));
		
		//correct username and password
		input.setPassword("TestDummy");
		assertTrue(authService.isValidPassword(tempUser.getPassword(), input.getPassword()));
	}

}
