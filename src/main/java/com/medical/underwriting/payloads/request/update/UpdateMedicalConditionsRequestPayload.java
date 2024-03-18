package com.medical.underwriting.payloads.request.update;

import java.util.List;

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
public class UpdateMedicalConditionsRequestPayload {

	List<UpdatePersonalMedicalConditionsRequestPayload> personalMedicalConditionsList;
	UpdateLabTestsRequestPayload labTests;

}
