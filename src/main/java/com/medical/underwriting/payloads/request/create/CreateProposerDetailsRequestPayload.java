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
public class CreateProposerDetailsRequestPayload {

	@Builder.Default
	String proposerDetailsId = UUID.randomUUID().toString();
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
