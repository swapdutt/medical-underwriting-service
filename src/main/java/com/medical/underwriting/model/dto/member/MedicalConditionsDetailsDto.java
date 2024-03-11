package com.medical.underwriting.model.dto.member;

import com.medical.underwriting.model.dto.medical.LabTestsDto;
import com.medical.underwriting.model.dto.medical.PersonalMedicalConditionsDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class MedicalConditionsDetailsDto {

	Integer medicalConditionsDetailsId;
	List<PersonalMedicalConditionsDto> personalMedicalConditionsList;
	LabTestsDto labTests;

}
