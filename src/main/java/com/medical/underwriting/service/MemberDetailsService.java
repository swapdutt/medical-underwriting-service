package com.medical.underwriting.service;

import com.medical.underwriting.constants.UnderwritingConstants;
import com.medical.underwriting.exception.UnderwritingException;
import com.medical.underwriting.mapper.UnderwritingMapper;
import com.medical.underwriting.model.dto.member.LifestyleDetailsDto;
import com.medical.underwriting.model.dto.member.MedicalConditionsDetailsDto;
import com.medical.underwriting.model.dto.member.MemberDetailsDto;
import com.medical.underwriting.model.entity.member.LifestyleDetails;
import com.medical.underwriting.model.entity.member.MedicalConditionsDetails;
import com.medical.underwriting.model.entity.member.MemberDetails;
import com.medical.underwriting.repository.member.LifestyleRepository;
import com.medical.underwriting.repository.member.MedicalConditionsDetailsRepository;
import com.medical.underwriting.repository.member.MemberDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberDetailsService {

	private final UnderwritingMapper underwritingMapper;
	private final MemberDetailsRepository memberDetailsRepository;
	private final LifestyleRepository lifestyleRepository;
	private final MedicalConditionsDetailsRepository medicalConditionsDetailsRepository;

	/**
	 * Business logics related to find the records from the database
	 */

	public MemberDetailsDto findMemberDetailsById(String memberId) {

		try {
			if (null != memberId) {
				Optional<MemberDetails> memberDetails = memberDetailsRepository.findMemberDetailsByMemberId(memberId);
				return memberDetails.map(underwritingMapper::memberDetailsToMemberDetailsDto).orElse(null);
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("404", UnderwritingConstants.MEMBER_DETAILS_ID_NOT_FOUND,
					HttpStatus.NOT_FOUND);
		}

		return null;

	}

	public LifestyleDetailsDto findLifestyleDetailsById(String lifestyleDetailsId) {

		LifestyleDetails lifestyleDetails = lifestyleRepository
				.findLifestyleDetailsByLifestyleDetailsId(lifestyleDetailsId)
				.orElseThrow(() -> new UnderwritingException("404",
						UnderwritingConstants.LIFESTYLE_DETAILS_ID_NOT_FOUND, HttpStatus.NOT_FOUND));

		return LifestyleDetailsDto.builder().id(lifestyleDetails.getId())
				.lifestyleDetailsId(lifestyleDetails.getLifestyleDetailsId())
				.amountOfTobaccoProductsConsumptionPerDay(
						lifestyleDetails.getAmountOfTobaccoProductsConsumptionPerDay())
				.amountOfAlcoholConsumptionPerWeek(lifestyleDetails.getAmountOfAlcoholConsumptionPerWeek())
				.amountOfCigarettesSticksSmokedPerDay(lifestyleDetails.getAmountOfCigarettesSticksSmokedPerDay())
				.durationOfSmokingCigarettes(lifestyleDetails.getDurationOfSmokingCigarettes())
				.frequencyOfAlcoholConsumptionPerDay(lifestyleDetails.getFrequencyOfAlcoholConsumptionPerDay()).build();

	}

	public MedicalConditionsDetailsDto findMedicalConditionsDetailsById(String medicalConditionsDetailsId) {

		try {
			if (null != medicalConditionsDetailsId) {
				Optional<MedicalConditionsDetails> medicalConditionsDetails = medicalConditionsDetailsRepository
						.findMedicalConditionsDetailsByMedicalConditionsDetailsId(medicalConditionsDetailsId);
				return medicalConditionsDetails
						.map(underwritingMapper::medicalConditionsDetailsToMedicalConditionsDetailsDto).orElse(null);
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("404", UnderwritingConstants.MEDICAL_CONDITIONS_DETAILS_ID_NOT_FOUND,
					HttpStatus.NOT_FOUND);
		}

		return null;

	}

	/**
	 * Business logics related to create new records in database
	 */

	public MemberDetailsDto createMemberDetails(MemberDetailsDto dto) {

		try {
			if (null != dto) {
				Optional<MemberDetails> memberDetails = memberDetailsRepository
						.findMemberDetailsByMemberId(dto.getMemberId());
				if (memberDetails.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.MEMBER_DETAILS_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {
					return underwritingMapper.memberDetailsToMemberDetailsDto(
							memberDetailsRepository.save(underwritingMapper.memberDetailsDtoToMemberDetails(dto)));
				}
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public LifestyleDetailsDto createLifestyleDetails(LifestyleDetailsDto dto) {

		try {
			if (null != dto) {
				Optional<LifestyleDetails> lifestyleDetails = lifestyleRepository
						.findLifestyleDetailsByLifestyleDetailsId(dto.getLifestyleDetailsId());
				if (lifestyleDetails.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.LIFESTYLE_DETAILS_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {
					LifestyleDetails lifestyle = lifestyleRepository
							.save(underwritingMapper.lifestyleDetailsDtoToLifestyleDetails(dto));
					return LifestyleDetailsDto.builder().id(lifestyle.getId())
							.lifestyleDetailsId(lifestyle.getLifestyleDetailsId())
							.amountOfTobaccoProductsConsumptionPerDay(
									lifestyle.getAmountOfTobaccoProductsConsumptionPerDay())
							.amountOfAlcoholConsumptionPerWeek(lifestyle.getAmountOfAlcoholConsumptionPerWeek())
							.amountOfCigarettesSticksSmokedPerDay(lifestyle.getAmountOfCigarettesSticksSmokedPerDay())
							.durationOfSmokingCigarettes(lifestyle.getDurationOfSmokingCigarettes())
							.frequencyOfAlcoholConsumptionPerDay(lifestyle.getFrequencyOfAlcoholConsumptionPerDay())
							.build();
				}
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public MedicalConditionsDetailsDto createMedicalConditionsDetails(MedicalConditionsDetailsDto dto) {

		try {
			if (null != dto) {
				Optional<MedicalConditionsDetails> medicalConditionsDetails = medicalConditionsDetailsRepository
						.findMedicalConditionsDetailsByMedicalConditionsDetailsId(dto.getMedicalConditionsDetailsId());
				if (medicalConditionsDetails.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.MEDICAL_CONDITIONS_DETAILS_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {
					return underwritingMapper.medicalConditionsDetailsToMedicalConditionsDetailsDto(
							medicalConditionsDetailsRepository.save(
									underwritingMapper.medicalConditionsDetailsDtoToMedicalConditionsDetails(dto)));
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

	public MemberDetailsDto updateMemberDetails(MemberDetailsDto dto) {

		try {
			if (null != dto) {
				Optional<MemberDetails> memberDetails = memberDetailsRepository
						.findMemberDetailsByMemberId(dto.getMemberId());
				if (memberDetails.isEmpty()) {
					throw new UnderwritingException("404", UnderwritingConstants.MEMBER_DETAILS_ID_NOT_FOUND,
							HttpStatus.NOT_FOUND);
				} else {
					return underwritingMapper.memberDetailsToMemberDetailsDto(
							memberDetailsRepository.save(underwritingMapper.memberDetailsDtoToMemberDetails(dto)));
				}
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public LifestyleDetailsDto updateLifestyleDetails(LifestyleDetailsDto dto) {

		try {
			if (null != dto) {
				Optional<LifestyleDetails> lifestyleDetails = lifestyleRepository
						.findLifestyleDetailsByLifestyleDetailsId(dto.getLifestyleDetailsId());
				if (lifestyleDetails.isEmpty()) {
					throw new UnderwritingException("404", UnderwritingConstants.LIFESTYLE_DETAILS_ID_NOT_FOUND,
							HttpStatus.NOT_FOUND);
				} else {
					LifestyleDetails lifestyle = lifestyleRepository
							.save(underwritingMapper.lifestyleDetailsDtoToLifestyleDetails(dto));
					return LifestyleDetailsDto.builder().id(lifestyle.getId())
							.lifestyleDetailsId(lifestyle.getLifestyleDetailsId())
							.amountOfTobaccoProductsConsumptionPerDay(
									lifestyle.getAmountOfTobaccoProductsConsumptionPerDay())
							.amountOfAlcoholConsumptionPerWeek(lifestyle.getAmountOfAlcoholConsumptionPerWeek())
							.amountOfCigarettesSticksSmokedPerDay(lifestyle.getAmountOfCigarettesSticksSmokedPerDay())
							.durationOfSmokingCigarettes(lifestyle.getDurationOfSmokingCigarettes())
							.frequencyOfAlcoholConsumptionPerDay(lifestyle.getFrequencyOfAlcoholConsumptionPerDay())
							.build();
				}
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public MedicalConditionsDetailsDto updateMedicalConditionsDetails(MedicalConditionsDetailsDto dto) {

		try {
			if (null != dto) {
				Optional<MedicalConditionsDetails> medicalConditionsDetails = medicalConditionsDetailsRepository
						.findMedicalConditionsDetailsByMedicalConditionsDetailsId(dto.getMedicalConditionsDetailsId());
				if (medicalConditionsDetails.isEmpty()) {
					throw new UnderwritingException("404",
							UnderwritingConstants.MEDICAL_CONDITIONS_DETAILS_ID_NOT_FOUND, HttpStatus.NOT_FOUND);
				} else {
					return underwritingMapper.medicalConditionsDetailsToMedicalConditionsDetailsDto(
							medicalConditionsDetailsRepository.save(
									underwritingMapper.medicalConditionsDetailsDtoToMedicalConditionsDetails(dto)));
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

	public void deleteMemberDetailsById(String memberDetailsId) {

		try {
			if (null != memberDetailsId) {
				Optional<MemberDetails> memberDetails = memberDetailsRepository
						.findMemberDetailsByMemberId(memberDetailsId);
				memberDetails.ifPresent(memberDetailsRepository::delete);
			} else {
				throw new UnderwritingException("404", UnderwritingConstants.MEMBER_DETAILS_ID_NOT_FOUND,
						HttpStatus.NOT_FOUND);
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

	}

	public void deleteLifestyleDetailsById(String lifestyleDetailsId) {

		try {
			if (null != lifestyleDetailsId) {
				Optional<LifestyleDetails> lifestyleDetails = lifestyleRepository
						.findLifestyleDetailsByLifestyleDetailsId(lifestyleDetailsId);
				lifestyleDetails.ifPresent(lifestyleRepository::delete);
			} else {
				throw new UnderwritingException("404", UnderwritingConstants.LAB_TESTS_ID_NOT_FOUND,
						HttpStatus.NOT_FOUND);
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

	}

	public void deleteMedicalConditionsById(String medicalConditionsDetailsId) {

		try {
			if (null != medicalConditionsDetailsId) {
				Optional<MedicalConditionsDetails> medicalConditionsDetails = medicalConditionsDetailsRepository
						.findMedicalConditionsDetailsByMedicalConditionsDetailsId(medicalConditionsDetailsId);
				medicalConditionsDetails.ifPresent(medicalConditionsDetailsRepository::delete);
			} else {
				throw new UnderwritingException("404", UnderwritingConstants.MEDICAL_CONDITIONS_DETAILS_ID_NOT_FOUND,
						HttpStatus.NOT_FOUND);
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

	}

}
