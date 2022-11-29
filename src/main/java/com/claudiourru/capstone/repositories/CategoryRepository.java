package com.claudiourru.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claudiourru.capstone.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
