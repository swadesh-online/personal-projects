package com.personal.jwt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/hello")
public class HelloWorldController {


	@GetMapping("")
	public String getMessage() {
		
		return "hello world";
	}
	
}
