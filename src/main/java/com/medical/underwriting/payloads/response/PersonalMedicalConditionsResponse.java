package com.medical.underwriting.payloads.response;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Builder
public class PersonalMedicalConditionsResponse {

	String personalMedicalConditionsId;
	DiseaseQuestionnaireResponse diseaseQuestionnaire;
	String nameOfDisease;
	String typeOfDisease;
	String typeOfTreatment;
	String currentStatusOfDisease;
	String typeOfComplication;
	String typeOfBiopsy;
	LocalDate lastConsultationDate;
	Integer yearWhenFirstDiagnosisWasTaken;

}
