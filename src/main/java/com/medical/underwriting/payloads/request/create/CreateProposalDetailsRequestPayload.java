package com.medical.underwriting.payloads.request.create;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

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
public class CreateProposalDetailsRequestPayload {

	@Builder.Default
	String proposalDetailsId = UUID.randomUUID().toString();
	String sourcingApplication;
	@Builder.Default
	String applicationNumber = RandomStringUtils.randomAlphanumeric(5, 8);
	@Builder.Default
	String policyNumber = RandomStringUtils.randomAlphanumeric(5, 8);
	String productName;
	String productCode;
	String planOption;
	String businessType;
	LocalDate proposalCreationDate;
	String businessMode;
	CreateProposerDetailsRequestPayload proposerDetails;
	CreatePaymentDetailsRequestPayload paymentDetails;
	List<CreateMemberDetailsRequestPayload> memberDetails;

}
