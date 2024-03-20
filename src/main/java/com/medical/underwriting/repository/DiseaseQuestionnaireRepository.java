package com.medical.underwriting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.underwriting.model.medical.DiseaseQuestionnaire;

import java.util.Optional;

@Repository
public interface DiseaseQuestionnaireRepository extends JpaRepository<DiseaseQuestionnaire, String> {

	Optional<DiseaseQuestionnaire> findDiseaseQuestionnaireByDiseaseQuestionnaireId(String diseaseQuestionnaireId);

}
