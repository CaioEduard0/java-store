package com.example.JavaStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JavaStore.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
