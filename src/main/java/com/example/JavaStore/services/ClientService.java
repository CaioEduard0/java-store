package com.example.JavaStore.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.JavaStore.entities.Address;
import com.example.JavaStore.entities.Client;
import com.example.JavaStore.entities.User;
import com.example.JavaStore.repositories.AddressRepository;
import com.example.JavaStore.repositories.ClientRepository;
import com.example.JavaStore.repositories.UserRepository;

@Service
public class ClientService {
	
	private final ClientRepository clientRepository;
	private final UserRepository userRepository;
	private final AddressRepository addressRepository;

	public ClientService(ClientRepository clientRepository, UserRepository userRepository, AddressRepository addressRepository) {
		this.clientRepository = clientRepository;
		this.userRepository = userRepository;
		this.addressRepository = addressRepository;
	}
	
	public Client findClientById(Long id) {
		return clientRepository.findById(id).orElseThrow();
	}
	
	public void insertClient(Client client, Address address, User user) {
		user.setClient(client);
		//userRepository.save(user);
		client.getAdresses().add(address);
		address.setClient(client);
		//clientRepository.save(client);
		//clientRepository.save(client);
		userRepository.save(user);
	}
}
