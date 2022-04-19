package com.personal.exhandling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.exhandling.service.ExHandlingService;

@RestController
@RequestMapping("/test")
public class ExHandlingController {
	
	@Autowired
	ExHandlingService exServ;
	
	
	@GetMapping("/dob/{year}")
	public String dob(@PathVariable("year") String year) {
		
		return exServ.dob(year);
	}
}
