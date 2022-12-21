package com.claudiourru.capstone.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claudiourru.capstone.models.Address;
import com.claudiourru.capstone.models.Role;
import com.claudiourru.capstone.repositories.AddressRepository;
import com.claudiourru.capstone.repositories.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository rr;

	public Role save(Role role) throws Exception {
		return rr.save(role);
	}

	public void deleteById(Long id) throws Exception {
		try {
			rr.delete(rr.findById(id).get());						
		} catch(Exception e) {
			throw new Exception("role not available");	
		}
		
		throw new Exception("role not found");
	}
	
	public Role findById(Long id) throws Exception {
		Optional<Role> role = rr.findById(id);
	       if( role.isEmpty() ) {
	    	   throw new Exception( "Indirizzo not available" );	    	   
	       }
	       return role.get();
	}
	
}
