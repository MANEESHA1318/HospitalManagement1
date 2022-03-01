package com.hospital.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.exception.ResourceNotFoundException;
import com.hospital.model.Feedback;
import com.hospital.service.FeedbackService;
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;

//http://localhost:8080/api/v1/allfeedbacks
	@GetMapping("/feedbacks")
	public List<Feedback> getFeedback() {
		List<Feedback> feedbackList = feedbackService.fetchFeedback();
		return feedbackList;

	}

	// http://localhost:8080/api/v1/feedbacks/1
	@GetMapping("/feedbacks/{feedback_id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable("feedback_id") int feedback_id)
			throws ResourceNotFoundException {
		Feedback feedback = feedbackService.getFeedback(feedback_id);
		return ResponseEntity.ok().body(feedback);
	}

	// http://localhost:8080/api/v1/feedbacks
	@PostMapping("/feedbacks")
	public Feedback addFeedback(@RequestBody Feedback feedback) {
		   feedback = feedbackService.saveFeedback(feedback);		
		return feedback;
	}
	// http://localhost:8080/api/v1/feedbacks/3
	@PutMapping("/feedbacks/{feedback_id}")
	public ResponseEntity<Feedback> updateFeedback(@PathVariable("feedback_id") int feedback_id,
			@RequestBody Feedback feedbackDetails) throws ResourceNotFoundException {
		Feedback feedback = feedbackService.getFeedback(feedback_id);
		
		 feedback.setP_id(feedbackDetails.getP_id());
		 feedback.setP_comments(feedbackDetails.getP_comments());
		 
		
		
		final Feedback updatedFeedback = feedbackService.saveFeedback(feedback);
		return ResponseEntity.ok(updatedFeedback);
	}

//http://localhost:8080/api/v1/feedbacks/1
	@DeleteMapping(value = "/feedbacks/{feedback_id}")
	public ResponseEntity<Object> deleteFeedback(@PathVariable("feedback_id") int feedback_id) {

		feedbackService.deleteFeedback(feedback_id);
		return new ResponseEntity<>("Feedback deleted successsfully", HttpStatus.OK);
	}
}
