package com.database.multi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.multi.model.Education;
import com.database.multi.repository.EducationRepository;

@Service
public class EducationService {

	@Autowired
	EducationRepository educationRepo;

	public Education fetchByCandidateId(long candidateId) {
	
		return educationRepo.findByCandidateId(candidateId);
	}
	

	
}
