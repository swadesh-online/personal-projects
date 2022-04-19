package com.personal.exhandling.service;

import org.springframework.stereotype.Service;

import com.personal.exhandling.exception.FutureDateException;
import com.personal.exhandling.exception.VeryEarlyDateException;

@Service
public class ExHandlingService {

	public String dob(String year) {
		int y = Integer.parseInt(year);
		if(y<1922) {
			
			throw new VeryEarlyDateException();
			
		
		}else if(y>2022) {
			
			throw new FutureDateException();
			
			//Localized Exception handling
			/* but , the custom message can't be seen in the response,
			 * a field in application.properties need to be enabled. 
			 * 
			 * server.error.include-message=always
			 * 
			 * throw new ResponseStatusException( HttpStatus.BAD_REQUEST,
			 * "The year is in Future! ");
			 */
		}else {
			
			return "Valid";
		}
		
	}
}
