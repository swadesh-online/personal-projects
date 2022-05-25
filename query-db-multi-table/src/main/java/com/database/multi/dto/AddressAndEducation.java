package com.database.multi.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AddressAndEducation {

	private long candidateId;
	
	private String yearOfPassing;
	
	private String addressType;
	
	private String qualification;

}
