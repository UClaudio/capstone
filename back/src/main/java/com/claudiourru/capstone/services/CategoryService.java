package com.claudiourru.capstone.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claudiourru.capstone.models.Category;
import com.claudiourru.capstone.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository pr;
	
	public Category save(Category category) throws Exception {
		return pr.save(category);
	}
	
	public Category findById(Long id) throws Exception {
		Optional<Category> category = pr.findById(id);
	       if( category.isEmpty() ) {
	    	   throw new Exception( "Category not available" );	    	   
	       }
	       return category.get();
	}

}
