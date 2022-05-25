package com.database.multi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO) 
	    private long addressId;
	 	
	 	private String addressType;
	 	
	 	private String zipcode;
	 	
	 	private String country;
	 	
	 	private long candidateId;
}
