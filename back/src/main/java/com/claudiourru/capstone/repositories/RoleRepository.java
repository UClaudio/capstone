package com.claudiourru.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claudiourru.capstone.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
