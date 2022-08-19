package com.project.Feedback.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Feedback.entities.Feedback;
import com.project.Feedback.repositories.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	FeedbackRepository feedbackRepo;
	
	public List<Feedback> GetAllFeedback() {
		List<Feedback> feedbacks= new ArrayList<>();
		feedbackRepo.findAll().forEach(feedbacks::add);
		return feedbacks;
	}
	
	public Feedback addNewFeedback(Feedback fb) {
		return feedbackRepo.save(fb);
	}
}
