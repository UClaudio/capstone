package com.claudiourru.capstone.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claudiourru.capstone.DTOs.CartDTO;
import com.claudiourru.capstone.models.Cart;
import com.claudiourru.capstone.models.Product;
import com.claudiourru.capstone.models.User;
import com.claudiourru.capstone.services.CartService;
import com.claudiourru.capstone.services.ProductService;
import com.claudiourru.capstone.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	CartService cs;

	@Autowired
	UserService us;

	@Autowired
	ProductService ps;

	@PutMapping("/{id}/addProduct")
	public Cart update(@PathVariable("id") Long userId, @RequestBody Long productId) throws Exception {

		Cart cart = cs.findByUserId(userId);
		cart.addToCart(ps.findById(productId));
		return cs.save(cart);
	}
	
	@PutMapping("/{id}/removeProduct")
	public Cart deleteProduct(@PathVariable("id") Long cartId, @RequestBody Long productId) throws Exception {

		Cart cart = cs.findById(cartId);
		cart.removeFromCart(ps.findById(productId));
		return cs.save(cart);
	}

	@PostMapping("")
	public Cart create(@RequestBody CartDTO cartDTO) throws Exception {

		Cart cart = Cart.builder().user(us.findById(cartDTO.getUserId())).products(new ArrayList<Product>()).build();
		cart.addToCart(ps.findById(cartDTO.getProductId()));

		return cs.save(cart);
	}

	@DeleteMapping("/deleteProduct")
	public void update(@RequestBody Long productId) throws Exception {
		cs.deleteById(productId);
	}

}
