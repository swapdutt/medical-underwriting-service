package com.medical.underwriting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.underwriting.model.member.MedicalConditionsDetails;

import java.util.Optional;

@Repository
public interface MedicalConditionsDetailsRepository extends JpaRepository<MedicalConditionsDetails, String> {

	Optional<MedicalConditionsDetails> findMedicalConditionsDetailsByMedicalConditionsDetailsId(
			String medicalConditionsDetailsId);

}
