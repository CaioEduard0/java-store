package com.example.JavaStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.JavaStore.entities.Product;
import com.example.JavaStore.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public ModelAndView productsPage() {
		ModelAndView mv = new ModelAndView("products");
		mv.addObject("products", productService.findAllProducts());
		return mv;
	}
	
	@GetMapping("/register-product")
	public String registerProductPage() {
		return "register-product";
	}
	
	@PostMapping("/register-product")
	public String insertProduct(Product product) {
		productService.insertProduct(product);
		return "redirect:/";
	}
}
