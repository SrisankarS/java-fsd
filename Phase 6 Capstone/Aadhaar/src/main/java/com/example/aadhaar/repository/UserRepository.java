package com.example.aadhaar.repository;

import com.example.aadhaar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByMobileNoAndPassword(long mobileNo, String password);
    Optional<User> findByNameAndMobileNo(String name, Long mobileNo);
}
