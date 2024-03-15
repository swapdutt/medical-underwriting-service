package com.medical.underwriting.payloads.request.create;

import java.time.LocalDate;
import java.util.UUID;

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
public class CreatePersonalMedicalConditionsRequestPayload {

	@Builder.Default
	String personalMedicalConditionsId = UUID.randomUUID().toString();
	CreateDiseaseQuestionnaireRequestPayload diseaseQuestionnaire;
	String nameOfDisease;
	String typeOfDisease;
	String typeOfTreatment;
	String currentStatusOfDisease;
	String typeOfComplication;
	String typeOfBiopsy;
	LocalDate lastConsultationDate;
	Integer yearWhenFirstDiagnosisWasTaken;

}
