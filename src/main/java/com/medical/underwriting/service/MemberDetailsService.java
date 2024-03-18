package com.medical.underwriting.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.medical.underwriting.constants.UnderwritingConstants;
import com.medical.underwriting.exception.UnderwritingException;
import com.medical.underwriting.mapper.UnderwritingMapper;
import com.medical.underwriting.model.entity.member.LifestyleDetails;
import com.medical.underwriting.model.entity.member.MedicalConditionsDetails;
import com.medical.underwriting.model.entity.member.MemberDetails;
import com.medical.underwriting.payloads.request.create.CreateLifestyleDetailsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateLifestyleDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.response.LifestyleDetailsResponse;
import com.medical.underwriting.payloads.response.MedicalConditionsResponse;
import com.medical.underwriting.repository.LifestyleRepository;
import com.medical.underwriting.repository.MedicalConditionsDetailsRepository;
import com.medical.underwriting.repository.MemberDetailsRepository;
import com.medical.underwriting.utility.UnderwritingUtility;

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

		LifestyleDetails lifestyleDetails = lifestyleRepository
				.findLifestyleDetailsByLifestyleDetailsId(lifestyleDetailsId)
				.orElseThrow(() -> new UnderwritingException("404",
						UnderwritingConstants.LIFESTYLE_DETAILS_ID_NOT_FOUND, HttpStatus.NOT_FOUND));

		log.info("lifestyleDetails : {}", lifestyleDetails);

		return LifestyleDetailsResponse.builder().lifestyleDetailsId(lifestyleDetails.getLifestyleDetailsId())
				.amountOfTobaccoProductsConsumptionPerDay(
						lifestyleDetails.getAmountOfTobaccoProductsConsumptionPerDay())
				.amountOfAlcoholConsumptionPerWeek(lifestyleDetails.getAmountOfAlcoholConsumptionPerWeek())
				.amountOfCigarettesSticksSmokedPerDay(lifestyleDetails.getAmountOfCigarettesSticksSmokedPerDay())
				.durationOfSmokingCigarettes(lifestyleDetails.getDurationOfSmokingCigarettes())
				.frequencyOfAlcoholConsumptionPerDay(lifestyleDetails.getFrequencyOfAlcoholConsumptionPerDay()).build();

	}

	public LifestyleDetailsResponse createLifestyleDetails(CreateLifestyleDetailsRequestPayload payload) {

		try {
			if (null != payload) {

				Optional<LifestyleDetails> lifestyle = lifestyleRepository
						.findLifestyleDetailsByLifestyleDetailsId(payload.getLifestyleDetailsId());

				if (lifestyle.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.LIFESTYLE_DETAILS_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {

					LifestyleDetails lifestyleDetails = lifestyleRepository
							.save(underwritingMapper.createPayloadToLifestyleDetails(payload));

					return LifestyleDetailsResponse.builder()
							.lifestyleDetailsId(lifestyleDetails.getLifestyleDetailsId())
							.amountOfTobaccoProductsConsumptionPerDay(
									lifestyleDetails.getAmountOfTobaccoProductsConsumptionPerDay())
							.amountOfAlcoholConsumptionPerWeek(lifestyleDetails.getAmountOfAlcoholConsumptionPerWeek())
							.amountOfCigarettesSticksSmokedPerDay(
									lifestyleDetails.getAmountOfCigarettesSticksSmokedPerDay())
							.durationOfSmokingCigarettes(lifestyleDetails.getDurationOfSmokingCigarettes())
							.frequencyOfAlcoholConsumptionPerDay(
									lifestyleDetails.getFrequencyOfAlcoholConsumptionPerDay())
							.build();

				}

			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public LifestyleDetailsResponse updateLifestyleDetails(String lifestyleDetailsId,
			UpdateLifestyleDetailsRequestPayload payload) {

		try {

			if (null != payload) {

				Optional<LifestyleDetails> lifestyle = lifestyleRepository
						.findLifestyleDetailsByLifestyleDetailsId(lifestyleDetailsId);

				if (lifestyle.isPresent()) {

					lifestyle.get().setAmountOfTobaccoProductsConsumptionPerDay(
							payload.getAmountOfTobaccoProductsConsumptionPerDay());
					lifestyle.get()
							.setAmountOfAlcoholConsumptionPerWeek(payload.getAmountOfAlcoholConsumptionPerWeek());
					lifestyle.get()
							.setAmountOfCigarettesSticksSmokedPerDay(payload.getAmountOfCigarettesSticksSmokedPerDay());
					lifestyle.get().setDurationOfSmokingCigarettes(payload.getDurationOfSmokingCigarettes());
					lifestyle.get()
							.setFrequencyOfAlcoholConsumptionPerDay(payload.getFrequencyOfAlcoholConsumptionPerDay());

					lifestyleRepository.save(lifestyle.get());

					return LifestyleDetailsResponse.builder()
							.lifestyleDetailsId(lifestyle.get().getLifestyleDetailsId())
							.amountOfTobaccoProductsConsumptionPerDay(
									lifestyle.get().getAmountOfTobaccoProductsConsumptionPerDay())
							.amountOfAlcoholConsumptionPerWeek(lifestyle.get().getAmountOfAlcoholConsumptionPerWeek())
							.amountOfCigarettesSticksSmokedPerDay(
									lifestyle.get().getAmountOfCigarettesSticksSmokedPerDay())
							.durationOfSmokingCigarettes(lifestyle.get().getDurationOfSmokingCigarettes())
							.frequencyOfAlcoholConsumptionPerDay(
									lifestyle.get().getFrequencyOfAlcoholConsumptionPerDay())
							.build();

				} else {
					throw new UnderwritingException("404", UnderwritingConstants.LIFESTYLE_DETAILS_ID_NOT_FOUND,
							HttpStatus.NOT_FOUND);
				}

			}

		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public void deleteLifestyleDetailsById(String lifestyleDetailsId) {

		try {
			Optional<LifestyleDetails> lifestyleDetails = lifestyleRepository
					.findLifestyleDetailsByLifestyleDetailsId(lifestyleDetailsId);
			lifestyleDetails.ifPresent(lifestyleRepository::delete);
		} catch (UnderwritingException e) {
			throw new UnderwritingException("404", UnderwritingConstants.LAB_TESTS_ID_NOT_FOUND, HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * Business logics related to medical conditions
	 */

	public MedicalConditionsResponse findMedicalConditionsById(String medicalConditionsId) {

		MedicalConditionsDetails medicalConditionsDetails = medicalConditionsDetailsRepository
				.findMedicalConditionsDetailsByMedicalConditionsDetailsId(medicalConditionsId)
				.orElseThrow(() -> new UnderwritingException("404",
						UnderwritingConstants.MEDICAL_CONDITIONS_DETAILS_ID_NOT_FOUND, HttpStatus.NOT_FOUND));

		return MedicalConditionsResponse.builder().medicalConditionsDetailsId(medicalConditionsId)
				.personalMedicalConditionsList(
						underwritingUtility.addPMCtoPMCR(medicalConditionsDetails.getPersonalMedicalConditionsList()))
				.labTests(underwritingUtility.labTestsEntityToResponse(medicalConditionsDetails.getLabTests())).build();

	}

	public MedicalConditionsResponse createMedicalConditions(CreateMedicalConditionsRequestPayload payload) {

		try {

			if (null != payload) {

				Optional<MedicalConditionsDetails> medicalConditions = medicalConditionsDetailsRepository
						.findMedicalConditionsDetailsByMedicalConditionsDetailsId(
								payload.getMedicalConditionsDetailsId());

				if (medicalConditions.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.MEDICAL_CONDITIONS_DETAILS_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {

					MedicalConditionsDetails details = medicalConditionsDetailsRepository
							.save(underwritingMapper.createPayloadToMedicalConditionsDetails(payload));

					return MedicalConditionsResponse.builder()
							.medicalConditionsDetailsId(details.getMedicalConditionsDetailsId())
							.personalMedicalConditionsList(
									underwritingUtility.addPMCtoPMCR(details.getPersonalMedicalConditionsList()))
							.labTests(underwritingUtility.labTestsEntityToResponse(details.getLabTests())).build();

				}

			}

		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public MedicalConditionsResponse updateMedicalConditions(String medicalConditionsDetailsId,
			UpdateMedicalConditionsRequestPayload payload) {

		try {

			if (null != payload) {

				Optional<MedicalConditionsDetails> medicalConditionsDetails = medicalConditionsDetailsRepository
						.findMedicalConditionsDetailsByMedicalConditionsDetailsId(medicalConditionsDetailsId);

				if (medicalConditionsDetails.isPresent()) {

					medicalConditionsDetails.get().setPersonalMedicalConditionsList(
							underwritingUtility.addUPMCtoPMC(payload.getPersonalMedicalConditionsList()));
					medicalConditionsDetails.get()
							.setLabTests(underwritingUtility.labTestsUpdatePayloadToEntity(payload.getLabTests()));

					return MedicalConditionsResponse.builder()
							.medicalConditionsDetailsId(medicalConditionsDetails.get().getMedicalConditionsDetailsId())
							.personalMedicalConditionsList(underwritingUtility
									.addPMCtoPMCR(medicalConditionsDetails.get().getPersonalMedicalConditionsList()))
							.labTests(underwritingUtility
									.labTestsEntityToResponse(medicalConditionsDetails.get().getLabTests()))
							.build();

				}

			}

		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public void deleteMedicalConditionsById(String medicalConditionsDetailsId) {

		try {
			Optional<MedicalConditionsDetails> medicalConditionsDetails = medicalConditionsDetailsRepository
					.findMedicalConditionsDetailsByMedicalConditionsDetailsId(medicalConditionsDetailsId);
			medicalConditionsDetails.ifPresent(medicalConditionsDetailsRepository::delete);
		} catch (UnderwritingException e) {
			throw new UnderwritingException("404", UnderwritingConstants.MEDICAL_CONDITIONS_DETAILS_ID_NOT_FOUND,
					HttpStatus.NOT_FOUND);

		}

	}

	/**
	 * Business logics related to delete the records from the database
	 */

	public void deleteMemberDetailsById(String memberDetailsId) {

		try {
			Optional<MemberDetails> memberDetails = memberDetailsRepository
					.findMemberDetailsByMemberId(memberDetailsId);
			memberDetails.ifPresent(memberDetailsRepository::delete);
		} catch (UnderwritingException e) {
			throw new UnderwritingException("404", UnderwritingConstants.MEMBER_DETAILS_ID_NOT_FOUND,
					HttpStatus.NOT_FOUND);
		}

	}

}
