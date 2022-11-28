package com.claudiourru.capstone.entities;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Order {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
	private Long id;
	
	private Restaurant pickUpPlace;
	
	private Address deliveryAddress;
	
	private LocalTime pickUpTime;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private LocalTime expectedDeliveryTime;
	
	private List<Long> productId;
	
	private Long userId;
	
}
