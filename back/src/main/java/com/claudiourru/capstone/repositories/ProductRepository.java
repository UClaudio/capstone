package com.claudiourru.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claudiourru.capstone.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
