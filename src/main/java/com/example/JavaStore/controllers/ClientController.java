package com.example.JavaStore.controllers;

import java.util.Set;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.JavaStore.entities.Address;
import com.example.JavaStore.entities.Client;
import com.example.JavaStore.entities.User;
import com.example.JavaStore.services.ClientService;
import com.example.JavaStore.services.UserService;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	private final ClientService clientService;
	private final UserService userService;
	
	public ClientController(ClientService clientService, UserService userService) {
		this.clientService = clientService;
		this.userService = userService;
	}

	@GetMapping("/register-client")
	public String registerClientPage() {
		return "register-client";
	}
	
	@PostMapping("/register-client")
	public String insertClient(@AuthenticationPrincipal UserDetails userDetails, Client client, Address address) {
		User user = userService.findUserByEmail(userDetails.getUsername());
		clientService.insertClient(client, address, user);
		Set<Address> add = client.getAdresses();
		
		Client fdf  = address.getClient();
		Address kkk = address;
		return "redirect:/";
	}
}
