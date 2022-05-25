package com.personal.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.jwt.config.JwtTokenUtil;
import com.personal.jwt.model.User;
import com.personal.jwt.service.JwtUserDetailsService;
import com.personal.jwt.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	JwtUserDetailsService jwtUserDetailsService;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
	
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		return userService.createUser(user);
	}
	
	@GetMapping("/loggedIn")
	public User getLoggedInUser(@RequestHeader("Authorization") String bearerToken) {
	
		String token = bearerToken.substring(7);
		
		String username = jwtTokenUtil.getUsernameFromToken(token);
	
		User loggedInUser=userService.findUserByEmailId(username);
		
		loggedInUser.setPassword("");
		
		return loggedInUser;
		
	}
	
}
