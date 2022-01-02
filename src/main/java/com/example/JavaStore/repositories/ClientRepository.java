package com.example.JavaStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JavaStore.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {}
