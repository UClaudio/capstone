package com.claudiourru.capstone.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Product {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
	private Long id;
	
	private String name;
	
	private double price;
}
