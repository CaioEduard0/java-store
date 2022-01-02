package com.example.JavaStore.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.JavaStore.enums.Category;

@Entity
@Table(name = "PRODUCTS")
public class Product extends AbstractEntity {
	
	private String productName;
	private String barCode;
	private String manufacturer;
	private BigDecimal price;
	private LocalDate warranty;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private final List<OrderDetails> orderItems = new ArrayList<>();

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDate getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = LocalDate.parse(warranty);
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<OrderDetails> getOrderItems() {
		return orderItems;
	}
}
