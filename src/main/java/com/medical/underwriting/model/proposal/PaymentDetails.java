package com.medical.underwriting.model.proposal;

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
@ToString
@Entity
@Table(name = "PAYMENT")
public class PaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String id;
	String paymentDetailsId;
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
