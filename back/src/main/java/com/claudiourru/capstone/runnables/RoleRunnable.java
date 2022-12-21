package com.claudiourru.capstone.runnables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.claudiourru.capstone.models.Cart;
import com.claudiourru.capstone.models.Role;
import com.claudiourru.capstone.models.RoleType;
import com.claudiourru.capstone.services.CartService;
import com.claudiourru.capstone.services.RoleService;
import com.claudiourru.capstone.services.UserService;

@Order(1)
@Component
public class RoleRunnable implements CommandLineRunner {

	@Autowired
	RoleService rs;
	
	@Autowired
	CartService cs;
	
	@Autowired
	UserService us;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		rs.save(new Role(RoleType.ROLE_ADMIN));
		rs.save(new Role(RoleType.ROLE_DRIVER));
		rs.save(new Role(RoleType.ROLE_RESTAURATEUR));
		rs.save(new Role(RoleType.ROLE_USER));

	}

}
