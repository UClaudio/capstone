package com.claudiourru.capstone.runnables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.claudiourru.capstone.models.Product;
import com.claudiourru.capstone.services.ProductService;

@Order(2)
@Component
public class ProductRunnable implements CommandLineRunner {
	
	@Autowired
	ProductService ps;

	@Override
	public void run(String... args) throws Exception {
		ps.save(Product.builder()
				.name("margherita")
				.price(5)
				.build());
		ps.save(Product.builder()
				.name("diavola")
				.price(6)
				.build());
		ps.save(Product.builder()
				.name("capricciosa")
				.price(6)
				.build());
		ps.save(Product.builder()
				.name("4 stagioni")
				.price(7)
				.build());
		ps.save(Product.builder()
				.name("cheesecake")
				.price(4)
				.build());
		ps.save(Product.builder()
				.name("tiramisu")
				.price(4.50)
				.build());
		ps.save(Product.builder()
				.name("frappe")
				.price(3)
				.build());
		ps.save(Product.builder()
				.name("coppa gelato")
				.price(3.50)
				.build());

	}

}
