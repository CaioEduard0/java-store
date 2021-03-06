package com.example.JavaStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.JavaStore.entities.User;
import com.example.JavaStore.services.UserService;

@Controller
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String signInPage() {
		return "login";
	}
	
	@GetMapping("/sign-up")
	public String signUpPage() {
		return "sign-up";
	}
	
	@PostMapping("/sign-up")
	public String createUserAccount(User user) {
		userService.insertUser(user);
		return "redirect:/login";
	}
	
	@GetMapping
	public String indexPage() {
		return "index";
	}
}
