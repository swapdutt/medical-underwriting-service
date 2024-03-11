package com.medical.underwriting.model.dto.member;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class MemberDetailsDto {

	Integer memberId;
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
	LifestyleDetailsDto lifestyleDetails;
	MedicalConditionsDetailsDto medicalConditionsDetails;

}
