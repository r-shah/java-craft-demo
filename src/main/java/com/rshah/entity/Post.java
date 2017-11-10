package com.rshah.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long postId;

	@Column(name = "message")
	private String message;

	// Posts has Many to one relation with user 
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(name = "created_ts")
	private LocalDateTime createdOn;

	// Constructors
	public Post() {

	}

	public Post(Long postId, String message, User user, LocalDateTime createdOn) {
		super();
		this.postId = postId;
		this.message = message;
		this.user = user;
		this.createdOn = createdOn;
	}
	// Getters and Setters
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	
	// ToString method
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", message=" + message + ", user=" + user + ", createdOn=" + createdOn + "]";
	}
	
	
}
