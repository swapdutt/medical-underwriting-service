package com.medical.underwriting.model.member;

import java.util.List;

import com.medical.underwriting.model.medical.LabTests;
import com.medical.underwriting.model.medical.PersonalMedicalConditions;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "MEDICAL_CONDITIONS")
public class MedicalConditionsDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String id;
	String medicalConditionsDetailsId;
	@OneToMany
	List<PersonalMedicalConditions> personalMedicalConditionsList;
	@OneToOne
	LabTests labTests;

}
