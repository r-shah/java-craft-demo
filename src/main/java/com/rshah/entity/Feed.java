package com.rshah.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "message_feed")

@NamedNativeQuery(name = "Feed.getByUserIds",
query="select * from message_feed f where f.user_id in :ids order by f.created_ts limit 100", resultClass = Feed.class)

public class Feed {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long feedId;

	@Column(name = "message", nullable = false)
	private String message;

	// Posts has Many to one relation with user 
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "created_ts", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	public Feed() {

	}

	public Feed(Long feedID, String message, User user, Date createdOn) {
		super();
		this.feedId = feedID;
		this.message = message;
		this.user = user;
		this.createdOn = createdOn;
	}
	// Getters and Setters
	public Long getFeedId() {
		return feedId;
	}
	public void setFeedId(Long feedId) {
		this.feedId = feedId;
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
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	// ToString method
	@Override
	public String toString() {
		return "Feed [feedId=" + feedId + ", message=" + message + ", user=" + user + ", createdOn=" + createdOn + "]";
	}
	
	
}
