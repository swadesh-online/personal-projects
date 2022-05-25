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
@NoArgsConstructor
@AllArgsConstructor
public class Education {

 	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private long educationId;
 	
 	private String qualification;
 	
 	private String yearOfPassing;
 	
 	private long candidateId;
}
