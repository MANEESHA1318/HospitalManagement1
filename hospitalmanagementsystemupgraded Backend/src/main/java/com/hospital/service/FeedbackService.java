package com.hospital.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.dao.FeedbackRepository;
import com.hospital.model.Feedback;
@Service
public class FeedbackService {
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Transactional
	public List<Feedback> fetchFeedback() {
		List<Feedback> feedbackList=feedbackRepository.findAll();
		return feedbackList;
		
	}
	@Transactional
	public Feedback saveFeedback(Feedback feedback) {
		
		return feedbackRepository.save(feedback);
		
	}
	@Transactional
	public void updateFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);	
	
	}
	
	@Transactional
	public void deleteFeedback(int feedback_id) {
		System.out.println("service method called");
		feedbackRepository.deleteById(feedback_id);
	
	}
	@Transactional 
	  public Feedback getFeedback(int feedback_id) { 
	  Optional<Feedback> optional= feedbackRepository.findById(feedback_id);
	  Feedback feedback=optional.get();
	  return feedback;
	  }
}
