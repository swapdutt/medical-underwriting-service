package com.medical.underwriting.service;

import com.medical.underwriting.constants.UnderwritingConstants;
import com.medical.underwriting.exception.UnderwritingException;
import com.medical.underwriting.mapper.UnderwritingMapper;
import com.medical.underwriting.model.dto.proposal.PaymentDetailsDto;
import com.medical.underwriting.model.dto.proposal.ProposalDetailsDto;
import com.medical.underwriting.model.dto.proposal.ProposerDetailsDto;
import com.medical.underwriting.model.entity.proposal.PaymentDetails;
import com.medical.underwriting.model.entity.proposal.ProposalDetails;
import com.medical.underwriting.model.entity.proposal.ProposerDetails;
import com.medical.underwriting.repository.PaymentDetailsRepository;
import com.medical.underwriting.repository.ProposalDetailsRepository;
import com.medical.underwriting.repository.ProposerDetailsRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProposalDetailsService {

	private final UnderwritingMapper underwritingMapper;
	private final ProposalDetailsRepository proposalDetailsRepository;
	private final ProposerDetailsRepository proposerDetailsRepository;
	private final PaymentDetailsRepository paymentDetailsRepository;

	/**
	 * Business logics related to find the records from the database
	 */

	public PaymentDetailsDto findPaymentDetailsById(Integer paymentDetailsId) {

		PaymentDetails paymentDetails = paymentDetailsRepository.findPaymentDetailsByPaymentDetailsId(paymentDetailsId)
				.orElseThrow(() -> new UnderwritingException("404", UnderwritingConstants.PAYMENT_DETAILS_ID_NOT_FOUND,
						HttpStatus.NOT_FOUND));

		return PaymentDetailsDto.builder().paymentDetailsId(paymentDetails.getPaymentDetailsId())
				.nameOfPayor(paymentDetails.getNameOfPayor()).modeOfPayment(paymentDetails.getModeOfPayment())
				.relationshipOfPayor(paymentDetails.getRelationshipOfPayor()).amountPaid(paymentDetails.getAmountPaid())
				.dateOfInstrument(paymentDetails.getDateOfInstrument()).dateOfReceipt(paymentDetails.getDateOfReceipt())
				.branchLocation(paymentDetails.getBranchLocation()).idProofOfPayor(paymentDetails.getIdProofOfPayor())
				.declarationOfPayor(paymentDetails.getDeclarationOfPayor()).build();

	}

	public ProposerDetailsDto findProposerDetailsById(Integer proposerDetailsId) {

		ProposerDetails proposerDetails = proposerDetailsRepository
				.findProposerDetailsByProposerDetailsId(proposerDetailsId)
				.orElseThrow(() -> new UnderwritingException("404", UnderwritingConstants.PROPOSER_DETAILS_ID_NOT_FOUND,
						HttpStatus.NOT_FOUND));

		return ProposerDetailsDto.builder().proposerDetailsId(proposerDetails.getProposerDetailsId())
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

	public ProposalDetailsDto findProposalDetailsById(Integer proposalDetailsId) {

		try {
			if (null != proposalDetailsId) {
				Optional<ProposalDetails> proposalDetails = proposalDetailsRepository
						.findProposalDetailsByProposalDetailsId(proposalDetailsId);
				return proposalDetails.map(underwritingMapper::proposalDetailsToProposalDetailsDto).orElse(null);
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("404", UnderwritingConstants.PROPOSAL_DETAILS_ID_NOT_FOUND,
					HttpStatus.NOT_FOUND);
		}

		return null;

	}

	/**
	 * Business logics related to create new records in database
	 */

	public PaymentDetailsDto createPaymentDetails(PaymentDetailsDto dto) {

		try {
			if (null != dto) {
				Optional<PaymentDetails> paymentDetails = paymentDetailsRepository
						.findPaymentDetailsByPaymentDetailsId(dto.getPaymentDetailsId());
				if (paymentDetails.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.PAYMENT_DETAILS_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {
					PaymentDetails payment = paymentDetailsRepository
							.save(underwritingMapper.paymentDetailsDtoToPaymentDetails(dto));
					return PaymentDetailsDto.builder().paymentDetailsId(payment.getPaymentDetailsId())
							.nameOfPayor(payment.getNameOfPayor()).modeOfPayment(payment.getModeOfPayment())
							.relationshipOfPayor(payment.getRelationshipOfPayor()).amountPaid(payment.getAmountPaid())
							.dateOfInstrument(payment.getDateOfInstrument()).dateOfReceipt(payment.getDateOfReceipt())
							.branchLocation(payment.getBranchLocation()).idProofOfPayor(payment.getIdProofOfPayor())
							.declarationOfPayor(payment.getDeclarationOfPayor()).build();
				}
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public ProposerDetailsDto createProposerDetails(ProposerDetailsDto dto) {

		try {
			if (null != dto) {
				Optional<ProposerDetails> proposerDetails = proposerDetailsRepository
						.findProposerDetailsByProposerDetailsId(dto.getProposerDetailsId());
				if (proposerDetails.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.PROPOSER_DETAILS_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {
					ProposerDetails proposer = proposerDetailsRepository
							.save(underwritingMapper.proposerDetailsDtoToProposerDetails(dto));
					return ProposerDetailsDto.builder().proposerDetailsId(proposer.getProposerDetailsId())
							.firstName(proposer.getFirstName()).middleName(proposer.getMiddleName())
							.lastName(proposer.getLastName()).nationality(proposer.getNationality())
							.countryOfResidence(proposer.getCountryOfResidence())
							.maritalStatus(proposer.getMaritalStatus()).annualIncome(proposer.getAnnualIncome())
							.proposerPolicyHolderFlag(proposer.getProposerPolicyHolderFlag())
							.nomineeRelationship(proposer.getNomineeRelationship()).profession(proposer.getProfession())
							.isDependentPresent(proposer.getIsDependentPresent())
							.isDependentCovered(proposer.getIsDependentCovered())
							.dateOfVisaExpiration(proposer.getDateOfVisaExpiration())
							.occupation(proposer.getOccupation()).sumInsured(proposer.getSumInsured())
							.riskStartDate(proposer.getRiskStartDate()).employer(proposer.getEmployer())
							.designation(proposer.getDesignation()).build();
				}
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public ProposalDetailsDto createProposalDetails(ProposalDetailsDto dto) {

		try {
			if (null != dto) {
				Optional<ProposalDetails> proposalDetails = proposalDetailsRepository
						.findProposalDetailsByProposalDetailsId(dto.getProposalDetailsId());
				if (proposalDetails.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.PROPOSAL_DETAILS_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {
					return underwritingMapper.proposalDetailsToProposalDetailsDto(proposalDetailsRepository
							.save(underwritingMapper.proposalDetailsDtoToProposalDetails(dto)));
				}
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	/**
	 * Business logics related to update the records in database
	 */

	public PaymentDetailsDto updatePaymentDetails(PaymentDetailsDto dto) {

		try {
			if (null != dto) {
				Optional<PaymentDetails> paymentDetails = paymentDetailsRepository
						.findPaymentDetailsByPaymentDetailsId(dto.getPaymentDetailsId());
				if (paymentDetails.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.PAYMENT_DETAILS_ID_NOT_FOUND,
							HttpStatus.NOT_FOUND);
				} else {
					PaymentDetails payment = paymentDetailsRepository
							.save(underwritingMapper.paymentDetailsDtoToPaymentDetails(dto));
					return PaymentDetailsDto.builder().paymentDetailsId(payment.getPaymentDetailsId())
							.nameOfPayor(payment.getNameOfPayor()).modeOfPayment(payment.getModeOfPayment())
							.relationshipOfPayor(payment.getRelationshipOfPayor()).amountPaid(payment.getAmountPaid())
							.dateOfInstrument(payment.getDateOfInstrument()).dateOfReceipt(payment.getDateOfReceipt())
							.branchLocation(payment.getBranchLocation()).idProofOfPayor(payment.getIdProofOfPayor())
							.declarationOfPayor(payment.getDeclarationOfPayor()).build();
				}
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public ProposerDetailsDto updateProposerDetails(ProposerDetailsDto dto) {

		try {
			if (null != dto) {
				Optional<ProposerDetails> proposerDetails = proposerDetailsRepository
						.findProposerDetailsByProposerDetailsId(dto.getProposerDetailsId());
				if (proposerDetails.isPresent()) {
					throw new UnderwritingException("404", UnderwritingConstants.PROPOSER_DETAILS_ID_NOT_FOUND,
							HttpStatus.NOT_FOUND);
				} else {
					ProposerDetails proposer = proposerDetailsRepository
							.save(underwritingMapper.proposerDetailsDtoToProposerDetails(dto));
					return ProposerDetailsDto.builder().proposerDetailsId(proposer.getProposerDetailsId())
							.firstName(proposer.getFirstName()).middleName(proposer.getMiddleName())
							.lastName(proposer.getLastName()).nationality(proposer.getNationality())
							.countryOfResidence(proposer.getCountryOfResidence())
							.maritalStatus(proposer.getMaritalStatus()).annualIncome(proposer.getAnnualIncome())
							.proposerPolicyHolderFlag(proposer.getProposerPolicyHolderFlag())
							.nomineeRelationship(proposer.getNomineeRelationship()).profession(proposer.getProfession())
							.isDependentPresent(proposer.getIsDependentPresent())
							.isDependentCovered(proposer.getIsDependentCovered())
							.dateOfVisaExpiration(proposer.getDateOfVisaExpiration())
							.occupation(proposer.getOccupation()).sumInsured(proposer.getSumInsured())
							.riskStartDate(proposer.getRiskStartDate()).employer(proposer.getEmployer())
							.designation(proposer.getDesignation()).build();
				}
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public ProposalDetailsDto updateProposalDetails(ProposalDetailsDto dto) {

		try {
			if (null != dto) {
				Optional<ProposalDetails> proposalDetails = proposalDetailsRepository
						.findProposalDetailsByProposalDetailsId(dto.getProposalDetailsId());
				if (proposalDetails.isEmpty()) {
					throw new UnderwritingException("404", UnderwritingConstants.PROPOSAL_DETAILS_ID_NOT_FOUND,
							HttpStatus.NOT_FOUND);
				} else {
					return underwritingMapper.proposalDetailsToProposalDetailsDto(proposalDetailsRepository
							.save(underwritingMapper.proposalDetailsDtoToProposalDetails(dto)));
				}
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	/**
	 * Business logics related to delete the records from the database
	 */

	public void deletePaymentDetailsById(Integer paymentDetailsId) {

		try {
			if (null != paymentDetailsId) {
				Optional<PaymentDetails> paymentDetails = paymentDetailsRepository
						.findPaymentDetailsByPaymentDetailsId(paymentDetailsId);
				paymentDetails.ifPresent(paymentDetailsRepository::delete);
			} else {
				throw new UnderwritingException("404", UnderwritingConstants.PAYMENT_DETAILS_ID_NOT_FOUND,
						HttpStatus.NOT_FOUND);
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

	}

	public void deleteProposerDetailsById(Integer proposerDetailsId) {

		try {
			if (null != proposerDetailsId) {
				Optional<ProposerDetails> proposerDetails = proposerDetailsRepository
						.findProposerDetailsByProposerDetailsId(proposerDetailsId);
				proposerDetails.ifPresent(proposerDetailsRepository::delete);
			} else {
				throw new UnderwritingException("404", UnderwritingConstants.PROPOSER_DETAILS_ID_NOT_FOUND,
						HttpStatus.NOT_FOUND);
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

	}

	public void deleteProposalDetailsById(Integer proposalDetailsId) {

		try {
			if (null != proposalDetailsId) {
				Optional<ProposalDetails> proposalDetails = proposalDetailsRepository
						.findProposalDetailsByProposalDetailsId(proposalDetailsId);
				proposalDetails.ifPresent(proposalDetailsRepository::delete);
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

	}

}
