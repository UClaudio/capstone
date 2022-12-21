package com.claudiourru.capstone.runnables;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.claudiourru.capstone.models.Menu;
import com.claudiourru.capstone.models.Restaurant;
import com.claudiourru.capstone.services.MenuService;
import com.claudiourru.capstone.services.RestaurantService;

@Order(5)
@Component
public class RestaurantRunnable implements CommandLineRunner {
	
	@Autowired
	RestaurantService rs;
	
	@Autowired
	MenuService ms;

	@Override
	public void run(String... args) throws Exception {
		
		rs.save(Restaurant.builder()
				.name("pizzeria1")
				.address("Via Pavia, 33, 27026 Garlasco PV")
				.openingTime(LocalTime.of(18,30,0))
				.closingTime(LocalTime.of(22,30,0))
				.open(true)
				.menu(ms.findById(1l))
				.build()
				);
		rs.save(Restaurant.builder()
				.name("hamburgeria1")
				.address("Via Pasubio, Sannazzaro de' Burgondi, PV, Italia")
				.openingTime(LocalTime.of(19,30,0))
				.closingTime(LocalTime.of(23,30,0))
				.open(true)
				.menu(ms.findById(1l))
				.build()
				);
		rs.save(Restaurant.builder()
				.name("pizzeria2")
				.address("Via Vittorio Veneto, Dorno PV, Italia")
				.openingTime(LocalTime.of(19,30,0))
				.closingTime(LocalTime.of(23,30,0))
				.open(true)
				.menu(ms.findById(1l))
				.build()
				);
		rs.save(Restaurant.builder()
				.name("hamburgeria2")
				.address("Via Santa Onorata, Pieve Albignola, PV, Italia")
				.openingTime(LocalTime.of(19,30,0))
				.closingTime(LocalTime.of(23,30,0))
				.open(true)
				.menu(ms.findById(1l))
				.build()
				);
		
	}
	
	
}
