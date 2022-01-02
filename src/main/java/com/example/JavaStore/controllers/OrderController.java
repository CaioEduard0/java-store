package com.example.JavaStore.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.JavaStore.entities.Order;
import com.example.JavaStore.entities.User;
import com.example.JavaStore.services.ClientService;
import com.example.JavaStore.services.OrderService;
import com.example.JavaStore.services.ProductService;
import com.example.JavaStore.services.UserService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	private final OrderService orderService;
	private final ProductService productService;
	private final UserService userService;
	private final ClientService clientService;

	public OrderController(OrderService orderService, ProductService productService, UserService userService, ClientService clientService) {
		this.orderService = orderService;
		this.productService = productService;
		this.userService = userService;
		this.clientService = clientService;
	}
	
	@GetMapping("/new-order")
	public String orderPage() {
		return "order";
	}
	
	@PostMapping("/new-order")
	public String insertOrder(Order order, @AuthenticationPrincipal UserDetails userDetails) {
		User user = userService.findUserByEmail(userDetails.getUsername());
		//orderService.insertOrder(order, productService.findAllProducts(), user);
		return "redirect:/";
	}
}
