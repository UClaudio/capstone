package com.claudiourru.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claudiourru.capstone.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
