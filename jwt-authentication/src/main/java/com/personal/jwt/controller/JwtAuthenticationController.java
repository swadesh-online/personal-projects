package com.personal.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.jwt.config.JwtTokenUtil;
import com.personal.jwt.model.JwtRequest;
import com.personal.jwt.model.JwtResponse;
import com.personal.jwt.model.User;
import com.personal.jwt.service.JwtUserDetailsService;
import com.personal.jwt.service.UserService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		if(authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword())) {

		final User userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token, jwtTokenUtil.getExpirationDateFromToken(token)));
	}else {
		return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
	}
	}

	private boolean authenticate(String username, String password) {
	
		return userService.isAuthenticated(username, password);
	}
	}
