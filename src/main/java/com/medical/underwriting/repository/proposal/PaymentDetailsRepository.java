package com.medical.underwriting.repository.proposal;

import com.medical.underwriting.model.entity.proposal.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Integer> {

	Optional<PaymentDetails> findPaymentDetailsByPaymentDetailsId(Integer paymentDetailsId);

}
