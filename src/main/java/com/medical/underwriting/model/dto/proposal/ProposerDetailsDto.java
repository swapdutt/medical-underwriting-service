package com.medical.underwriting.model.dto.proposal;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProposerDetailsDto {

	Integer proposerDetailsId;
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
