package com.claudiourru.capstone.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claudiourru.capstone.models.Menu;
import com.claudiourru.capstone.services.MenuService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/menus")
public class MenuController {

	@Autowired
	MenuService ms;
	
	@GetMapping("/")
	public Menu getById(@RequestParam("id") Long id) throws Exception {
		return ms.findById(id);
	}
	
}
