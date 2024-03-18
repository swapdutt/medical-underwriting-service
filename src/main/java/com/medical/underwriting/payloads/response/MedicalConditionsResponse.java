package com.medical.underwriting.payloads.response;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class MedicalConditionsResponse {

	String medicalConditionsDetailsId;
	List<PersonalMedicalConditionsResponse> personalMedicalConditionsList;
	LabTestsResponse labTests;

}
