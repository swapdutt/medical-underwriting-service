package com.medical.underwriting.model.entity.member;

import com.medical.underwriting.model.entity.medical.LabTests;
import com.medical.underwriting.model.entity.medical.PersonalMedicalConditions;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "MEDICAL_CONDITIONS")
public class MedicalConditionsDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	@Builder.Default
	String medicalConditionsDetailsId = UUID.randomUUID().toString();
	@OneToMany
	List<PersonalMedicalConditions> personalMedicalConditionsList;
	@OneToOne
	LabTests labTests;

}
