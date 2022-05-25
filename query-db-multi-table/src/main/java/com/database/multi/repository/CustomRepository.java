package com.database.multi.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.database.multi.model.Address;

@Repository
public interface CustomRepository extends JpaRepository<Address, Long>{
	
	@Query(" SELECT e.yearOfPassing,a.addressType,e.qualification,a.zipcode FROM Education e INNER JOIN Address a ON e.candidateId = a.candidateId where e.candidateId = 123")
	<T> Collection<T> findRequiredFields();
	
	

	
}
