package com.medical.underwriting.model.entity.proposal;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "PAYMENT")
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Builder.Default
    String paymentDetailsId = UUID.randomUUID().toString();
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
