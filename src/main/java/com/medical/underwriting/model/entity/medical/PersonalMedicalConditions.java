package com.medical.underwriting.model.entity.medical;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "PERSONAL_MEDICAL_CONDITIONS")
public class PersonalMedicalConditions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	@Builder.Default
	String personalMedicalConditionsId = UUID.randomUUID().toString();
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
