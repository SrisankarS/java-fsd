package com.project.Feedback.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Table(name="userfeedback")
@Entity
@Data
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="User_id")
	private Integer id;

	@Column(name="Feedback")
	private String comments;

	@Column(name="Rating")
	@NotNull
	private int rating;

	@Column(name="Name")
	private String user;

	public Feedback() {
		super();
	}

	public Feedback(String comments, Integer rating, String user) {
		this.comments = comments;
		this.rating = rating;
		this.user = user;
	}

	/*
	 * Needed the setters and getters to be able to add name and comments otherwise
	 * they are nulls when entering the SQL DB
	 */
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", comments=" + comments + ", rating=" + rating + ", user=" + user + "]";
	}

}
