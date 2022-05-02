package com.hibernate.practice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String firstName;
	
	
	private String lastName;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Skill> skills;
	
	
	@ManyToOne(cascade= CascadeType.ALL)
	private Department department;
	
	
	@ManyToMany(cascade= CascadeType.ALL)
	private List<PreviousOrganisation> previousOrganisations;
}
