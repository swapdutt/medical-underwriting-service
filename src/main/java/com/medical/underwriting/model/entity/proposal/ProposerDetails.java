package com.medical.underwriting.model.entity.proposal;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "PROPOSER")
public class ProposerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
