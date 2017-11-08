package com.rshah.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rshah.entity.User;
import com.rshah.jpa.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserRepository userRepo;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepo = userRepository;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(this.userRepo.findAll());
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = this.userRepo.save(user);
		return ResponseEntity.created(URI.create("/" + savedUser.getUserId())).body(savedUser);
	}
}