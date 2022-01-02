package com.example.JavaStore.services;

import org.springframework.stereotype.Service;

import com.example.JavaStore.repositories.AddressRepository;

@Service
public class AddressService {

	private final AddressRepository addressRepository;
	
	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
}
