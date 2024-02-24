package com.medical.underwriting.repository.medical;

import com.medical.underwriting.model.entity.medical.DiseaseQuestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiseaseQuestionnaireRepository extends JpaRepository<DiseaseQuestionnaire, Integer> {

    Optional<DiseaseQuestionnaire> findDiseaseQuestionnaireByDiseaseQuestionnaireId (String diseaseQuestionnaireId);

}
