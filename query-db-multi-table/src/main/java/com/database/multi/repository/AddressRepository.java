package com.database.multi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.database.multi.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

		public Address findByCandidateId(long candidateId);
}
