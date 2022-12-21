package com.claudiourru.capstone.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.claudiourru.capstone.models.User;
import com.claudiourru.capstone.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	RoleService rs;
	
	@Autowired
	private UserRepository ur;
	
	public User save(User user) throws Exception {
		user.setPassword(encoder.encode(user.getPassword()));
		return ur.save(user);
	}
	
	public User saveUser(User user) throws Exception {
		user.addRole(rs.findById(4l));
		return this.save(user);
	}
	
	public User saveAdmin(User user) throws Exception {
		user.addRole(rs.findById(1l));
		return this.save(user);
	}
	
	public User saveDriver(User user) throws Exception {
		user.addRole(rs.findById(2l));
		return this.save(user);
	}
	
	public User saveRestaurant(User user) throws Exception {
		user.addRole(rs.findById(3l));
		return this.save(user);
	}

	public void deleteById(Long id) throws Exception {
		try {
			ur.delete(ur.findById(id).get());						
		} catch(Exception e) {
			throw new Exception("Indirizzo not available");	
		}
		
		throw new Exception("Address not found");
	}
	
	public User findById(Long id) throws Exception {
		Optional<User> user = ur.findById(id);
	       if( user.isEmpty() ) {
	    	   throw new Exception( "Indirizzo not available" );	    	   
	       }
	       return user.get();
	}

	public void update(User u) {
		// TODO Auto-generated method stub
		
	}

	public Object findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
