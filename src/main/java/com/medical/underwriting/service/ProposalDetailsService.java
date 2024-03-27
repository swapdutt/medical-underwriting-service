package com.medical.underwriting.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.medical.underwriting.constants.UnderwritingConstants;
import com.medical.underwriting.exception.UnderwritingException;
import com.medical.underwriting.mapper.UnderwritingMapper;
import com.medical.underwriting.model.proposal.PaymentDetails;
import com.medical.underwriting.model.proposal.ProposalDetails;
import com.medical.underwriting.model.proposal.ProposerDetails;
import com.medical.underwriting.payloads.request.create.CreatePaymentDetailsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateProposalDetailsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateProposerDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdatePaymentDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateProposalDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateProposerDetailsRequestPayload;
import com.medical.underwriting.payloads.response.PaymentDetailsResponse;
import com.medical.underwriting.payloads.response.ProposalDetailsResponse;
import com.medical.underwriting.payloads.response.ProposerDetailsResponse;
import com.medical.underwriting.repository.PaymentDetailsRepository;
import com.medical.underwriting.repository.ProposalDetailsRepository;
import com.medical.underwriting.repository.ProposerDetailsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProposalDetailsService {

	private final UnderwritingMapper underwritingMapper;
	private final ProposalDetailsRepository proposalDetailsRepository;
	private final ProposerDetailsRepository proposerDetailsRepository;
	private final PaymentDetailsRepository paymentDetailsRepository;

	/**
	 * Business logics related to payment details
	 */

	public PaymentDetailsResponse findPaymentDetailsById(String paymentDetailsId) {

		PaymentDetails paymentDetails = paymentDetailsRepository.findPaymentDetailsByPaymentDetailsId(paymentDetailsId)
				.orElseThrow(() -> new UnderwritingException("404", UnderwritingConstants.PAYMENT_DETAILS_ID_NOT_FOUND,
						HttpStatus.NOT_FOUND));

		log.info("bkhsahbfkja");

		return PaymentDetailsResponse.builder().paymentDetailsId(paymentDetails.getPaymentDetailsId())
				.nameOfPayor(paymentDetails.getNameOfPayor()).modeOfPayment(paymentDetails.getModeOfPayment())
				.relationshipOfPayor(paymentDetails.getRelationshipOfPayor()).amountPaid(paymentDetails.getAmountPaid())
				.dateOfInstrument(paymentDetails.getDateOfInstrument()).dateOfReceipt(paymentDetails.getDateOfReceipt())
				.branchLocation(paymentDetails.getBranchLocation()).idProofOfPayor(paymentDetails.getIdProofOfPayor())
				.declarationOfPayor(paymentDetails.getDeclarationOfPayor()).build();
	}

	public PaymentDetailsResponse createPaymentDetails(CreatePaymentDetailsRequestPayload payload) {

		try {

			if (null != payload) {

				Optional<PaymentDetails> payment = paymentDetailsRepository
						.findPaymentDetailsByPaymentDetailsId(payload.getPaymentDetailsId());

				if (payment.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.PAYMENT_DETAILS_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {

					PaymentDetails paymentDetails = paymentDetailsRepository
							.save(underwritingMapper.createPayloadToPaymentDetails(payload));

					return PaymentDetailsResponse.builder().paymentDetailsId(paymentDetails.getPaymentDetailsId())
							.nameOfPayor(paymentDetails.getNameOfPayor())
							.modeOfPayment(paymentDetails.getModeOfPayment())
							.relationshipOfPayor(paymentDetails.getRelationshipOfPayor())
							.amountPaid(paymentDetails.getAmountPaid())
							.dateOfInstrument(paymentDetails.getDateOfInstrument())
							.dateOfReceipt(paymentDetails.getDateOfReceipt())
							.branchLocation(paymentDetails.getBranchLocation())
							.idProofOfPayor(paymentDetails.getIdProofOfPayor())
							.declarationOfPayor(paymentDetails.getDeclarationOfPayor()).build();

				}

			}

		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public PaymentDetailsResponse updatePaymentDetails(String paymentDetailsId,
			UpdatePaymentDetailsRequestPayload payload) {

		try {

			if (null != payload) {

				Optional<PaymentDetails> payment = paymentDetailsRepository
						.findPaymentDetailsByPaymentDetailsId(paymentDetailsId);

				if (payment.isPresent()) {

					payment.get().setNameOfPayor(payload.getNameOfPayor());
					payment.get().setModeOfPayment(payload.getModeOfPayment());
					payment.get().setRelationshipOfPayor(payload.getRelationshipOfPayor());
					payment.get().setAmountPaid(payload.getAmountPaid());
					payment.get().setDateOfInstrument(payload.getDateOfInstrument());
					payment.get().setDateOfReceipt(payload.getDateOfReceipt());
					payment.get().setBranchLocation(payload.getBranchLocation());
					payment.get().setIdProofOfPayor(payload.getIdProofOfPayor());
					payment.get().setDeclarationOfPayor(payload.getDeclarationOfPayor());

					paymentDetailsRepository.save(payment.get());

					return PaymentDetailsResponse.builder().nameOfPayor(payment.get().getNameOfPayor())
							.modeOfPayment(payment.get().getModeOfPayment())
							.relationshipOfPayor(payment.get().getRelationshipOfPayor())
							.amountPaid(payment.get().getAmountPaid())
							.dateOfInstrument(payment.get().getDateOfInstrument())
							.dateOfReceipt(payment.get().getDateOfReceipt())
							.branchLocation(payment.get().getBranchLocation())
							.idProofOfPayor(payment.get().getIdProofOfPayor())
							.declarationOfPayor(payment.get().getDeclarationOfPayor()).build();

				} else {
					throw new UnderwritingException("404", UnderwritingConstants.PAYMENT_DETAILS_ID_NOT_FOUND,
							HttpStatus.NOT_FOUND);
				}

			}

		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public void deletePaymentDetailsById(String paymentDetailsId) {

		try {
			Optional<PaymentDetails> paymentDetails = paymentDetailsRepository
					.findPaymentDetailsByPaymentDetailsId(paymentDetailsId);
			paymentDetails.ifPresent(paymentDetailsRepository::delete);
		} catch (UnderwritingException e) {
			throw new UnderwritingException("404", UnderwritingConstants.PAYMENT_DETAILS_ID_NOT_FOUND,
					HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * Business logics related to proposer details
	 */

	public ProposerDetailsResponse findProposerDetailsById(String proposerDetailsId) {

		ProposerDetails proposerDetails = proposerDetailsRepository
				.findProposerDetailsByProposerDetailsId(proposerDetailsId)
				.orElseThrow(() -> new UnderwritingException("404", UnderwritingConstants.PROPOSER_DETAILS_ID_NOT_FOUND,
						HttpStatus.NOT_FOUND));

		return ProposerDetailsResponse.builder().proposerDetailsId(proposerDetails.getProposerDetailsId())
				.firstName(proposerDetails.getFirstName()).middleName(proposerDetails.getMiddleName())
				.lastName(proposerDetails.getLastName()).nationality(proposerDetails.getNationality())
				.countryOfResidence(proposerDetails.getCountryOfResidence())
				.maritalStatus(proposerDetails.getMaritalStatus()).annualIncome(proposerDetails.getAnnualIncome())
				.proposerPolicyHolderFlag(proposerDetails.getProposerPolicyHolderFlag())
				.nomineeRelationship(proposerDetails.getNomineeRelationship())
				.profession(proposerDetails.getProfession()).isDependentPresent(proposerDetails.getIsDependentPresent())
				.isDependentCovered(proposerDetails.getIsDependentCovered())
				.dateOfVisaExpiration(proposerDetails.getDateOfVisaExpiration())
				.occupation(proposerDetails.getOccupation()).sumInsured(proposerDetails.getSumInsured())
				.riskStartDate(proposerDetails.getRiskStartDate()).employer(proposerDetails.getEmployer())
				.designation(proposerDetails.getDesignation()).build();
	}

	public ProposerDetailsResponse createProposerDetails(CreateProposerDetailsRequestPayload payload) {

		try {

			if (null != payload) {

				Optional<ProposerDetails> proposer = proposerDetailsRepository
						.findProposerDetailsByProposerDetailsId(payload.getProposerDetailsId());

				if (proposer.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.PROPOSER_DETAILS_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {

					ProposerDetails proposerDetails = proposerDetailsRepository
							.save(underwritingMapper.createPayloadToProposerDetails(payload));

					return ProposerDetailsResponse.builder().proposerDetailsId(proposerDetails.getProposerDetailsId())
							.firstName(proposerDetails.getFirstName()).middleName(proposerDetails.getMiddleName())
							.lastName(proposerDetails.getLastName()).nationality(proposerDetails.getNationality())
							.countryOfResidence(proposerDetails.getCountryOfResidence())
							.maritalStatus(proposerDetails.getMaritalStatus())
							.annualIncome(proposerDetails.getAnnualIncome())
							.proposerPolicyHolderFlag(proposerDetails.getProposerPolicyHolderFlag())
							.nomineeRelationship(proposerDetails.getNomineeRelationship())
							.profession(proposerDetails.getProfession())
							.isDependentPresent(proposerDetails.getIsDependentPresent())
							.isDependentCovered(proposerDetails.getIsDependentCovered())
							.dateOfVisaExpiration(proposerDetails.getDateOfVisaExpiration())
							.occupation(proposerDetails.getOccupation()).sumInsured(proposerDetails.getSumInsured())
							.riskStartDate(proposerDetails.getRiskStartDate()).employer(proposerDetails.getEmployer())
							.designation(proposerDetails.getDesignation()).build();

				}

			}

		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public ProposerDetailsResponse updateProposerDetails(String proposerDetailsId,
			UpdateProposerDetailsRequestPayload payload) {

		try {

			if (null != payload) {

				Optional<ProposerDetails> proposer = proposerDetailsRepository
						.findProposerDetailsByProposerDetailsId(proposerDetailsId);

				if (proposer.isPresent()) {

					proposer.get().setFirstName(payload.getFirstName());
					proposer.get().setMiddleName(payload.getMiddleName());
					proposer.get().setLastName(payload.getLastName());
					proposer.get().setNationality(payload.getNationality());
					proposer.get().setCountryOfResidence(payload.getCountryOfResidence());
					proposer.get().setMaritalStatus(payload.getMaritalStatus());
					proposer.get().setAnnualIncome(payload.getAnnualIncome());
					proposer.get().setProposerPolicyHolderFlag(payload.getProposerPolicyHolderFlag());
					proposer.get().setNomineeRelationship(payload.getNomineeRelationship());
					proposer.get().setProfession(payload.getProfession());
					proposer.get().setIsDependentPresent(payload.getIsDependentPresent());
					proposer.get().setIsDependentCovered(payload.getIsDependentCovered());
					proposer.get().setDateOfVisaExpiration(payload.getDateOfVisaExpiration());
					proposer.get().setOccupation(payload.getOccupation());
					proposer.get().setSumInsured(payload.getSumInsured());
					proposer.get().setRiskStartDate(payload.getRiskStartDate());
					proposer.get().setEmployer(payload.getEmployer());
					proposer.get().setDesignation(payload.getDesignation());

					proposerDetailsRepository.save(proposer.get());

					return ProposerDetailsResponse.builder().firstName(proposer.get().getFirstName())
							.middleName(proposer.get().getMiddleName()).lastName(proposer.get().getLastName())
							.nationality(proposer.get().getNationality())
							.countryOfResidence(proposer.get().getCountryOfResidence())
							.maritalStatus(proposer.get().getMaritalStatus())
							.annualIncome(proposer.get().getAnnualIncome())
							.proposerPolicyHolderFlag(proposer.get().getProposerPolicyHolderFlag())
							.nomineeRelationship(proposer.get().getNomineeRelationship())
							.profession(proposer.get().getProfession())
							.isDependentPresent(proposer.get().getIsDependentPresent())
							.isDependentCovered(proposer.get().getIsDependentCovered())
							.dateOfVisaExpiration(proposer.get().getDateOfVisaExpiration())
							.occupation(proposer.get().getOccupation()).sumInsured(proposer.get().getSumInsured())
							.riskStartDate(proposer.get().getRiskStartDate()).employer(proposer.get().getEmployer())
							.designation(proposer.get().getDesignation()).build();

				} else {
					throw new UnderwritingException("404", UnderwritingConstants.PROPOSER_DETAILS_ID_NOT_FOUND,
							HttpStatus.NOT_FOUND);
				}

			}

		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public void deleteProposerDetailsById(String proposerDetailsId) {

		try {

			Optional<ProposerDetails> proposerDetails = proposerDetailsRepository
					.findProposerDetailsByProposerDetailsId(proposerDetailsId);
			proposerDetails.ifPresent(proposerDetailsRepository::delete);
		} catch (UnderwritingException e) {
			throw new UnderwritingException("404", UnderwritingConstants.PROPOSER_DETAILS_ID_NOT_FOUND,
					HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * Business logics related to proposal details
	 */

	public ProposalDetailsResponse findProposalDetailsById(String proposalDetailsId) {

		ProposalDetails proposalDetails = proposalDetailsRepository
				.findProposalDetailsByProposalDetailsId(proposalDetailsId)
				.orElseThrow(() -> new UnderwritingException("404", UnderwritingConstants.PROPOSAL_DETAILS_ID_NOT_FOUND,
						HttpStatus.NOT_FOUND));

		return ProposalDetailsResponse.builder().proposalDetailsId(proposalDetails.getProposalDetailsId())
				.sourcingApplication(proposalDetails.getSourcingApplication())
				.applicationNumber(proposalDetails.getApplicationNumber())
				.policyNumber(proposalDetails.getPolicyNumber()).productCode(proposalDetails.getProductCode())
				.productName(proposalDetails.getProductName()).planOption(proposalDetails.getPlanOption())
				.businessType(proposalDetails.getBusinessType())
				.proposalCreationDate(proposalDetails.getProposalCreationDate())
				.businessMode(proposalDetails.getBusinessMode())
				.proposerDetails(findProposerDetailsById(proposalDetails.getProposerDetails().getProposerDetailsId()))
				.paymentDetails(findPaymentDetailsById(proposalDetails.getPaymentDetails().getPaymentDetailsId()))
				.memberDetails(underwritingMapper.addMDtoMDR(proposalDetails.getMemberDetails())).build();

	}

	public ProposalDetailsResponse createProposalDetails(CreateProposalDetailsRequestPayload payload) {

		try {

			if (null != payload) {

				Optional<ProposalDetails> proposal = proposalDetailsRepository
						.findProposalDetailsByProposalDetailsId(payload.getProposalDetailsId());

				if (proposal.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.PROPOSAL_DETAILS_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {

					ProposalDetails proposalDetails = proposalDetailsRepository
							.save(underwritingMapper.createPayloadToProposalDetails(payload));

					return ProposalDetailsResponse.builder().proposalDetailsId(proposalDetails.getProposalDetailsId())
							.sourcingApplication(proposalDetails.getSourcingApplication())
							.applicationNumber(proposalDetails.getApplicationNumber())
							.policyNumber(proposalDetails.getPolicyNumber())
							.productCode(proposalDetails.getProductCode()).productName(proposalDetails.getProductName())
							.planOption(proposalDetails.getPlanOption()).businessType(proposalDetails.getBusinessType())
							.proposalCreationDate(proposalDetails.getProposalCreationDate())
							.businessMode(proposalDetails.getBusinessMode())
							.proposerDetails(underwritingMapper
									.proposerDetailsEntityToResponse(proposalDetails.getProposerDetails()))
							.paymentDetails(underwritingMapper
									.paymentDetailsEntityToResponse(proposalDetails.getPaymentDetails()))
							.memberDetails(underwritingMapper.addMDtoMDR(proposalDetails.getMemberDetails())).build();

				}

			}

		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public ProposalDetailsResponse updateProposalDetails(String proposalDetailsId,
			UpdateProposalDetailsRequestPayload payload) {

		try {

			if (null != payload) {

				Optional<ProposalDetails> proposalDetails = proposalDetailsRepository
						.findProposalDetailsByProposalDetailsId(proposalDetailsId);

				if (proposalDetails.isPresent()) {

					proposalDetails.get().setSourcingApplication(payload.getSourcingApplication());
					proposalDetails.get().setApplicationNumber(payload.getApplicationNumber());
					proposalDetails.get().setPolicyNumber(payload.getPolicyNumber());
					proposalDetails.get().setProductName(payload.getProductName());
					proposalDetails.get().setProductCode(payload.getProductCode());
					proposalDetails.get().setPlanOption(payload.getPlanOption());
					proposalDetails.get().setBusinessType(payload.getBusinessType());
					proposalDetails.get().setProposalCreationDate(payload.getProposalCreationDate());
					proposalDetails.get().setBusinessMode(payload.getBusinessMode());
					proposalDetails.get().setProposerDetails(underwritingMapper.updatePayloadToProposerDetails(payload.getProposerDetails()));
					proposalDetails.get().setPaymentDetails(underwritingMapper.updatePayloadToPaymentDetails(payload.getPaymentDetails()));
					proposalDetails.get().setMemberDetails(underwritingMapper.addUMDtoMD(payload.getMemberDetails()));

					proposalDetailsRepository.save(proposalDetails.get());

					return ProposalDetailsResponse.builder()
							.sourcingApplication(proposalDetails.get().getSourcingApplication())
							.applicationNumber(proposalDetails.get().getApplicationNumber())
							.policyNumber(proposalDetails.get().getPolicyNumber())
							.productCode(proposalDetails.get().getProductCode())
							.productName(proposalDetails.get().getProductName())
							.planOption(proposalDetails.get().getPlanOption())
							.businessType(proposalDetails.get().getBusinessType())
							.proposalCreationDate(proposalDetails.get().getProposalCreationDate())
							.businessMode(proposalDetails.get().getBusinessMode())
							.proposerDetails(underwritingMapper
									.proposerDetailsEntityToResponse(proposalDetails.get().getProposerDetails()))
							.paymentDetails(underwritingMapper
									.paymentDetailsEntityToResponse(proposalDetails.get().getPaymentDetails()))
							.memberDetails(underwritingMapper.addMDtoMDR(proposalDetails.get().getMemberDetails()))
							.build();

				} else {
					throw new UnderwritingException("404", UnderwritingConstants.PROPOSAL_DETAILS_ID_NOT_FOUND,
							HttpStatus.NOT_FOUND);
				}

			}

		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public void deleteProposalDetailsById(String proposalDetailsId) {

		try {
			Optional<ProposalDetails> proposalDetails = proposalDetailsRepository
					.findProposalDetailsByProposalDetailsId(proposalDetailsId);
			proposalDetails.ifPresent(proposalDetailsRepository::delete);
		} catch (UnderwritingException e) {
			throw new UnderwritingException("404", UnderwritingConstants.PROPOSAL_DETAILS_ID_NOT_FOUND,
					HttpStatus.NOT_FOUND);
		}

	}

}
