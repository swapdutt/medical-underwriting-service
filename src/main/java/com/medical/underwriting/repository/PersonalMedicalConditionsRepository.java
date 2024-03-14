package com.medical.underwriting.repository;

import com.medical.underwriting.model.entity.medical.PersonalMedicalConditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalMedicalConditionsRepository extends JpaRepository<PersonalMedicalConditions, Integer> {

	Optional<PersonalMedicalConditions> findPersonalMedicalConditionsByPersonalMedicalConditionsId(
			Integer personalMedicalConditionsId);

}
