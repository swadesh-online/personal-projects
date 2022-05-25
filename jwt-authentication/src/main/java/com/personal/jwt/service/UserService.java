package com.personal.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.personal.jwt.model.User;
import com.personal.jwt.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User createUser(User user) {

		return userRepository.save(user);
	}

	public User findUserByEmailId(String emailId) {

		return userRepository.findByEmailId(emailId);
	}	
	
	
	public boolean isAuthenticated(String username, String password) {

		User user = userRepository.findByEmailId(username);
		if (user != null) {
			if (user.getEmailId().equals(username) && BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}

		} else {
			return false;
		}
		return false;
	}

}
