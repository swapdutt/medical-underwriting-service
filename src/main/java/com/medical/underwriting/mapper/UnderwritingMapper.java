package com.medical.underwriting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.medical.underwriting.model.dto.proposal.PaymentDetailsDto;
import com.medical.underwriting.model.dto.proposal.ProposalDetailsDto;
import com.medical.underwriting.model.dto.proposal.ProposerDetailsDto;
import com.medical.underwriting.model.entity.medical.DiseaseQuestionnaire;
import com.medical.underwriting.model.entity.medical.LabTests;
import com.medical.underwriting.model.entity.medical.PersonalMedicalConditions;
import com.medical.underwriting.model.entity.member.LifestyleDetails;
import com.medical.underwriting.model.entity.member.MedicalConditionsDetails;
import com.medical.underwriting.model.entity.proposal.PaymentDetails;
import com.medical.underwriting.model.entity.proposal.ProposalDetails;
import com.medical.underwriting.model.entity.proposal.ProposerDetails;
import com.medical.underwriting.payloads.request.create.CreateDiseaseQuestionnaireRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateLabTestsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateLifestyleDetailsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreatePersonalMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateDiseaseQuestionnaireRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateLabTestsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateLifestyleDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdatePersonalMedicalConditionsRequestPayload;

@Mapper
public interface UnderwritingMapper {

	/**
	 * Proposal related java beans mappings
	 */

	@Mapping(target = "proposalDetailsId", ignore = true)
	@Mapping(target = "applicationNumber", ignore = true)
	@Mapping(target = "policyNumber", ignore = true)
	ProposalDetails proposalDetailsDtoToProposalDetails(ProposalDetailsDto proposalDetailsDto);

	ProposalDetailsDto proposalDetailsToProposalDetailsDto(ProposalDetails proposalDetails);

	@Mapping(target = "proposerDetailsId", ignore = true)
	ProposerDetails proposerDetailsDtoToProposerDetails(ProposerDetailsDto proposerDetailsDto);

	ProposerDetailsDto proposerDetailsToPoProposerDetailsDto(ProposerDetails proposerDetails);

	@Mapping(target = "paymentDetailsId", ignore = true)
	PaymentDetails paymentDetailsDtoToPaymentDetails(PaymentDetailsDto paymentDetailsDto);

	PaymentDetailsDto paymentDetailsToPaymentDetailsDto(PaymentDetails paymentDetails);

	/**
	 * Member related java bean mappings
	 */

	@Mapping(target = "id", ignore = true)
	LifestyleDetails createPayloadToLifestyleDetails(CreateLifestyleDetailsRequestPayload payload);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "lifestyleDetailsId", ignore = true)
	LifestyleDetails updatePayloadToLifestyleDetails(UpdateLifestyleDetailsRequestPayload payload);

	@Mapping(target = "id", ignore = true)
	MedicalConditionsDetails createPayloadToMedicalConditionsDetails(CreateMedicalConditionsRequestPayload payload);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "medicalConditionsDetailsId", ignore = true)
	MedicalConditionsDetails updatePayloadToMedicalConditionsDetails(UpdateMedicalConditionsRequestPayload payload);

	/**
	 * Medical related java bean mappings
	 */

	@Mapping(target = "id", ignore = true)
	DiseaseQuestionnaire createPayloadToDiseaseQuestionnaire(CreateDiseaseQuestionnaireRequestPayload payload);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "diseaseQuestionnaireId", ignore = true)
	DiseaseQuestionnaire updatePayloadToDiseaseQuestionnaire(UpdateDiseaseQuestionnaireRequestPayload payload);

	@Mapping(target = "id", ignore = true)
	LabTests createPayloadToLabTests(CreateLabTestsRequestPayload payload);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "labTestsId", ignore = true)
	LabTests updatePayloadToLabTests(UpdateLabTestsRequestPayload payload);

	@Mapping(target = "id", ignore = true)
	PersonalMedicalConditions createPayloadToPersonalMedicalConditions(
			CreatePersonalMedicalConditionsRequestPayload payload);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "personalMedicalConditionsId", ignore = true)
	PersonalMedicalConditions updatePayloadToPersonalMedicalConditions(
			UpdatePersonalMedicalConditionsRequestPayload payload);

}
