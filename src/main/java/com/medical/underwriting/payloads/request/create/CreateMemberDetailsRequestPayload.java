package com.medical.underwriting.payloads.request.create;

import java.time.LocalDate;
import java.util.UUID;

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
public class CreateMemberDetailsRequestPayload {

	@Builder.Default
	String memberId = UUID.randomUUID().toString();
	String firstName;
	String middleName;
	String lastName;
	LocalDate dateOfBirth;
	String gender;
	String memberType;
	Boolean isNewMemberAdded;
	Double bodyMassIndex;
	String profession;
	String occupationCode;
	Double annualIncome;
	String cityOfResidence;
	String stateOfResidence;
	String pinCodeOfResidence;
	Boolean isMandatoryDocumentAvailable;
	Double baseSumInsured;
	Boolean ciRiderRequested;
	Boolean caRiderRequested;
	Double ciRiderSumInsured;
	Double caRiderSumInsured;
	CreateLifestyleDetailsRequestPayload lifestyleDetails;
	CreateMedicalConditionsRequestPayload medicalConditionsDetails;

}
