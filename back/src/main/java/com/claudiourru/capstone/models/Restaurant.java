package com.claudiourru.capstone.models;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "restaurants")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id", nullable = false)
	private Long id;

	private String name;
	
	
	private String address;
	
	private LocalTime openingTime;
	
	private LocalTime closingTime;
	
	private boolean open = false;
	
	
	@OneToOne
	private Menu menu;
}
