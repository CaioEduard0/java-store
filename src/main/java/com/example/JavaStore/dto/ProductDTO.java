package com.example.JavaStore.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.JavaStore.enums.Category;

public class ProductDTO {
	
	private String productName;
	private String barCode;
	private String manufacturer;
	private BigDecimal price;
	private LocalDate warranty;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	private int quantity;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
