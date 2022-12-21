package com.claudiourru.capstone.runnables;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.claudiourru.capstone.models.Category;
import com.claudiourru.capstone.models.Menu;
import com.claudiourru.capstone.services.CategoryService;
import com.claudiourru.capstone.services.MenuService;

@Order(4)
@Component
public class MenuRunnable implements CommandLineRunner {
	
	@Autowired
	MenuService ms;
	
	@Autowired
	CategoryService cs;

	@Override
	public void run(String... args) throws Exception {
		
		List<Category> list = new ArrayList<>();
		
		list.add(cs.findById(1l));
		list.add(cs.findById(2l));
		
		ms.save(Menu.builder()
				.name("primo menu")
				.categories(list)
				.build());

	}

}
