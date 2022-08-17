package com.project.usermanager.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.usermanager.entities.User;
import com.project.usermanager.exceptions.UserNotFoundException;
import com.project.usermanager.repositories.UserRepository;

@Service 
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Iterable<User> GetAllUsers() {
		return userRepository.findAll();
	}
	
	public User GetUserByName(String name) {
		return userRepository.findByName(name);
		
	}
	
	public User GetUserById(Integer id) {
		Optional<User> foundUser = userRepository.findById(id);
		if(!foundUser.isPresent()) throw new UserNotFoundException();
		return foundUser.get();
	}
	
	public User UpdateUser(User userToUpdate) {
		return userRepository.save(userToUpdate);
	}
}
