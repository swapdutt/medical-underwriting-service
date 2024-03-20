package com.medical.underwriting.payloads.response;

import java.time.LocalDate;

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
public class ProposerDetailsResponse {

	String proposerDetailsId;
	String firstName;
	String middleName;
	String lastName;
	String nationality;
	String countryOfResidence;
	String maritalStatus;
	Double annualIncome;
	Boolean proposerPolicyHolderFlag;
	String nomineeRelationship;
	String profession;
	Boolean isDependentPresent;
	Boolean isDependentCovered;
	LocalDate dateOfVisaExpiration;
	String occupation;
	Double sumInsured;
	LocalDate riskStartDate;
	String employer;
	String designation;

}
