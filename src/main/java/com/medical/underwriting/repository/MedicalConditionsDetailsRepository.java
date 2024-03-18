package com.medical.underwriting.repository;

import com.medical.underwriting.model.entity.member.MedicalConditionsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalConditionsDetailsRepository extends JpaRepository<MedicalConditionsDetails, String> {

	Optional<MedicalConditionsDetails> findMedicalConditionsDetailsByMedicalConditionsDetailsId(
			String medicalConditionsDetailsId);

}
