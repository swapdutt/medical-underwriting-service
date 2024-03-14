package com.medical.underwriting.service;

import com.medical.underwriting.constants.UnderwritingConstants;
import com.medical.underwriting.exception.UnderwritingException;
import com.medical.underwriting.mapper.UnderwritingMapper;
import com.medical.underwriting.model.dto.medical.DiseaseQuestionnaireDto;
import com.medical.underwriting.model.dto.medical.LabTestsDto;
import com.medical.underwriting.model.dto.medical.PersonalMedicalConditionsDto;
import com.medical.underwriting.model.entity.medical.DiseaseQuestionnaire;
import com.medical.underwriting.model.entity.medical.LabTests;
import com.medical.underwriting.model.entity.medical.PersonalMedicalConditions;
import com.medical.underwriting.repository.DiseaseQuestionnaireRepository;
import com.medical.underwriting.repository.LabTestsRepository;
import com.medical.underwriting.repository.PersonalMedicalConditionsRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicalConditionsService {

	private final UnderwritingMapper underwritingMapper;
	private final DiseaseQuestionnaireRepository diseaseQuestionnaireRepository;
	private final LabTestsRepository labTestsRepository;
	private final PersonalMedicalConditionsRepository personalMedicalConditionsRepository;

	/**
	 * Business logics related to find the records from the databases
	 */

	public DiseaseQuestionnaireDto findDiseaseQuestionnaireById(Integer diseaseQuestionnaireId) {

		DiseaseQuestionnaire diseaseQuestionnaire = diseaseQuestionnaireRepository
				.findDiseaseQuestionnaireByDiseaseQuestionnaireId(diseaseQuestionnaireId)
				.orElseThrow(() -> new UnderwritingException("404",
						UnderwritingConstants.DISEASE_QUESTIONNAIRE_ID_NOT_FOUND, HttpStatus.NOT_FOUND));

		return DiseaseQuestionnaireDto.builder()
				.diseaseQuestionnaireId(diseaseQuestionnaire.getDiseaseQuestionnaireId())
				.question1(diseaseQuestionnaire.getQuestion1()).question2(diseaseQuestionnaire.getQuestion2())
				.question3(diseaseQuestionnaire.getQuestion3()).question4(diseaseQuestionnaire.getQuestion4())
				.question5(diseaseQuestionnaire.getQuestion5()).question6(diseaseQuestionnaire.getQuestion6())
				.question7(diseaseQuestionnaire.getQuestion7()).question8(diseaseQuestionnaire.getQuestion8())
				.question9(diseaseQuestionnaire.getQuestion9()).question10(diseaseQuestionnaire.getQuestion10())
				.question11(diseaseQuestionnaire.getQuestion11()).question12(diseaseQuestionnaire.getQuestion12())
				.build();

	}

	public LabTestsDto findLabTestsById(Integer labTestsId) {

		try {
			if (null != labTestsId) {
				Optional<LabTests> labTests = labTestsRepository.findLabTestsByLabTestsId(labTestsId);
				return labTests.map(underwritingMapper::labTestsToLabTestsDto).orElse(null);
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("404", UnderwritingConstants.LAB_TESTS_ID_NOT_FOUND, HttpStatus.NOT_FOUND);
		}

		return null;

	}

	public PersonalMedicalConditionsDto findPersonalMedicalConditionsById(Integer personalMedicalConditionsId) {

		PersonalMedicalConditions personalMedicalConditions = personalMedicalConditionsRepository
				.findPersonalMedicalConditionsByPersonalMedicalConditionsId(personalMedicalConditionsId)
				.orElseThrow(() -> new UnderwritingException("404",
						UnderwritingConstants.PERSONAL_MEDICAL_CONDITIONS_ID_NOT_FOUND, HttpStatus.NOT_FOUND));

		return PersonalMedicalConditionsDto.builder()
				.personalMedicalConditionsId(personalMedicalConditions.getPersonalMedicalConditionsId())
				.diseaseQuestionnaire(underwritingMapper.diseaseQuestionnaireToDiseaseQuestionnaireDto(
						personalMedicalConditions.getDiseaseQuestionnaire()))
				.nameOfDisease(personalMedicalConditions.getNameOfDisease())
				.typeOfDisease(personalMedicalConditions.getTypeOfDisease())
				.typeOfTreatment(personalMedicalConditions.getTypeOfTreatment())
				.currentStatusOfDisease(personalMedicalConditions.getCurrentStatusOfDisease())
				.typeOfComplication(personalMedicalConditions.getTypeOfComplication())
				.typeOfBiopsy(personalMedicalConditions.getTypeOfBiopsy())
				.lastConsultationDate(personalMedicalConditions.getLastConsultationDate())
				.yearWhenFirstDiagnosisWasTaken(personalMedicalConditions.getYearWhenFirstDiagnosisWasTaken()).build();

	}

	/**
	 * Business logics related to create new records in database
	 */

	public DiseaseQuestionnaireDto createDiseaseQuestionnaire(DiseaseQuestionnaireDto dto) {

		try {
			if (null != dto) {
				Optional<DiseaseQuestionnaire> diseaseQuestionnaire = diseaseQuestionnaireRepository
						.findDiseaseQuestionnaireByDiseaseQuestionnaireId(dto.getDiseaseQuestionnaireId());
				if (diseaseQuestionnaire.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.DISEASE_QUESTIONNAIRE_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {
					DiseaseQuestionnaire questionnaire = diseaseQuestionnaireRepository
							.save(underwritingMapper.diseaseQuestionnaireDtoToDiseaseQuestionnaire(dto));
					return DiseaseQuestionnaireDto.builder()
							.diseaseQuestionnaireId(questionnaire.getDiseaseQuestionnaireId())
							.question1(questionnaire.getQuestion1()).question2(questionnaire.getQuestion2())
							.question3(questionnaire.getQuestion3()).question4(questionnaire.getQuestion4())
							.question5(questionnaire.getQuestion5()).question6(questionnaire.getQuestion6())
							.question7(questionnaire.getQuestion7()).question8(questionnaire.getQuestion8())
							.question9(questionnaire.getQuestion9()).question10(questionnaire.getQuestion10())
							.question11(questionnaire.getQuestion11()).question12(questionnaire.getQuestion12())
							.build();
				}
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public LabTestsDto createLabTests(LabTestsDto dto) {

		try {
			if (null != dto) {
				Optional<LabTests> labTests = labTestsRepository.findLabTestsByLabTestsId(dto.getLabTestsId());
				if (labTests.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.LAB_TESTS_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {
					return underwritingMapper.labTestsToLabTestsDto(
							labTestsRepository.save(underwritingMapper.labTestsDtoToLabTests(dto)));
				}
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public PersonalMedicalConditionsDto createPersonalMedicalConditions(PersonalMedicalConditionsDto dto) {

		try {
			if (null != dto) {
				Optional<PersonalMedicalConditions> personalMedicalConditions = personalMedicalConditionsRepository
						.findPersonalMedicalConditionsByPersonalMedicalConditionsId(
								dto.getPersonalMedicalConditionsId());
				if (personalMedicalConditions.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.PERSONAL_MEDICAL_CONDITIONS_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {
					PersonalMedicalConditions pmc = personalMedicalConditionsRepository
							.save(underwritingMapper.personalMedicalConditionsDtoToPersonalMedicalConditions(dto));
					return PersonalMedicalConditionsDto.builder()
							.personalMedicalConditionsId(pmc.getPersonalMedicalConditionsId())
							.diseaseQuestionnaire(underwritingMapper
									.diseaseQuestionnaireToDiseaseQuestionnaireDto(pmc.getDiseaseQuestionnaire()))
							.nameOfDisease(pmc.getNameOfDisease()).typeOfDisease(pmc.getTypeOfDisease())
							.typeOfTreatment(pmc.getTypeOfTreatment())
							.currentStatusOfDisease(pmc.getCurrentStatusOfDisease())
							.typeOfComplication(pmc.getTypeOfComplication()).typeOfBiopsy(pmc.getTypeOfBiopsy())
							.lastConsultationDate(pmc.getLastConsultationDate())
							.yearWhenFirstDiagnosisWasTaken(pmc.getYearWhenFirstDiagnosisWasTaken()).build();
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

	public DiseaseQuestionnaireDto updateDiseaseQuestionnaire(DiseaseQuestionnaireDto dto) {

		try {
			if (null != dto) {
				Optional<DiseaseQuestionnaire> diseaseQuestionnaire = diseaseQuestionnaireRepository
						.findDiseaseQuestionnaireByDiseaseQuestionnaireId(dto.getDiseaseQuestionnaireId());
				if (diseaseQuestionnaire.isEmpty()) {
					throw new UnderwritingException("404", UnderwritingConstants.DISEASE_QUESTIONNAIRE_ID_NOT_FOUND,
							HttpStatus.NOT_FOUND);
				} else {
					DiseaseQuestionnaire questionnaire = diseaseQuestionnaireRepository
							.save(underwritingMapper.diseaseQuestionnaireDtoToDiseaseQuestionnaire(dto));
					return DiseaseQuestionnaireDto.builder()
							.diseaseQuestionnaireId(questionnaire.getDiseaseQuestionnaireId())
							.question1(questionnaire.getQuestion1()).question2(questionnaire.getQuestion2())
							.question3(questionnaire.getQuestion3()).question4(questionnaire.getQuestion4())
							.question5(questionnaire.getQuestion5()).question6(questionnaire.getQuestion6())
							.question7(questionnaire.getQuestion7()).question8(questionnaire.getQuestion8())
							.question9(questionnaire.getQuestion9()).question10(questionnaire.getQuestion10())
							.question11(questionnaire.getQuestion11()).question12(questionnaire.getQuestion12())
							.build();
				}
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public LabTestsDto updateLabTests(LabTestsDto dto) {

		try {
			if (null != dto) {
				Optional<LabTests> labTests = labTestsRepository.findLabTestsByLabTestsId(dto.getLabTestsId());
				if (labTests.isEmpty()) {
					throw new UnderwritingException("404", UnderwritingConstants.LAB_TESTS_ID_NOT_FOUND,
							HttpStatus.NOT_FOUND);
				} else {
					return underwritingMapper.labTestsToLabTestsDto(
							labTestsRepository.save(underwritingMapper.labTestsDtoToLabTests(dto)));
				}
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public PersonalMedicalConditionsDto updatePersonalMedicalConditions(PersonalMedicalConditionsDto dto) {

		try {
			if (null != dto) {
				Optional<PersonalMedicalConditions> personalMedicalConditions = personalMedicalConditionsRepository
						.findPersonalMedicalConditionsByPersonalMedicalConditionsId(
								dto.getPersonalMedicalConditionsId());
				if (personalMedicalConditions.isEmpty()) {
					throw new UnderwritingException("404",
							UnderwritingConstants.PERSONAL_MEDICAL_CONDITIONS_ID_NOT_FOUND, HttpStatus.NOT_FOUND);
				} else {
					PersonalMedicalConditions pmc = personalMedicalConditionsRepository
							.save(underwritingMapper.personalMedicalConditionsDtoToPersonalMedicalConditions(dto));
					return PersonalMedicalConditionsDto.builder()
							.personalMedicalConditionsId(pmc.getPersonalMedicalConditionsId())
							.diseaseQuestionnaire(underwritingMapper
									.diseaseQuestionnaireToDiseaseQuestionnaireDto(pmc.getDiseaseQuestionnaire()))
							.nameOfDisease(pmc.getNameOfDisease()).typeOfDisease(pmc.getTypeOfDisease())
							.typeOfTreatment(pmc.getTypeOfTreatment())
							.currentStatusOfDisease(pmc.getCurrentStatusOfDisease())
							.typeOfComplication(pmc.getTypeOfComplication()).typeOfBiopsy(pmc.getTypeOfBiopsy())
							.lastConsultationDate(pmc.getLastConsultationDate())
							.yearWhenFirstDiagnosisWasTaken(pmc.getYearWhenFirstDiagnosisWasTaken()).build();
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

	public void deleteDiseaseQuestionnaireById(Integer diseaseQuestionnaireId) {

		try {
			if (null != diseaseQuestionnaireId) {
				Optional<DiseaseQuestionnaire> diseaseQuestionnaire = diseaseQuestionnaireRepository
						.findDiseaseQuestionnaireByDiseaseQuestionnaireId(diseaseQuestionnaireId);
				diseaseQuestionnaire.ifPresent(diseaseQuestionnaireRepository::delete);
			} else {
				throw new UnderwritingException("404", UnderwritingConstants.DISEASE_QUESTIONNAIRE_ID_NOT_FOUND,
						HttpStatus.NOT_FOUND);
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

	}

	public void deleteLabTestsById(Integer labTestsId) {

		try {
			if (null != labTestsId) {
				Optional<LabTests> labTests = labTestsRepository.findLabTestsByLabTestsId(labTestsId);
				labTests.ifPresent(labTestsRepository::delete);
			} else {
				throw new UnderwritingException("404", UnderwritingConstants.LAB_TESTS_ID_NOT_FOUND,
						HttpStatus.NOT_FOUND);
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

	}

	public void deletePersonalMedicalConditionsById(Integer personalMedicalConditionsId) {

		try {
			if (null != personalMedicalConditionsId) {
				Optional<PersonalMedicalConditions> personalMedicalConditions = personalMedicalConditionsRepository
						.findPersonalMedicalConditionsByPersonalMedicalConditionsId(personalMedicalConditionsId);
				personalMedicalConditions.ifPresent(personalMedicalConditionsRepository::delete);
			} else {
				throw new UnderwritingException("404", UnderwritingConstants.PERSONAL_MEDICAL_CONDITIONS_ID_NOT_FOUND,
						HttpStatus.NOT_FOUND);
			}
		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

	}

}
