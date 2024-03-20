package com.medical.underwriting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.underwriting.model.medical.PersonalMedicalConditions;

import java.util.Optional;

@Repository
public interface PersonalMedicalConditionsRepository extends JpaRepository<PersonalMedicalConditions, String> {

	Optional<PersonalMedicalConditions> findPersonalMedicalConditionsByPersonalMedicalConditionsId(
			String personalMedicalConditionsId);

}
