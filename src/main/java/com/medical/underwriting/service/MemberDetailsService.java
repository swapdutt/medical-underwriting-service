package com.medical.underwriting.service;

import java.util.Optional;

import com.medical.underwriting.utility.UnderwritingUtility;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.medical.underwriting.exception.UnderwritingException;
import com.medical.underwriting.mapper.UnderwritingMapper;
import com.medical.underwriting.model.member.LifestyleDetails;
import com.medical.underwriting.model.member.MedicalConditionsDetails;
import com.medical.underwriting.model.member.MemberDetails;
import com.medical.underwriting.payloads.request.create.CreateLifestyleDetailsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateMemberDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateLifestyleDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateMemberDetailsRequestPayload;
import com.medical.underwriting.payloads.response.LifestyleDetailsResponse;
import com.medical.underwriting.payloads.response.MedicalConditionsResponse;
import com.medical.underwriting.payloads.response.MemberDetailsResponse;
import com.medical.underwriting.repository.LifestyleRepository;
import com.medical.underwriting.repository.MedicalConditionsDetailsRepository;
import com.medical.underwriting.repository.MemberDetailsRepository;
import com.medical.underwriting.utility.UnderwritingConstants;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberDetailsService {

    private final UnderwritingMapper underwritingMapper;
    private final MemberDetailsRepository memberDetailsRepository;
    private final LifestyleRepository lifestyleRepository;
    private final MedicalConditionsDetailsRepository medicalConditionsDetailsRepository;
    private final UnderwritingUtility underwritingUtility;

    /**
     * Business logics related to lifestyle details
     */

    public LifestyleDetailsResponse findLifestyleDetailsById(String lifestyleDetailsId) {
        LifestyleDetails lifestyleDetails = lifestyleRepository.findLifestyleDetailsByLifestyleDetailsId(lifestyleDetailsId)
                .orElseThrow(() -> new UnderwritingException("404", UnderwritingConstants.LIFESTYLE_DETAILS_ID_NOT_FOUND, HttpStatus.NOT_FOUND));
        log.info("Lifestyle Details : {}", lifestyleDetails);
        return LifestyleDetailsResponse.builder().lifestyleDetailsId(lifestyleDetails.getLifestyleDetailsId())
                .amountOfTobaccoProductsConsumptionPerDay(lifestyleDetails.getAmountOfTobaccoProductsConsumptionPerDay())
                .amountOfAlcoholConsumptionPerWeek(lifestyleDetails.getAmountOfAlcoholConsumptionPerWeek())
                .amountOfCigarettesSticksSmokedPerDay(lifestyleDetails.getAmountOfCigarettesSticksSmokedPerDay())
                .durationOfSmokingCigarettes(lifestyleDetails.getDurationOfSmokingCigarettes())
                .frequencyOfAlcoholConsumptionPerDay(lifestyleDetails.getFrequencyOfAlcoholConsumptionPerDay()).build();
    }

    public LifestyleDetailsResponse createLifestyleDetails(CreateLifestyleDetailsRequestPayload payload) {
        log.info("Inside createLifestyleDetails with payload : {}", payload);
        Optional<LifestyleDetails> lifestyle = lifestyleRepository.findLifestyleDetailsByLifestyleDetailsId(payload.getLifestyleDetailsId());
        try {
            if (lifestyle.isEmpty()) {
                if (null != payload.getLifestyleDetailsId()) {
                    payload.setLifestyleDetailsId(underwritingUtility.generateUUID());
                }
                LifestyleDetails lifestyleDetails = lifestyleRepository.save(underwritingMapper.createPayloadToLifestyleDetails(payload));
                log.info("Lifestyle details created : {}", lifestyleDetails);
                return LifestyleDetailsResponse.builder()
                        .lifestyleDetailsId(lifestyleDetails.getLifestyleDetailsId())
                        .amountOfTobaccoProductsConsumptionPerDay(lifestyleDetails.getAmountOfTobaccoProductsConsumptionPerDay())
                        .amountOfAlcoholConsumptionPerWeek(lifestyleDetails.getAmountOfAlcoholConsumptionPerWeek())
                        .amountOfCigarettesSticksSmokedPerDay(lifestyleDetails.getAmountOfCigarettesSticksSmokedPerDay())
                        .durationOfSmokingCigarettes(lifestyleDetails.getDurationOfSmokingCigarettes())
                        .frequencyOfAlcoholConsumptionPerDay(lifestyleDetails.getFrequencyOfAlcoholConsumptionPerDay()).build();
            }
        } catch (UnderwritingException e) {
            throw new UnderwritingException("409", UnderwritingConstants.LIFESTYLE_DETAILS_ID_FOUND, HttpStatus.CONFLICT);
        }
        return null;
    }

    public LifestyleDetailsResponse updateLifestyleDetails(String lifestyleDetailsId, UpdateLifestyleDetailsRequestPayload payload) {
        log.info("Inside updateLifestyleDetails with payload : {}", payload);
        Optional<LifestyleDetails> lifestyle = lifestyleRepository.findLifestyleDetailsByLifestyleDetailsId(lifestyleDetailsId);
        try {
            if (null != payload) {
                log.info("Lifestyle Details before update : {}", lifestyle);
                if (lifestyle.isPresent()) {
                    lifestyle.get().setAmountOfTobaccoProductsConsumptionPerDay(payload.getAmountOfTobaccoProductsConsumptionPerDay());
                    lifestyle.get().setAmountOfAlcoholConsumptionPerWeek(payload.getAmountOfAlcoholConsumptionPerWeek());
                    lifestyle.get().setAmountOfCigarettesSticksSmokedPerDay(payload.getAmountOfCigarettesSticksSmokedPerDay());
                    lifestyle.get().setDurationOfSmokingCigarettes(payload.getDurationOfSmokingCigarettes());
                    lifestyle.get().setFrequencyOfAlcoholConsumptionPerDay(payload.getFrequencyOfAlcoholConsumptionPerDay());
                    lifestyleRepository.save(lifestyle.get());
                    log.info("Lifestyle Details after update : {}", lifestyle);
                    return LifestyleDetailsResponse.builder()
                            .lifestyleDetailsId(lifestyle.get().getLifestyleDetailsId())
                            .amountOfTobaccoProductsConsumptionPerDay(lifestyle.get().getAmountOfTobaccoProductsConsumptionPerDay())
                            .amountOfAlcoholConsumptionPerWeek(lifestyle.get().getAmountOfAlcoholConsumptionPerWeek())
                            .amountOfCigarettesSticksSmokedPerDay(lifestyle.get().getAmountOfCigarettesSticksSmokedPerDay())
                            .durationOfSmokingCigarettes(lifestyle.get().getDurationOfSmokingCigarettes())
                            .frequencyOfAlcoholConsumptionPerDay(lifestyle.get().getFrequencyOfAlcoholConsumptionPerDay()).build();
                } else {
                    throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
                }
            }
        } catch (UnderwritingException e) {
            throw new UnderwritingException("404", UnderwritingConstants.LIFESTYLE_DETAILS_ID_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return null;
    }

    public void deleteLifestyleDetailsById(String lifestyleDetailsId) {
        Optional<LifestyleDetails> lifestyleDetails = lifestyleRepository.findLifestyleDetailsByLifestyleDetailsId(lifestyleDetailsId);
        log.info("Lifestyle Details to delete : {}", lifestyleDetails);
        lifestyleDetails.ifPresent(lifestyleRepository::delete);
    }

    /**
     * Business logics related to medical conditions
     */

    public MedicalConditionsResponse findMedicalConditionsById(String medicalConditionsId) {
        MedicalConditionsDetails medicalConditionsDetails = medicalConditionsDetailsRepository.findMedicalConditionsDetailsByMedicalConditionsDetailsId(medicalConditionsId)
                .orElseThrow(() -> new UnderwritingException("404", UnderwritingConstants.MEDICAL_CONDITIONS_DETAILS_ID_NOT_FOUND, HttpStatus.NOT_FOUND));
        log.info("Medical Conditions Details: {}", medicalConditionsDetails);
        return MedicalConditionsResponse.builder().medicalConditionsDetailsId(medicalConditionsId)
                .personalMedicalConditionsList(underwritingMapper.addPMCtoPMCR(medicalConditionsDetails.getPersonalMedicalConditionsList()))
                .labTests(underwritingMapper.labTestsEntityToResponse(medicalConditionsDetails.getLabTests())).build();
    }

    public MedicalConditionsResponse createMedicalConditions(CreateMedicalConditionsRequestPayload payload) {
        log.info("Inside createMedicalConditions with payload : {}", payload);
        Optional<MedicalConditionsDetails> medicalConditions = medicalConditionsDetailsRepository.findMedicalConditionsDetailsByMedicalConditionsDetailsId(payload.getMedicalConditionsDetailsId());
        try {
            if (medicalConditions.isEmpty()) {
                if (null != payload.getMedicalConditionsDetailsId()) {
                    payload.setMedicalConditionsDetailsId(underwritingUtility.generateUUID());
                }
                MedicalConditionsDetails details = medicalConditionsDetailsRepository.save(underwritingMapper.createPayloadToMedicalConditionsDetails(payload));
                log.info("Medical Conditions Details created : {}", details);
                return MedicalConditionsResponse.builder()
                        .medicalConditionsDetailsId(details.getMedicalConditionsDetailsId())
                        .personalMedicalConditionsList(underwritingMapper.addPMCtoPMCR(details.getPersonalMedicalConditionsList()))
                        .labTests(underwritingMapper.labTestsEntityToResponse(details.getLabTests())).build();
            }
        } catch (UnderwritingException e) {
            throw new UnderwritingException("409", UnderwritingConstants.MEDICAL_CONDITIONS_DETAILS_ID_FOUND, HttpStatus.CONFLICT);
        }
        return null;
    }

    public MedicalConditionsResponse updateMedicalConditions(String medicalConditionsDetailsId, UpdateMedicalConditionsRequestPayload payload) {
        log.info("Inside updateMedicalConditions with payload : {}", payload);
        Optional<MedicalConditionsDetails> medicalConditionsDetails = medicalConditionsDetailsRepository.findMedicalConditionsDetailsByMedicalConditionsDetailsId(medicalConditionsDetailsId);
        try {
            if (null != payload) {
                log.info("Medical Conditions Details before update : {}", medicalConditionsDetails);
                if (medicalConditionsDetails.isPresent()) {
                    medicalConditionsDetails.get().setPersonalMedicalConditionsList(underwritingMapper.addUPMCtoPMC(payload.getPersonalMedicalConditionsList()));
                    medicalConditionsDetails.get().setLabTests(underwritingMapper.updatePayloadToLabTests(payload.getLabTests()));
                    medicalConditionsDetailsRepository.save(medicalConditionsDetails.get());
                    log.info("Medical Conditions Details after update : {}", medicalConditionsDetails);
                    return MedicalConditionsResponse.builder()
                            .medicalConditionsDetailsId(medicalConditionsDetails.get().getMedicalConditionsDetailsId())
                            .personalMedicalConditionsList(underwritingMapper.addPMCtoPMCR(medicalConditionsDetails.get().getPersonalMedicalConditionsList()))
                            .labTests(underwritingMapper.labTestsEntityToResponse(medicalConditionsDetails.get().getLabTests())).build();
                }
            } else {
                throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
            }
        } catch (UnderwritingException e) {
            throw new UnderwritingException("404", UnderwritingConstants.MEDICAL_CONDITIONS_DETAILS_ID_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return null;
    }

    public void deleteMedicalConditionsById(String medicalConditionsDetailsId) {
        Optional<MedicalConditionsDetails> medicalConditionsDetails = medicalConditionsDetailsRepository.findMedicalConditionsDetailsByMedicalConditionsDetailsId(medicalConditionsDetailsId);
        log.info("Medical Conditions Details to delete : {}", medicalConditionsDetails);
        medicalConditionsDetails.ifPresent(medicalConditionsDetailsRepository::delete);
    }

    /**
     * Business logics related to member details
     */

    public MemberDetailsResponse findMemberDetailsById(String memberId) {
        MemberDetails memberDetails = memberDetailsRepository.findMemberDetailsByMemberId(memberId)
                .orElseThrow(() -> new UnderwritingException("404", UnderwritingConstants.MEMBER_DETAILS_ID_NOT_FOUND, HttpStatus.NOT_FOUND));
        log.info("Member Details : {}", memberDetails);
        return MemberDetailsResponse.builder().memberId(memberDetails.getMemberId())
                .firstName(memberDetails.getFirstName()).middleName(memberDetails.getMiddleName())
                .lastName(memberDetails.getLastName()).dateOfBirth(memberDetails.getDateOfBirth())
                .gender(memberDetails.getGender()).memberType(memberDetails.getMemberType())
                .isNewMemberAdded(memberDetails.getIsNewMemberAdded()).bodyMassIndex(memberDetails.getBodyMassIndex())
                .profession(memberDetails.getProfession()).occupationCode(memberDetails.getOccupationCode())
                .annualIncome(memberDetails.getAnnualIncome()).cityOfResidence(memberDetails.getCityOfResidence())
                .stateOfResidence(memberDetails.getStateOfResidence())
                .pinCodeOfResidence(memberDetails.getPinCodeOfResidence())
                .isMandatoryDocumentAvailable(memberDetails.getIsMandatoryDocumentAvailable())
                .baseSumInsured(memberDetails.getBaseSumInsured()).ciRiderRequested(memberDetails.getCiRiderRequested())
                .caRiderRequested(memberDetails.getCaRiderRequested())
                .ciRiderSumInsured(memberDetails.getCiRiderSumInsured())
                .caRiderSumInsured(memberDetails.getCaRiderSumInsured())
                .lifestyleDetails(findLifestyleDetailsById(memberDetails.getLifestyleDetails().getLifestyleDetailsId()))
                .medicalConditionsDetails(findMedicalConditionsById(memberDetails.getMedicalConditionsDetails().getMedicalConditionsDetailsId()))
                .build();
    }

    public MemberDetailsResponse createMemberDetails(CreateMemberDetailsRequestPayload payload) {
        log.info("Inside createMemberDetails with payload : {}", payload);
        Optional<MemberDetails> memberDetails = memberDetailsRepository.findMemberDetailsByMemberId(payload.getMemberId());
        try {
            if (memberDetails.isEmpty()) {
                if (null != payload.getMemberId()) {
                    payload.setMemberId(underwritingUtility.generateUUID());
                }
                MemberDetails member = memberDetailsRepository.save(underwritingMapper.createPayloadToMemberDetails(payload));
                log.info("Member Details created : {}", member);
                return MemberDetailsResponse.builder().memberId(member.getMemberId())
                        .firstName(member.getFirstName()).middleName(member.getMiddleName())
                        .lastName(member.getLastName()).dateOfBirth(member.getDateOfBirth())
                        .gender(member.getGender()).memberType(member.getMemberType())
                        .isNewMemberAdded(member.getIsNewMemberAdded()).bodyMassIndex(member.getBodyMassIndex())
                        .profession(member.getProfession()).occupationCode(member.getOccupationCode())
                        .annualIncome(member.getAnnualIncome()).cityOfResidence(member.getCityOfResidence())
                        .stateOfResidence(member.getStateOfResidence())
                        .pinCodeOfResidence(member.getPinCodeOfResidence())
                        .isMandatoryDocumentAvailable(member.getIsMandatoryDocumentAvailable())
                        .baseSumInsured(member.getBaseSumInsured()).ciRiderRequested(member.getCiRiderRequested())
                        .caRiderRequested(member.getCaRiderRequested())
                        .ciRiderSumInsured(member.getCiRiderSumInsured())
                        .caRiderSumInsured(member.getCaRiderSumInsured())
                        .lifestyleDetails(underwritingMapper.lifestyleDetailsEntityToResponse(member.getLifestyleDetails()))
                        .medicalConditionsDetails(underwritingMapper.medicalConditionsEntityToResponse(member.getMedicalConditionsDetails()))
                        .build();
            }
        } catch (UnderwritingException e) {
            throw new UnderwritingException("409", UnderwritingConstants.MEMBER_DETAILS_ID_FOUND, HttpStatus.CONFLICT);
        }
        return null;
    }

    public MemberDetailsResponse updateMemberDetails(String memberId, UpdateMemberDetailsRequestPayload payload) {
        log.info("Inside updateMemberDetails with payload : {}", payload);
        Optional<MemberDetails> member = memberDetailsRepository.findMemberDetailsByMemberId(memberId);
        try {
            if (null != payload) {
                log.info("Member Details before update : {}", member);
                if (member.isPresent()) {
                    member.get().setFirstName(payload.getFirstName());
                    member.get().setMiddleName(payload.getMiddleName());
                    member.get().setLastName(payload.getLastName());
                    member.get().setDateOfBirth(payload.getDateOfBirth());
                    member.get().setGender(payload.getGender());
                    member.get().setMemberType(payload.getMemberType());
                    member.get().setIsNewMemberAdded(payload.getIsNewMemberAdded());
                    member.get().setBodyMassIndex(payload.getBodyMassIndex());
                    member.get().setProfession(payload.getProfession());
                    member.get().setOccupationCode(payload.getOccupationCode());
                    member.get().setAnnualIncome(payload.getAnnualIncome());
                    member.get().setCityOfResidence(payload.getCityOfResidence());
                    member.get().setStateOfResidence(payload.getStateOfResidence());
                    member.get().setPinCodeOfResidence(payload.getPinCodeOfResidence());
                    member.get().setIsMandatoryDocumentAvailable(payload.getIsMandatoryDocumentAvailable());
                    member.get().setBaseSumInsured(payload.getBaseSumInsured());
                    member.get().setCiRiderRequested(payload.getCiRiderRequested());
                    member.get().setCaRiderRequested(payload.getCaRiderRequested());
                    member.get().setCiRiderSumInsured(payload.getCiRiderSumInsured());
                    member.get().setCaRiderSumInsured(payload.getCaRiderSumInsured());
                    member.get().setLifestyleDetails(underwritingMapper.updatePayloadToLifestyleDetails(payload.getLifestyleDetails()));
                    member.get().setMedicalConditionsDetails(underwritingMapper.updatePayloadToMedicalConditionsDetails(payload.getMedicalConditionsDetails()));
                    memberDetailsRepository.save(member.get());
                    log.info("Member Details after update : {}", member);
                    return MemberDetailsResponse.builder().firstName(member.get().getFirstName())
                            .middleName(member.get().getMiddleName()).lastName(member.get().getLastName())
                            .dateOfBirth(member.get().getDateOfBirth()).gender(member.get().getGender())
                            .memberType(member.get().getMemberType())
                            .isNewMemberAdded(member.get().getIsNewMemberAdded())
                            .bodyMassIndex(member.get().getBodyMassIndex()).profession(member.get().getProfession())
                            .occupationCode(member.get().getOccupationCode())
                            .annualIncome(member.get().getAnnualIncome())
                            .cityOfResidence(member.get().getCityOfResidence())
                            .stateOfResidence(member.get().getStateOfResidence())
                            .pinCodeOfResidence(member.get().getPinCodeOfResidence())
                            .isMandatoryDocumentAvailable(member.get().getIsMandatoryDocumentAvailable())
                            .baseSumInsured(member.get().getBaseSumInsured())
                            .ciRiderRequested(member.get().getCiRiderRequested())
                            .caRiderRequested(member.get().getCaRiderRequested())
                            .ciRiderSumInsured(member.get().getCiRiderSumInsured())
                            .caRiderSumInsured(member.get().getCaRiderSumInsured())
                            .lifestyleDetails(underwritingMapper.lifestyleDetailsEntityToResponse(member.get().getLifestyleDetails()))
                            .medicalConditionsDetails(underwritingMapper.medicalConditionsEntityToResponse(member.get().getMedicalConditionsDetails()))
                            .build();
                } else {
                    throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
                }
            }
        } catch (UnderwritingException e) {
            throw new UnderwritingException("404", UnderwritingConstants.MEMBER_DETAILS_ID_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return null;
    }

    public void deleteMemberDetailsById(String memberDetailsId) {
        Optional<MemberDetails> memberDetails = memberDetailsRepository.findMemberDetailsByMemberId(memberDetailsId);
        log.info("Member Details to delete : {}", memberDetails);
        memberDetails.ifPresent(memberDetailsRepository::delete);
    }

}
