package com.medical.underwriting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.medical.underwriting.model.dto.medical.DiseaseQuestionnaireDto;
import com.medical.underwriting.model.dto.medical.LabTestsDto;
import com.medical.underwriting.model.dto.medical.PersonalMedicalConditionsDto;
import com.medical.underwriting.model.dto.proposal.PaymentDetailsDto;
import com.medical.underwriting.model.dto.proposal.ProposalDetailsDto;
import com.medical.underwriting.model.dto.proposal.ProposerDetailsDto;
import com.medical.underwriting.model.entity.medical.DiseaseQuestionnaire;
import com.medical.underwriting.model.entity.medical.LabTests;
import com.medical.underwriting.model.entity.medical.PersonalMedicalConditions;
import com.medical.underwriting.model.entity.member.LifestyleDetails;
import com.medical.underwriting.model.entity.proposal.PaymentDetails;
import com.medical.underwriting.model.entity.proposal.ProposalDetails;
import com.medical.underwriting.model.entity.proposal.ProposerDetails;
import com.medical.underwriting.payloads.request.CreateLifestyleDetailsRequestPayload;
import com.medical.underwriting.payloads.request.UpdateLifestyleDetailsRequestPayload;

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
	 * Medical related java beans mappings
	 */

	@Mapping(target = "diseaseQuestionnaireId", ignore = true)
	DiseaseQuestionnaire diseaseQuestionnaireDtoToDiseaseQuestionnaire(DiseaseQuestionnaireDto diseaseQuestionnaireDto);

	DiseaseQuestionnaireDto diseaseQuestionnaireToDiseaseQuestionnaireDto(DiseaseQuestionnaire diseaseQuestionnaire);

	@Mapping(target = "labTestsId", ignore = true)
	LabTests labTestsDtoToLabTests(LabTestsDto labTestsDto);

	LabTestsDto labTestsToLabTestsDto(LabTests labTests);

	@Mapping(target = "personalMedicalConditionsId", ignore = true)
	PersonalMedicalConditions personalMedicalConditionsDtoToPersonalMedicalConditions(
			PersonalMedicalConditionsDto personalMedicalConditionsDto);

	PersonalMedicalConditionsDto personalMedicalConditionsToPersonalMedicalConditionsDto(
			PersonalMedicalConditions personalMedicalConditions);

	/**
	 * Member related java bean mappings
	 */

	@Mapping(target = "id", ignore = true)
	LifestyleDetails createPayloadToLifestyleDetails(CreateLifestyleDetailsRequestPayload payload);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "lifestyleDetailsId", ignore = true)
	LifestyleDetails updatePayloadToLifestyleDetails(UpdateLifestyleDetailsRequestPayload payload);

}
