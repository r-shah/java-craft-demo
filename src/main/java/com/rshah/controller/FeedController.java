package com.rshah.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rshah.entity.Feed;
import com.rshah.entity.User;
import com.rshah.service.FeedService;
import com.rshah.service.UserService;

@RestController
@RequestMapping("/feed")
public class FeedController {

	private FeedService feedService;
	private UserService userService;

	@Autowired
	public FeedController(FeedService feedService, UserService userService) {
		this.feedService = feedService;
		this.userService = userService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Feed>> getFeedsForLogginUser(@RequestHeader("user") String userEmail) {
		/*
		 * Check if user does not exit response as unauthorized
		 */
		Optional<User> user = this.userService.getUserByEmail(userEmail);
		if (!user.isPresent()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.ok(this.feedService.findFeedsForLoggedInUser(user.get()));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Feed> createFeed(@RequestHeader("user") String userEmail, @RequestBody Feed feed) {

		Optional<User> user = this.userService.getUserByEmail(userEmail);
		if (!user.isPresent()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		Feed savedFeed = this.feedService.save(feed);
		return ResponseEntity.created(URI.create("/" + savedFeed.getFeedId())).body(savedFeed);
	}
}
