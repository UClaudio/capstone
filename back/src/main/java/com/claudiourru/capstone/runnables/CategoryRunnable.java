package com.claudiourru.capstone.runnables;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.claudiourru.capstone.models.Category;
import com.claudiourru.capstone.models.Product;
import com.claudiourru.capstone.services.CategoryService;
import com.claudiourru.capstone.services.ProductService;

@Order(3)
@Component
public class CategoryRunnable implements CommandLineRunner {
	
	@Autowired
	CategoryService cs;
	
	@Autowired
	ProductService ps;

	@Override
	public void run(String... args) throws Exception {
		
		List<Product> prodotti = new ArrayList<>();
		prodotti.add(ps.findById(1l));
		prodotti.add(ps.findById(2l));
		prodotti.add(ps.findById(3l));
		prodotti.add(ps.findById(4l));
		List<Product> prodotti2 = new ArrayList<>();
		prodotti.add(ps.findById(5l));
		prodotti.add(ps.findById(6l));
		prodotti.add(ps.findById(7l));
		prodotti.add(ps.findById(8l));
		
		cs.save(Category.builder()
				.name("primi")
				.products(prodotti)
				.build());
		cs.save(Category.builder()
				.name("dolci")
				.products(prodotti2)
				.build());

	}

}
