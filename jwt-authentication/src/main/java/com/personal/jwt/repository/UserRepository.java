package com.personal.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.jwt.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmailId(String emailId);
}
