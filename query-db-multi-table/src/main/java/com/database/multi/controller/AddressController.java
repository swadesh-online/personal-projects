package com.database.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.multi.model.Address;
import com.database.multi.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;

	@GetMapping("/{candidateId}")
	public Address getAddressByCandidateId(@PathVariable long candidateId) {
		
		return addressService.fetchByCandidateId(candidateId);
	}
}
