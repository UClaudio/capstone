package com.claudiourru.capstone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claudiourru.capstone.models.Order;
import com.claudiourru.capstone.services.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	OrderService os;
	
	@PostMapping("/add")
	public void create(@RequestBody Order order) {
		try {
			
			os.save(order);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
