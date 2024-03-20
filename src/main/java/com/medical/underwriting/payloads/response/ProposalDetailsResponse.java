package com.medical.underwriting.payloads.response;

import java.time.LocalDate;
import java.util.List;

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
public class ProposalDetailsResponse {

	String proposalDetailsId;
	String sourcingApplication;
	String applicationNumber;
	String policyNumber;
	String productName;
	String productCode;
	String planOption;
	String businessType;
	LocalDate proposalCreationDate;
	String businessMode;
	ProposerDetailsResponse proposerDetails;
	PaymentDetailsResponse paymentDetails;
	List<MemberDetailsResponse> memberDetails;

}
