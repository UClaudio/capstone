package com.claudiourru.capstone.runnables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.claudiourru.capstone.models.Address;
import com.claudiourru.capstone.services.AddressService;

@Component
public class AddressRunnable implements CommandLineRunner {

	@Autowired
	AddressService as;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("ciao2");

		
		
	}

}
