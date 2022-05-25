package com.database.multi.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.multi.dto.RequiredFields;
import com.database.multi.repository.CustomRepository;
import com.database.multi.service.CustomService;

@RestController
@RequestMapping("/util")
public class CustomController<T> {
	
	@Autowired
	CustomService customService;
	
	@Autowired
	CustomRepository customRepo;
	

	@GetMapping("/addedu")
	public Collection<T> fetchAll() {
		
		return customRepo.findRequiredFields();
	}
}
