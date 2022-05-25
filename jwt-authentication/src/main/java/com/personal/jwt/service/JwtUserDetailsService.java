package com.personal.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.personal.jwt.model.User;



@Service
public class JwtUserDetailsService {
	
	@Autowired
	UserService userService;

	public User loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userService.findUserByEmailId(username);
		
		if(user != null) {
			
			return user;
		}else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
	}
}
