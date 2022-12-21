package com.claudiourru.capstone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claudiourru.capstone.models.Restaurant;

import com.claudiourru.capstone.repositories.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepository rr;

	public Restaurant save(Restaurant Restaurant) throws Exception {
		return rr.save(Restaurant);
	}

	public void deleteById(Long id) throws Exception {
		try {
			rr.delete(rr.findById(id).get());						
		} catch(Exception e) {
			throw new Exception("Restaurant not available");	
		}
		
		throw new Exception("Restaurant not found");
	}
	
	public Restaurant findById(Long id) throws Exception {
		Optional<Restaurant> Restaurant = rr.findById(id);
	       if( Restaurant.isEmpty() ) {
	    	   throw new Exception("Restaurant not available");	    	   
	       }
	       return Restaurant.get();
	}
	
	public List<Restaurant> findAll() throws Exception {
		return rr.findAll();
	}

}
