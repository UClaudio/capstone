package com.claudiourru.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claudiourru.capstone.models.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
