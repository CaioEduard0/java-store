package com.example.JavaStore.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.JavaStore.entities.Client;
import com.example.JavaStore.entities.Order;
import com.example.JavaStore.entities.OrderDetails;
import com.example.JavaStore.entities.Product;
import com.example.JavaStore.entities.User;
import com.example.JavaStore.repositories.ClientRepository;
import com.example.JavaStore.repositories.OrderDetailsRepository;
import com.example.JavaStore.repositories.OrderRepository;
import com.example.JavaStore.repositories.ProductRepository;

@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	private final ClientRepository clientRepository;
	private final OrderDetailsRepository orderDetailsRepository;
	
	public OrderService(OrderRepository orderRepository, ProductRepository productRepository, ClientRepository clientRepository, OrderDetailsRepository orderDetailsRepository) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
		this.clientRepository = clientRepository;
		this.orderDetailsRepository = orderDetailsRepository;
	}
	
	public void insertOrder(Order order, List<OrderDetails> orderDetails, User user) {
		Long id = user.getClient().getId();
		Client client = clientRepository.findById(id).get();
		order.setClient(client);
		client.getOrders().add(order);
		orderRepository.save(order);
		//clientRepository.save(client);
		//OrderDetail orderDetail = new OrderDetail();
		//orderDetail.setOrder(order);
		//orderDetail.setProduct();
		//products.stream().map(p -> )
		for (OrderDetails p : orderDetails) {
			
//			OrderDetails orderDetails = new OrderDetails();
//			
//			orderDetails.setOrder(order);
//			orderDetails.setProduct(p);
//			order.getOrderItems().add(orderDetails);
//			p.getOrderItems().add(orderDetails);
//			orderDetailsRepository.save(orderDetails);
		}
	}
}
