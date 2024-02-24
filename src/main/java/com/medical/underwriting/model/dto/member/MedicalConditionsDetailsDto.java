package com.medical.underwriting.model.dto.member;

import com.medical.underwriting.model.dto.medical.LabTestsDto;
import com.medical.underwriting.model.dto.medical.PersonalMedicalConditionsDto;
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
public class MedicalConditionsDetailsDto {

    Integer id;
    String medicalConditionsDetailsId = UUID.randomUUID().toString();
    List<PersonalMedicalConditionsDto> personalMedicalConditionsList;
    LabTestsDto labTests;

}
