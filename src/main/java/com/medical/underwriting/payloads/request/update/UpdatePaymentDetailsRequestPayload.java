package com.medical.underwriting.payloads.request.update;

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
public class UpdatePaymentDetailsRequestPayload {

	String nameOfPayor;
	String modeOfPayment;
	String relationshipOfPayor;
	Double amountPaid;
	LocalDate dateOfInstrument;
	LocalDate dateOfReceipt;
	String branchLocation;
	String idProofOfPayor;
	String declarationOfPayor;

}
