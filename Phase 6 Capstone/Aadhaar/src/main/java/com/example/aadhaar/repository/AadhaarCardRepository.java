package com.example.aadhaar.repository;

import com.example.aadhaar.model.AadhaarCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AadhaarCardRepository  extends JpaRepository<AadhaarCard, Integer> {

    Optional<AadhaarCard> findByUserId(int userId);
    List<AadhaarCard> findByStatusIn(List<String> status);
}
