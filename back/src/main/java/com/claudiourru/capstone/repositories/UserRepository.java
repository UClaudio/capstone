package com.claudiourru.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claudiourru.capstone.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
