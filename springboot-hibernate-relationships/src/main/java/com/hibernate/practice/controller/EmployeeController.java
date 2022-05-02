package com.hibernate.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.practice.model.Address;
import com.hibernate.practice.model.Employee;
import com.hibernate.practice.model.Skill;
import com.hibernate.practice.repository.EmployeeRepository;

/**
 * For @OneToOne relationship : Employee and Address
 *An {@link Employee} can be mapped to a particular {@link Address} maintaining one-to-one relationship. 
 * 
 * 
 *For @OneToMany relationship : Employee and Skill
 *An {@link Employee} can be mapped to multiple {@link Skill}. 
 *
 *
 *For @ManyToOne relationship : Employee and Department
 *More than One {@link Employee} can be mapped to a single {@link Department}
 *
 *
 *For @ManyToMany relationship : Employee and previous organisations
 *More than One {@link Employee} can be mapped to multiple previous organisations.
 *
 * @author swadeshb
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/{employeeId}")
	public Employee getEmployee(@PathVariable long employeeId) {
		
		return employeeRepository.findById(employeeId).get();
	}
	
	@PostMapping
	public Employee save(@RequestBody Employee emp) {
		
		return employeeRepository.save(emp);
	}
	
	@PutMapping
	public Employee update(@RequestBody Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	@DeleteMapping("{employeeId}")
	public boolean delete(@PathVariable long employeeId) {
		
		employeeRepository.deleteById(employeeId);
		
		if(employeeRepository.findById(employeeId).isEmpty()) {
			return true;
		}
		return false;
	}
}
