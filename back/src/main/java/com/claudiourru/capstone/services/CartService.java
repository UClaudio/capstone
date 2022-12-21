package com.claudiourru.capstone.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claudiourru.capstone.models.Cart;
import com.claudiourru.capstone.models.User;
import com.claudiourru.capstone.repositories.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cr;
	
	@Autowired
	UserService us;
	
	public Cart save(Cart cart) throws Exception {
		return cr.save(cart);
	}

	public void deleteById(Long id) throws Exception {
		try {
			cr.delete(cr.findById(id).get());						
		} catch(Exception e) {
			throw new Exception("cart not available");	
		}
		
		throw new Exception("Cart not found");
	}
	
	public Cart findByUserId(Long id) throws Exception {
		Optional<Cart> cart = cr.findByUser(us.findById(id));
		if( cart.isEmpty() ) {
	    	   throw new Exception( "cart not available" );	    	   
	       }else {
	    	   return cart.get();
	    	   
	       }
	}
	
	public Cart findById(Long id) throws Exception {
		Optional<Cart> cart = cr.findById(id);
	       if( cart.isEmpty() ) {
	    	   throw new Exception( "cart not available" );	    	   
	       }
	       return cart.get();
	}
	
	public Cart findByUser(User u) throws Exception {
		Optional<Cart> cart = cr.findByUser(u);
		if( cart.isEmpty() ) {
	    	   throw new Exception( "no cart available for this user" );	    	   
	       }
	       return cart.get();
	}
}
