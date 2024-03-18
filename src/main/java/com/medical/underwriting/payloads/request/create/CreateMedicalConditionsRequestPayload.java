package com.medical.underwriting.payloads.request.create;

import java.util.List;
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
public class CreateMedicalConditionsRequestPayload {

	@Builder.Default
	String medicalConditionsDetailsId = UUID.randomUUID().toString();
	List<CreatePersonalMedicalConditionsRequestPayload> personalMedicalConditionsList;
	CreateLabTestsRequestPayload labTests;

}
