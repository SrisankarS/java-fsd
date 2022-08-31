package com.project.SportyShoesPhase3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SportyShoesPhase3.entity.UserDetails;
import com.project.SportyShoesPhase3.repositories.UserDetailsRepository;

@Service
public class UserDetailsService {
	@Autowired
	UserDetailsRepository userRepo;
	
	public List<UserDetails> listAll()
	{
		return userRepo.findAll();
	}
	
	public List<UserDetails> get(String username) {
		return userRepo.findByusername(username);
	}

}


