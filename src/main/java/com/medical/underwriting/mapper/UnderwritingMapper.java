package com.medical.underwriting.mapper;

import com.medical.underwriting.model.dto.medical.DiseaseQuestionnaireDto;
import com.medical.underwriting.model.dto.medical.LabTestsDto;
import com.medical.underwriting.model.dto.medical.PersonalMedicalConditionsDto;
import com.medical.underwriting.model.dto.member.LifestyleDetailsDto;
import com.medical.underwriting.model.dto.member.MedicalConditionsDetailsDto;
import com.medical.underwriting.model.dto.member.MemberDetailsDto;
import com.medical.underwriting.model.dto.proposal.PaymentDetailsDto;
import com.medical.underwriting.model.dto.proposal.ProposalDetailsDto;
import com.medical.underwriting.model.dto.proposal.ProposerDetailsDto;
import com.medical.underwriting.model.entity.medical.DiseaseQuestionnaire;
import com.medical.underwriting.model.entity.medical.LabTests;
import com.medical.underwriting.model.entity.medical.PersonalMedicalConditions;
import com.medical.underwriting.model.entity.member.LifestyleDetails;
import com.medical.underwriting.model.entity.member.MedicalConditionsDetails;
import com.medical.underwriting.model.entity.member.MemberDetails;
import com.medical.underwriting.model.entity.proposal.PaymentDetails;
import com.medical.underwriting.model.entity.proposal.ProposalDetails;
import com.medical.underwriting.model.entity.proposal.ProposerDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UnderwritingMapper {

    /**
     * Proposal related java beans mappings
     */

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "proposalDetailsId", ignore = true)
    @Mapping(target = "applicationNumber", ignore = true)
    @Mapping(target = "policyNumber", ignore = true)
    ProposalDetails proposalDetailsDtoToProposalDetails(ProposalDetailsDto proposalDetailsDto);
    ProposalDetailsDto proposalDetailsToProposalDetailsDto(ProposalDetails proposalDetails);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "proposerDetailsId", ignore = true)
    ProposerDetails proposerDetailsDtoToProposerDetails(ProposerDetailsDto proposerDetailsDto);
    ProposerDetailsDto proposerDetailsToPoProposerDetailsDto(ProposerDetails proposerDetails);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "paymentDetailsId", ignore = true)
    PaymentDetails paymentDetailsDtoToPaymentDetails(PaymentDetailsDto paymentDetailsDto);
    PaymentDetailsDto paymentDetailsToPaymentDetailsDto(PaymentDetails paymentDetails);


    /**
     * Member related java beans mappings
     */

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "memberId", ignore = true)
    MemberDetails memberDetailsDtoToMemberDetails(MemberDetailsDto memberDetailsDto);
    MemberDetailsDto memberDetailsToMemberDetailsDto(MemberDetails memberDetails);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lifestyleDetailsId", ignore = true)
    LifestyleDetails lifestyleDetailsDtoToLifestyleDetails(LifestyleDetailsDto lifestyleDetailsDto);
    LifestyleDetailsDto lifestyleDetailsToLifestyleDetailsDto(LifestyleDetails lifestyleDetails);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "medicalConditionsDetailsId", ignore = true)
    MedicalConditionsDetails medicalConditionsDetailsDtoToMedicalConditionsDetails(MedicalConditionsDetailsDto medicalConditionsDetailsDto);
    MedicalConditionsDetailsDto medicalConditionsDetailsToMedicalConditionsDetailsDto(MedicalConditionsDetails medicalConditionsDetails);

    /**
     * Medical related java beans mappings
     */

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "diseaseQuestionnaireId", ignore = true)
    DiseaseQuestionnaire diseaseQuestionnaireDtoToDiseaseQuestionnaire(DiseaseQuestionnaireDto diseaseQuestionnaireDto);
    DiseaseQuestionnaireDto diseaseQuestionnaireToDiseaseQuestionnaireDto(DiseaseQuestionnaire diseaseQuestionnaire);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "labTestsId", ignore = true)
    LabTests labTestsDtoToLabTests(LabTestsDto labTestsDto);
    LabTestsDto labTestsToLabTestsDto(LabTests labTests);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "personalMedicalConditionsId", ignore = true)
    PersonalMedicalConditions personalMedicalConditionsDtoToPersonalMedicalConditions(PersonalMedicalConditionsDto personalMedicalConditionsDto);
    PersonalMedicalConditionsDto personalMedicalConditionsToPersonalMedicalConditionsDto(PersonalMedicalConditions personalMedicalConditions);

}
