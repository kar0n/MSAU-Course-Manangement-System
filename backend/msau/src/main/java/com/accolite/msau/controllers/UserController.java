package com.accolite.msau.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.msau.models.User;
import com.accolite.msau.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/email/{email}")
	public User getUserByEmail(@PathVariable("email") String email) {
		return userService.getUserByEmail(email);
	}

	@GetMapping("/trainers")
	public List<User> getAllTrainers() {
		return userService.getAllTrainers();
	}

	@GetMapping("/creators")
	public List<User> getAllCreators() {
		return userService.getAllCreators();
	}	
	
}
