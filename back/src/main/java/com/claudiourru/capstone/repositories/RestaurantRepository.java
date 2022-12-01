package com.claudiourru.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claudiourru.capstone.models.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
