package com.claudiourru.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claudiourru.capstone.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
