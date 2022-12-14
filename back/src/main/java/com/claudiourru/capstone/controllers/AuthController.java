package com.claudiourru.capstone.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claudiourru.capstone.models.User;
import com.claudiourru.capstone.security.JwtUtils;
import com.claudiourru.capstone.security.LoginRequest;
import com.claudiourru.capstone.security.LoginResponse;
import com.claudiourru.capstone.security.UserDetailsImpl;
import com.claudiourru.capstone.services.UserService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserService us;
	
	
	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
		);

		authentication.getAuthorities();
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = ( UserDetailsImpl ) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map( GrantedAuthority::getAuthority )
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new LoginResponse(jwt, userDetails.getId(), userDetails.getUsername(),
						userDetails.getEmail(), roles, userDetails.getExpirationTime()));
	}
	
	@PostMapping("/register")
	public void create(@RequestBody User user) {
		try {
			
			us.saveUser(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}