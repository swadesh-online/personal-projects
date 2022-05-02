package com.hibernate.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.practice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	

}
