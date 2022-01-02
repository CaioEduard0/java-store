package com.example.JavaStore.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.JavaStore.enums.Gender;

@Entity
@Table(name = "CLIENTS")
public class Client extends AbstractEntity {
	
	private String name;
	private String phone;
	private LocalDate birthDate;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id")
//	private User user;

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final Set<Address> adresses = new HashSet<>();
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private final List<Order> orders = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = LocalDate.parse(birthDate);
	}
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public Set<Address> getAdresses() {
		return adresses;
	}

	public List<Order> getOrders() {
		return orders;
	}
}
