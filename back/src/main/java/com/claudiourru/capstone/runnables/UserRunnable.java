package com.claudiourru.capstone.runnables;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.claudiourru.capstone.models.Cart;
import com.claudiourru.capstone.models.Role;
import com.claudiourru.capstone.models.RoleType;
import com.claudiourru.capstone.models.User;
import com.claudiourru.capstone.services.CartService;
import com.claudiourru.capstone.services.RoleService;
import com.claudiourru.capstone.services.UserService;

@Order(6)
@Component
public class UserRunnable implements CommandLineRunner {

	@Autowired
	UserService us;
	
	@Autowired
	RoleService rs;
	
	@Autowired
	CartService cs;
	
	@Override
	public void run(String... args) throws Exception {
		
		

		us.saveAdmin(User.builder()
				.username("admin")
				.password("admin")
				.fullName("administrator")
				.email("admin@admin.it")
				.active(true)
				.build());

		
	}

}
