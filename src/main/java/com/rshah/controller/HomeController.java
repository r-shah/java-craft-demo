package com.rshah.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String index(){
		return "Welcome to Craft Demonstration!";
	}

}
