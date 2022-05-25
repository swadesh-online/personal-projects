package com.database.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.multi.model.Education;
import com.database.multi.service.EducationService;

@RestController
@RequestMapping("/education")
public class EducationController {

	@Autowired
	EducationService educationService;
	
	@GetMapping("/{candidateId}")
	public Education fetchByCandidateId(@PathVariable long candidateId) {
		
		return educationService.fetchByCandidateId(candidateId);
	}
}
