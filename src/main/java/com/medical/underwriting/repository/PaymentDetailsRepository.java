package com.medical.underwriting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.underwriting.model.proposal.PaymentDetails;

import java.util.Optional;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, String> {

	Optional<PaymentDetails> findPaymentDetailsByPaymentDetailsId(String paymentDetailsId);

}
