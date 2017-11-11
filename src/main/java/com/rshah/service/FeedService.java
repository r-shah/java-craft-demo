package com.rshah.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rshah.entity.Feed;
import com.rshah.entity.FollowerUserMap;
import com.rshah.entity.User;
import com.rshah.jpa.FeedRepository;
import com.rshah.jpa.FollowerUserMapRepository;

@Service
public class FeedService {

	@Autowired
	FeedRepository feedRepo;

	@Autowired
	FollowerUserMapRepository usermapRepo;

	public FeedService(FeedRepository feedRepo, FollowerUserMapRepository usermapRepo) {
		this.feedRepo = feedRepo;
		this.usermapRepo = usermapRepo;
	}

	public List<Feed> findAll() {
		return this.feedRepo.findAll();
	}

	public Feed save(Feed feed) {
		return this.feedRepo.save(feed);
	}

	public List<Feed> findFeedsForLoggedInUser(User user) {
		/*
		 * First, Find list of users those logged in users are following
		 */
		List<FollowerUserMap> followedUsers = this.usermapRepo.getFollowedIdsByFollowingUserId(user.getUserId());
		
		List<Long> followedUserIds = new ArrayList<>();
		followedUsers.forEach(u -> followedUserIds.add(u.getFollowedUser().getUserId()));		
		/*
		 * Secondly get posted feeds of the list of users and return
		 */
		return this.feedRepo.getByUserIds(followedUserIds);
	}

}
