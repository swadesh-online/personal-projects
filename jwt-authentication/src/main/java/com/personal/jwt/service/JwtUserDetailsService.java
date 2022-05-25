package com.personal.jwt.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("swadeshbehera98@gmail.com".equals(username)) {
			/**
			 * BCrypt hashing is used here. 
			 */
			return new User("swadeshbehera98@gmail.com", "$2a$12$kv8clIC3D7ItFmOFqoi9l.R1qqjw1UeN92P6FbavaEpG0YcSk2.Ym",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
