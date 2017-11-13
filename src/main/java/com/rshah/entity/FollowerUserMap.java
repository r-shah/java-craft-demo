package com.rshah.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "follower_user_map", uniqueConstraints = @UniqueConstraint(columnNames = { "following_user_id",
		"followed_user_id" }))
@NamedNativeQuery(name = "FollowerUserMap.getFollowedIdsByFollowingUserId",
		query="SELECT m.* FROM follower_user_map m WHERE m.following_user_id = :followingUserId", resultClass = FollowerUserMap.class)

public class FollowerUserMap {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	/*
	 *  Following user has Many to one relation with user since there can be many
	 *  user-follower relationship
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "following_user_id", nullable = false)
	private User followingUser;

	/*
	 *  Followed user also has Many to one relation with user since many user can 
	 *  follow a specific user
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "followed_user_id", nullable = false)
	private User followedUser;

	public FollowerUserMap() {
	}

	public FollowerUserMap(Long id, User followingUser, User followedUser) {
		super();
		this.id = id;
		this.followingUser = followingUser;
		this.followedUser = followedUser;
	}

	// Getters Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getFollowingUser() {
		return followingUser;
	}

	public void setFollowingUser(User followingUser) {
		this.followingUser = followingUser;
	}

	public User getFollowedUser() {
		return followedUser;
	}

	public void setFollowedUser(User followedUser) {
		this.followedUser = followedUser;
	}

	// ToString method
	@Override
	public String toString() {
		return "FollowerUserMap [id=" + id + ", followingUser=" + followingUser + ", followedUser=" + followedUser
				+ "]";
	}

}
