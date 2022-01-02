package com.example.JavaStore.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.JavaStore.enums.OrderStatus;
import com.example.JavaStore.enums.Payment;

@Entity
@Table(name = "ORDERS")
public class Order extends AbstractEntity {
	
	private final LocalDateTime orderMoment = LocalDateTime.now();
	private BigDecimal total;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@Enumerated(EnumType.STRING)
	private Payment payment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private final List<OrderDetails> orderItems = new ArrayList<>();

	public LocalDateTime getOrderMoment() {
		return orderMoment;
	}
		
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderDetails> getOrderItems() {
		return orderItems;
	}
}
