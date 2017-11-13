package com.rshah.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
    /*
     * This is home or index page which just returns the text
     */
	@RequestMapping("/")
	public String index(){
		return "Welcome to Craft Demonstration!";
	}

}
