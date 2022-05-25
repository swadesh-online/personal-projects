package com.database.multi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.database.multi.model.Education;

public interface EducationRepository extends JpaRepository<Education, Long> {

	public Education findByCandidateId(long candidateId);
}
