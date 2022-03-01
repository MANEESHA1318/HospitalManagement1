package com.hospital.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback {

	@Id
	@GeneratedValue()
	@Column(name="feedback_id")
	private int feedback_id;
	
	@Column(name="p_id")
	private int p_id;
	
	@Column(name="p_comments")
	private String p_comments;
	


	public Feedback(int feedback_id, int p_id , String p_comments) {
		super();
		this.feedback_id = feedback_id;
		this.p_id = p_id;
		this.p_comments = p_comments;
		
	}
	
	public Feedback () {
		
	}
	
	public int getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}


	public String getP_comments() {
		return p_comments;
	}

	public void setP_comments(String p_comments) {
		this.p_comments = p_comments;
	}
}
