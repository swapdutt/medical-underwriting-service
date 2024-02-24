package com.medical.underwriting.repository.member;

import com.medical.underwriting.model.entity.member.MedicalConditionsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalConditionsDetailsRepository extends JpaRepository<MedicalConditionsDetails, Integer> {

    Optional<MedicalConditionsDetails> findMedicalConditionsDetailsByMedicalConditionsDetailsId (String medicalConditionsDetailsId);

}
