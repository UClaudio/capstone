package com.claudiourru.capstone.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claudiourru.capstone.models.Product;
import com.claudiourru.capstone.models.User;
import com.claudiourru.capstone.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository pr;
	
	public Product save(Product product) throws Exception {
		return pr.save(product);
	}
	
	public Product findById(Long id) throws Exception {
		Optional<Product> product = pr.findById(id);
	       if( product.isEmpty() ) {
	    	   throw new Exception( "Product not available" );	    	   
	       }
	       return product.get();
	}

}
