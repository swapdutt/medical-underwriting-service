package com.medical.underwriting.service;

import java.util.Optional;

import com.medical.underwriting.utility.UnderwritingUtility;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
import com.medical.underwriting.utility.UnderwritingConstants;

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
    private final UnderwritingUtility underwritingUtility;

    /**
     * Business logics related to payment details
     */

    public PaymentDetailsResponse findPaymentDetailsById(String paymentDetailsId) {
        PaymentDetails paymentDetails = paymentDetailsRepository.findPaymentDetailsByPaymentDetailsId(paymentDetailsId)
                .orElseThrow(() -> new UnderwritingException("404", UnderwritingConstants.PAYMENT_DETAILS_ID_NOT_FOUND + paymentDetailsId, HttpStatus.NOT_FOUND));
        log.info("Payment Details : {}", paymentDetails);
        return PaymentDetailsResponse.builder().paymentDetailsId(paymentDetails.getPaymentDetailsId())
                .nameOfPayor(paymentDetails.getNameOfPayor()).modeOfPayment(paymentDetails.getModeOfPayment())
                .relationshipOfPayor(paymentDetails.getRelationshipOfPayor()).amountPaid(paymentDetails.getAmountPaid())
                .dateOfInstrument(paymentDetails.getDateOfInstrument()).dateOfReceipt(paymentDetails.getDateOfReceipt())
                .branchLocation(paymentDetails.getBranchLocation()).idProofOfPayor(paymentDetails.getIdProofOfPayor())
                .declarationOfPayor(paymentDetails.getDeclarationOfPayor()).build();
    }

    public PaymentDetailsResponse createPaymentDetails(CreatePaymentDetailsRequestPayload payload) {
        log.info("Inside createPaymentDetails with payload : {}", payload);
        Optional<PaymentDetails> payment = paymentDetailsRepository.findPaymentDetailsByPaymentDetailsId(payload.getPaymentDetailsId());
        try {
            if (payment.isPresent()) {
                if (null != payload.getPaymentDetailsId()) {
                    payload.setPaymentDetailsId(underwritingUtility.generateUUID());
                }
                PaymentDetails paymentDetails = paymentDetailsRepository.save(underwritingMapper.createPayloadToPaymentDetails(payload));
                log.info("Payment Details created : {}", paymentDetails);
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
        } catch (UnderwritingException e) {
            throw new UnderwritingException("409", UnderwritingConstants.PAYMENT_DETAILS_ID_FOUND + payload.getPaymentDetailsId(), HttpStatus.CONFLICT);
        }
        return null;
    }

    public PaymentDetailsResponse updatePaymentDetails(String paymentDetailsId, UpdatePaymentDetailsRequestPayload payload) {
        log.info("Inside updatePaymentDetails with payload : {}", payload);
        Optional<PaymentDetails> payment = paymentDetailsRepository.findPaymentDetailsByPaymentDetailsId(paymentDetailsId);
        try {
            if (null != payload) {
                log.info("Payment Details before update : {}", payment);
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
                    log.info("Payment Details after update: {}", payment);
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
                    throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
                }
            }
        } catch (UnderwritingException e) {
            throw new UnderwritingException("404", UnderwritingConstants.PAYMENT_DETAILS_ID_NOT_FOUND + paymentDetailsId, HttpStatus.NOT_FOUND);
        }
        return null;
    }

    public void deletePaymentDetailsById(String paymentDetailsId) {
        Optional<PaymentDetails> paymentDetails = paymentDetailsRepository.findPaymentDetailsByPaymentDetailsId(paymentDetailsId);
        log.info("Payment Details to delete : {}", paymentDetails);
        paymentDetails.ifPresent(paymentDetailsRepository::delete);
    }

    /**
     * Business logics related to proposer details
     */

    public ProposerDetailsResponse findProposerDetailsById(String proposerDetailsId) {
        ProposerDetails proposerDetails = proposerDetailsRepository.findProposerDetailsByProposerDetailsId(proposerDetailsId)
                .orElseThrow(() -> new UnderwritingException("404", UnderwritingConstants.PROPOSER_DETAILS_ID_NOT_FOUND + proposerDetailsId, HttpStatus.NOT_FOUND));
        log.info("Proposer Details : {}", proposerDetails);
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
        log.info("Inside createProposerDetails with payload : {}", payload);
        Optional<ProposerDetails> proposer = proposerDetailsRepository.findProposerDetailsByProposerDetailsId(payload.getProposerDetailsId());
        try {
            if (proposer.isPresent()) {
                if (null != payload.getProposerDetailsId()) {
                    payload.setProposerDetailsId(underwritingUtility.generateUUID());
                }
                ProposerDetails proposerDetails = proposerDetailsRepository.save(underwritingMapper.createPayloadToProposerDetails(payload));
                log.info("Proposer Details created : {}", proposerDetails);
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
        } catch (UnderwritingException e) {
            throw new UnderwritingException("409", UnderwritingConstants.PROPOSER_DETAILS_ID_FOUND + payload.getProposerDetailsId(), HttpStatus.CONFLICT);
        }
        return null;
    }

    public ProposerDetailsResponse updateProposerDetails(String proposerDetailsId, UpdateProposerDetailsRequestPayload payload) {
        log.info("Inside updateProposerDetails with payload : {}", payload);
        Optional<ProposerDetails> proposer = proposerDetailsRepository.findProposerDetailsByProposerDetailsId(proposerDetailsId);
        try {
            if (null != payload) {
                log.info("Proposer Details before update: {}", proposer);
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
                    log.info("Proposer Details after update: {}", proposer);
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
                    throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
                }
            }
        } catch (UnderwritingException e) {
            throw new UnderwritingException("404", UnderwritingConstants.PROPOSER_DETAILS_ID_NOT_FOUND + proposerDetailsId, HttpStatus.NOT_FOUND);
        }
        return null;
    }

    public void deleteProposerDetailsById(String proposerDetailsId) {
        Optional<ProposerDetails> proposerDetails = proposerDetailsRepository.findProposerDetailsByProposerDetailsId(proposerDetailsId);
        log.info("Proposer Details to delete: {}", proposerDetails);
        proposerDetails.ifPresent(proposerDetailsRepository::delete);
    }

    /**
     * Business logics related to proposal details
     */

    public ProposalDetailsResponse findProposalDetailsById(String proposalDetailsId) {
        ProposalDetails proposalDetails = proposalDetailsRepository.findProposalDetailsByProposalDetailsId(proposalDetailsId)
                .orElseThrow(() -> new UnderwritingException("404", UnderwritingConstants.PROPOSAL_DETAILS_ID_NOT_FOUND + proposalDetailsId, HttpStatus.NOT_FOUND));
        log.info("Proposal Details : {}", proposalDetails);
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
        log.info("Inside createProposalDetails with payload : {}", payload);
        Optional<ProposalDetails> proposal = proposalDetailsRepository.findProposalDetailsByProposalDetailsId(payload.getProposalDetailsId());
        try {
            if (proposal.isEmpty()) {
                if (null != payload.getProposalDetailsId()) {
                    payload.setProposalDetailsId(underwritingUtility.generateUUID());
                }
                ProposalDetails proposalDetails = proposalDetailsRepository.save(underwritingMapper.createPayloadToProposalDetails(payload));
                log.info("Proposal Details created : {}", proposalDetails);
                return ProposalDetailsResponse.builder().proposalDetailsId(proposalDetails.getProposalDetailsId())
                        .sourcingApplication(proposalDetails.getSourcingApplication())
                        .applicationNumber(proposalDetails.getApplicationNumber())
                        .policyNumber(proposalDetails.getPolicyNumber())
                        .productCode(proposalDetails.getProductCode()).productName(proposalDetails.getProductName())
                        .planOption(proposalDetails.getPlanOption()).businessType(proposalDetails.getBusinessType())
                        .proposalCreationDate(proposalDetails.getProposalCreationDate())
                        .businessMode(proposalDetails.getBusinessMode())
                        .proposerDetails(underwritingMapper.proposerDetailsEntityToResponse(proposalDetails.getProposerDetails()))
                        .paymentDetails(underwritingMapper.paymentDetailsEntityToResponse(proposalDetails.getPaymentDetails()))
                        .memberDetails(underwritingMapper.addMDtoMDR(proposalDetails.getMemberDetails())).build();
            }
        } catch (UnderwritingException e) {
            throw new UnderwritingException("409", UnderwritingConstants.PROPOSAL_DETAILS_ID_FOUND + payload.getProposalDetailsId(), HttpStatus.CONFLICT);
        }
        return null;
    }

    public ProposalDetailsResponse updateProposalDetails(String proposalDetailsId, UpdateProposalDetailsRequestPayload payload) {
        log.info("Inside updateProposalDetails with payload : {}", payload);
        Optional<ProposalDetails> proposalDetails = proposalDetailsRepository.findProposalDetailsByProposalDetailsId(proposalDetailsId);
        try {
            if (null != payload) {
                log.info("Proposal Details before update : {}", proposalDetails);
                if (proposalDetails.isPresent()) {
                    proposalDetails.get().setSourcingApplication(payload.getSourcingApplication());
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
                    log.info("Proposal Details after update : {}", proposalDetails);
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
                            .proposerDetails(underwritingMapper.proposerDetailsEntityToResponse(proposalDetails.get().getProposerDetails()))
                            .paymentDetails(underwritingMapper.paymentDetailsEntityToResponse(proposalDetails.get().getPaymentDetails()))
                            .memberDetails(underwritingMapper.addMDtoMDR(proposalDetails.get().getMemberDetails()))
                            .build();
                } else {
                    throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
                }
            }
        } catch (UnderwritingException e) {
            throw new UnderwritingException("404", UnderwritingConstants.PROPOSAL_DETAILS_ID_NOT_FOUND + proposalDetailsId, HttpStatus.NOT_FOUND);
        }
        return null;
    }

    public void deleteProposalDetailsById(String proposalDetailsId) {
        Optional<ProposalDetails> proposalDetails = proposalDetailsRepository.findProposalDetailsByProposalDetailsId(proposalDetailsId);
        log.info("Proposal Details to delete: {}", proposalDetails);
        proposalDetails.ifPresent(proposalDetailsRepository::delete);
    }

}
