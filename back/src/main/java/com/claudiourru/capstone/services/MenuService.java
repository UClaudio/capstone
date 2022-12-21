package com.claudiourru.capstone.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claudiourru.capstone.models.Menu;
import com.claudiourru.capstone.repositories.MenuRepository;

@Service
public class MenuService {

	@Autowired
	MenuRepository pr;
	
	public Menu save(Menu menu) throws Exception {
		return pr.save(menu);
	}
	
	public Menu findById(Long id) throws Exception {
		Optional<Menu> menu = pr.findById(id);
	       if( menu.isEmpty() ) {
	    	   throw new Exception("Menu not available");	    	   
	       }
	       return menu.get();
	}
	
}
