package com.database.multi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.multi.model.Address;
import com.database.multi.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepo;

	public Address fetchByCandidateId(long candidateId) {
		
		return addressRepo.findByCandidateId(candidateId);
	}
	
	

}
