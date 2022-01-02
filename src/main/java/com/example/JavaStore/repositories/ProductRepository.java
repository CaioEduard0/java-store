package com.example.JavaStore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JavaStore.entities.Product;
import com.example.JavaStore.enums.Category;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByProductName(String productName);
	
	List<Product> findByCategory(Category category);
}
