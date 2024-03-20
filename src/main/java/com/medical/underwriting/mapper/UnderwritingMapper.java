package com.medical.underwriting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.medical.underwriting.model.medical.DiseaseQuestionnaire;
import com.medical.underwriting.model.medical.LabTests;
import com.medical.underwriting.model.medical.PersonalMedicalConditions;
import com.medical.underwriting.model.member.LifestyleDetails;
import com.medical.underwriting.model.member.MedicalConditionsDetails;
import com.medical.underwriting.model.member.MemberDetails;
import com.medical.underwriting.model.proposal.PaymentDetails;
import com.medical.underwriting.model.proposal.ProposalDetails;
import com.medical.underwriting.model.proposal.ProposerDetails;
import com.medical.underwriting.payloads.request.create.CreateDiseaseQuestionnaireRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateLabTestsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateLifestyleDetailsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateMemberDetailsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreatePaymentDetailsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreatePersonalMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateProposalDetailsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateProposerDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateDiseaseQuestionnaireRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateLabTestsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateLifestyleDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateMemberDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdatePaymentDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdatePersonalMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateProposalDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateProposerDetailsRequestPayload;

@Mapper
public interface UnderwritingMapper {

	/**
	 * Proposal related java beans mappings
	 */

	@Mapping(target = "id", ignore = true)
	PaymentDetails createPayloadToPaymentDetails(CreatePaymentDetailsRequestPayload payload);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "paymentDetailsId", ignore = true)
	PaymentDetails updatePayloadToPaymentDetails(UpdatePaymentDetailsRequestPayload payload);

	@Mapping(target = "id", ignore = true)
	ProposerDetails createPayloadToProposerDetails(CreateProposerDetailsRequestPayload payload);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "proposerDetailsId", ignore = true)
	ProposerDetails updatePayloadToProposerDetails(UpdateProposerDetailsRequestPayload payload);

	@Mapping(target = "id", ignore = true)
	ProposalDetails createPayloadToProposalDetails(CreateProposalDetailsRequestPayload payload);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "proposalDetailsId", ignore = true)
	@Mapping(target = "applicationNumber", ignore = true)
	@Mapping(target = "policyNumber", ignore = true)
	ProposalDetails updatePayloadToProposalDetails(UpdateProposalDetailsRequestPayload payload);

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

	@Mapping(target = "id", ignore = true)
	MemberDetails createPayloadToMemberDetails(CreateMemberDetailsRequestPayload payload);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "memberId", ignore = true)
	MemberDetails updatePayloadToMemberDetails(UpdateMemberDetailsRequestPayload payload);

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
