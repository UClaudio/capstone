package com.claudiourru.capstone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claudiourru.capstone.models.Order;
import com.claudiourru.capstone.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository or;
	
	public Order save(Order order) throws Exception {
		return or.save(order);
	}
}
