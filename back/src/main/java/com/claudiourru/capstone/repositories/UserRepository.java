package com.claudiourru.capstone.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claudiourru.capstone.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
