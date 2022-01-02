package com.example.JavaStore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.JavaStore.entities.Product;
import com.example.JavaStore.enums.Category;
import com.example.JavaStore.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}
	
	public Product findProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product.get();
	}
	
	public List<Product> findProductsByName(String name) {
		return productRepository.findByProductName(name);
	}
	
	public List<Product> findProductsByCategory(Category category) {
		return productRepository.findByCategory(category);
	}
	
	public void insertProduct(Product product) {
		//product.setCategory(product.getCategory().name());
		productRepository.save(product);
	}
}
