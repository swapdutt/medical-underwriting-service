package com.medical.underwriting.model.entity.medical;

import java.time.LocalDate;

import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Builder
@ToString
@Entity
@Table(name = "PERSONAL_MEDICAL_CONDITIONS")
public class PersonalMedicalConditions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String id;
	String personalMedicalConditionsId;
	@OneToOne
	DiseaseQuestionnaire diseaseQuestionnaire;
	String nameOfDisease;
	String typeOfDisease;
	String typeOfTreatment;
	String currentStatusOfDisease;
	String typeOfComplication;
	String typeOfBiopsy;
	@LastModifiedDate
	LocalDate lastConsultationDate;
	Integer yearWhenFirstDiagnosisWasTaken;

}
