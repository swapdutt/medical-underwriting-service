package com.medical.underwriting.model.dto.member;

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
public class MedicalConditionsDetailsDto {

	Integer medicalConditionsDetailsId;
//	List<PersonalMedicalConditionsDto> personalMedicalConditionsList;
//	LabTestsDto labTests;

}
