package com.medical.underwriting.model.dto.medical;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PersonalMedicalConditionsDto {

	Integer personalMedicalConditionsId;
	DiseaseQuestionnaireDto diseaseQuestionnaire;
	String nameOfDisease;
	String typeOfDisease;
	String typeOfTreatment;
	String currentStatusOfDisease;
	String typeOfComplication;
	String typeOfBiopsy;
	LocalDate lastConsultationDate;
	Integer yearWhenFirstDiagnosisWasTaken;

}
