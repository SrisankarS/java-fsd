package com.project.SportyShoesPhase3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.SportyShoesPhase3.entity.UserDetails;



@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
	

	public List<UserDetails> findByusername(String username);
}
