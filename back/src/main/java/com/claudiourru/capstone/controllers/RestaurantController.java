package com.claudiourru.capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claudiourru.capstone.models.Restaurant;
import com.claudiourru.capstone.services.RestaurantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/restaurants")
public class RestaurantController {
	
	@Autowired
	RestaurantService rs;
	
	@GetMapping("/getAll")
	public List<Restaurant> getAllUsers() throws Exception {
		return rs.findAll();
	}
}
