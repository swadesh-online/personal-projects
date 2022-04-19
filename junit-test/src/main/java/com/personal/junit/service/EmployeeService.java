package com.personal.junit.service;

import org.springframework.stereotype.Service;

import com.personal.junit.dto.Employee;

@Service
public class EmployeeService {

	public Employee getEmployee() {
		
		Employee emp = new Employee();
		emp.setName("Lalatendu");
		emp.setEmpId("9090");
		emp.setDept("FMM");
		
		return emp;		
	}

}
