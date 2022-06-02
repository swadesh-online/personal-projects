package com.datetime.format.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datetime.format.dto.UserDTO;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@PostMapping("/")
	public UserDTO convertToUserDtoObj(@RequestBody UserDTO userDto) {
		
		return userDto;

	}

}
