package com.medical.underwriting.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.medical.underwriting.constants.UnderwritingConstants;
import com.medical.underwriting.exception.UnderwritingException;
import com.medical.underwriting.mapper.UnderwritingMapper;
import com.medical.underwriting.model.medical.DiseaseQuestionnaire;
import com.medical.underwriting.model.medical.LabTests;
import com.medical.underwriting.model.medical.PersonalMedicalConditions;
import com.medical.underwriting.payloads.request.create.CreateDiseaseQuestionnaireRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateLabTestsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreatePersonalMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateDiseaseQuestionnaireRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateLabTestsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdatePersonalMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.response.DiseaseQuestionnaireResponse;
import com.medical.underwriting.payloads.response.LabTestsResponse;
import com.medical.underwriting.payloads.response.PersonalMedicalConditionsResponse;
import com.medical.underwriting.repository.DiseaseQuestionnaireRepository;
import com.medical.underwriting.repository.LabTestsRepository;
import com.medical.underwriting.repository.PersonalMedicalConditionsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MedicalConditionsService {

	private final UnderwritingMapper underwritingMapper;
	private final DiseaseQuestionnaireRepository diseaseQuestionnaireRepository;
	private final LabTestsRepository labTestsRepository;
	private final PersonalMedicalConditionsRepository personalMedicalConditionsRepository;

	/**
	 * Business logics related to disease questionnaire
	 */

	public DiseaseQuestionnaireResponse findDiseaseQuestionnaireById(String diseaseQuestionnaieId) {

		DiseaseQuestionnaire diseaseQuestionnaire = diseaseQuestionnaireRepository
				.findDiseaseQuestionnaireByDiseaseQuestionnaireId(diseaseQuestionnaieId)
				.orElseThrow(() -> new UnderwritingException("404",
						UnderwritingConstants.DISEASE_QUESTIONNAIRE_ID_NOT_FOUND, HttpStatus.NOT_FOUND));

		log.info("Disease Questionnaire : {}", diseaseQuestionnaire);

		return DiseaseQuestionnaireResponse.builder()
				.diseaseQuestionnaireId(diseaseQuestionnaire.getDiseaseQuestionnaireId())
				.question1(diseaseQuestionnaire.getQuestion1()).question2(diseaseQuestionnaire.getQuestion2())
				.question3(diseaseQuestionnaire.getQuestion3()).question4(diseaseQuestionnaire.getQuestion4())
				.question5(diseaseQuestionnaire.getQuestion5()).question6(diseaseQuestionnaire.getQuestion6())
				.question7(diseaseQuestionnaire.getQuestion7()).question8(diseaseQuestionnaire.getQuestion8())
				.question9(diseaseQuestionnaire.getQuestion9()).question10(diseaseQuestionnaire.getQuestion10())
				.question11(diseaseQuestionnaire.getQuestion11()).question12(diseaseQuestionnaire.getQuestion12())
				.build();

	}

	public DiseaseQuestionnaireResponse createDiseaseQuestionnaire(CreateDiseaseQuestionnaireRequestPayload payload) {

		log.info("Inside createDiseaseQuestionnaire with payload : {}", payload);

		try {
			if (null != payload) {

				Optional<DiseaseQuestionnaire> diseaseQuestionnaire = diseaseQuestionnaireRepository
						.findDiseaseQuestionnaireByDiseaseQuestionnaireId(payload.getDiseaseQuestionnaireId());

				if (diseaseQuestionnaire.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.DISEASE_QUESTIONNAIRE_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {

					DiseaseQuestionnaire questionnaire = diseaseQuestionnaireRepository
							.save(underwritingMapper.createPayloadToDiseaseQuestionnaire(payload));

					log.info("Disease Questionnaire : {}", questionnaire);

					return DiseaseQuestionnaireResponse.builder()
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

	public DiseaseQuestionnaireResponse updateDiseaseQuestionnaire(String diseaseQuestionnaireId,
			UpdateDiseaseQuestionnaireRequestPayload payload) {

		log.info("Inside updateDiseaseQuestionnaire with payload : {}", payload);

		try {

			if (null != payload) {

				Optional<DiseaseQuestionnaire> questionnaire = diseaseQuestionnaireRepository
						.findDiseaseQuestionnaireByDiseaseQuestionnaireId(diseaseQuestionnaireId);

				log.info("Disease Questionnaire before update : {}", questionnaire);

				if (questionnaire.isPresent()) {

					questionnaire.get().setQuestion1(payload.getQuestion1());
					questionnaire.get().setQuestion2(payload.getQuestion2());
					questionnaire.get().setQuestion3(payload.getQuestion3());
					questionnaire.get().setQuestion4(payload.getQuestion4());
					questionnaire.get().setQuestion5(payload.getQuestion5());
					questionnaire.get().setQuestion6(payload.getQuestion6());
					questionnaire.get().setQuestion7(payload.getQuestion7());
					questionnaire.get().setQuestion8(payload.getQuestion8());
					questionnaire.get().setQuestion9(payload.getQuestion9());
					questionnaire.get().setQuestion10(payload.getQuestion10());
					questionnaire.get().setQuestion11(payload.getQuestion11());
					questionnaire.get().setQuestion12(payload.getQuestion12());

					diseaseQuestionnaireRepository.save(questionnaire.get());

					log.info("Disease Questionnaire after update : {}", questionnaire);

					return DiseaseQuestionnaireResponse.builder()
							.diseaseQuestionnaireId(questionnaire.get().getDiseaseQuestionnaireId())
							.question1(questionnaire.get().getQuestion1()).question2(questionnaire.get().getQuestion2())
							.question3(questionnaire.get().getQuestion3()).question4(questionnaire.get().getQuestion4())
							.question5(questionnaire.get().getQuestion5()).question6(questionnaire.get().getQuestion6())
							.question7(questionnaire.get().getQuestion7()).question8(questionnaire.get().getQuestion8())
							.question9(questionnaire.get().getQuestion9())
							.question10(questionnaire.get().getQuestion10())
							.question11(questionnaire.get().getQuestion11())
							.question12(questionnaire.get().getQuestion12()).build();

				} else {
					throw new UnderwritingException("404", UnderwritingConstants.DISEASE_QUESTIONNAIRE_ID_NOT_FOUND,
							HttpStatus.NOT_FOUND);
				}
			}

		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public void deleteDiseaseQuestionnaireById(String diseaseQuestionnaireId) {

		try {
			Optional<DiseaseQuestionnaire> diseaseQuestionnaire = diseaseQuestionnaireRepository
					.findDiseaseQuestionnaireByDiseaseQuestionnaireId(diseaseQuestionnaireId);
			diseaseQuestionnaire.ifPresent(diseaseQuestionnaireRepository::delete);
		} catch (UnderwritingException e) {
			throw new UnderwritingException("404", UnderwritingConstants.DISEASE_QUESTIONNAIRE_ID_NOT_FOUND,
					HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * Business logics related to lab tests
	 */

	public LabTestsResponse findLabTestsById(String labTestsId) {

		LabTests labTests = labTestsRepository.findLabTestsByLabTestsId(labTestsId)
				.orElseThrow(() -> new UnderwritingException("404", UnderwritingConstants.LAB_TESTS_ID_NOT_FOUND,
						HttpStatus.NOT_FOUND));

		return LabTestsResponse.builder().labTestsId(labTestsId).sugarInUrine(labTests.getSugarInUrine())
				.bilirubinInUrine(labTests.getBilirubinInUrine()).ketonesInUrine(labTests.getKetonesInUrine())
				.proteinInUrine(labTests.getProteinInUrine()).rbcBloodCountInUrine(labTests.getRbcBloodCountInUrine())
				.resultOfTMT(labTests.getResultOfTMT())
				.resultOfDobutamineStressECHO(labTests.getResultOfDobutamineStressECHO())
				.resultOfStressThallium(labTests.getResultOfStressThallium())
				.resultOfCTFindings(labTests.getResultOfCTFindings()).resultOfChestXRay(labTests.getResultOfChestXRay())
				.resultOfEcho(labTests.getResultOfEcho()).resultOfECG(labTests.getResultOfECG())
				.resultOfUSGAbdomen(labTests.getResultOfUSGAbdomen())
				.otherMedicalReports(labTests.getOtherMedicalReports()).crystalsInUrine(labTests.getCrystalsInUrine())
				.rbcWBCCastsInUrine(labTests.getRbcWBCCastsInUrine()).granularWaxyCasts(labTests.getGranularWaxyCasts())
				.wbcPlusCellsInUrine(labTests.getWbcPlusCellsInUrine()).rbcPerHPF(labTests.getRbcPerHPF())
				.countOfRBC(labTests.getCountOfRBC()).upperCountOfRBC(labTests.getUpperCountOfRBC())
				.lowerCountOfRBC(labTests.getLowerCountOfRBC()).pcvHematocrit(labTests.getPcvHematocrit())
				.upperCountOfPCVHematocrit(labTests.getUpperCountOfPCVHematocrit())
				.lowerCountOfPCVHematocrit(labTests.getLowerCountOfPCVHematocrit()).countOfMCV(labTests.getCountOfMCV())
				.upperCountOfMCV(labTests.getUpperCountOfMCV()).lowerCountOfMCV(labTests.getLowerCountOfMCV())
				.countOfMCH(labTests.getCountOfMCH()).upperCountOfMCH(labTests.getUpperCountOfMCH())
				.lowerCountOfMCH(labTests.getLowerCountOfMCH()).countOfMCHC(labTests.getCountOfMCHC())
				.upperCountOfMCHC(labTests.getUpperCountOfMCHC()).lowerCountOfMCHC(labTests.getLowerCountOfMCHC())
				.valueOfTSH(labTests.getValueOfTSH()).upperValueOfTSH(labTests.getUpperValueOfTSH())
				.lowerValueOfTSH(labTests.getLowerValueOfTSH()).valueOfTLC(labTests.getValueOfTLC())
				.upperValueOfTLC(labTests.getUpperValueOfTLC()).lowerValueOfTLC(labTests.getLowerValueOfTLC())
				.valueOfNeutrophil(labTests.getValueOfNeutrophil())
				.upperValueOfNeutrophil(labTests.getUpperValueOfNeutrophil())
				.lowerValueOfNeutrophil(labTests.getLowerValueOfNeutrophil())
				.valueOfEsoinophil(labTests.getValueOfEsoinophil())
				.upperValueOfEsoinophil(labTests.getUpperValueOfEsoinophil())
				.lowerValueOfEsoinophil(labTests.getLowerValueOfEsoinophil())
				.valueOfBasophil(labTests.getValueOfBasophil()).upperValueOfBasophil(labTests.getUpperValueOfBasophil())
				.lowerValueOfBasophil(labTests.getLowerValueOfBasophil()).valueOfMonocyte(labTests.getValueOfMonocyte())
				.upperValueOfMonocyte(labTests.getUpperValueOfMonocyte())
				.lowerValueOfMonocyte(labTests.getLowerValueOfMonocyte())
				.valueOfLymphocyte(labTests.getValueOfLymphocyte())
				.upperValueOfLymphocyte(labTests.getUpperValueOfLymphocyte())
				.lowerValueOfLymphocyte(labTests.getLowerValueOfLymphocyte())
				.countOfPlatelet(labTests.getCountOfPlatelet()).upperCountOfPlatelet(labTests.getUpperCountOfPlatelet())
				.lowerCountOfPlatelet(labTests.getLowerCountOfPlatelet()).valueOfESR(labTests.getValueOfESR())
				.upperValueOfESR(labTests.getUpperValueOfESR()).lowerValueOfESR(labTests.getLowerValueOfESR())
				.valueOfFBS(labTests.getValueOfFBS()).upperValueOfFBS(labTests.getUpperValueOfFBS())
				.lowerValueOfFBS(labTests.getLowerValueOfFBS()).valueOfHbA1C(labTests.getValueOfHbA1C())
				.upperValueOfHbA1C(labTests.getUpperValueOfHbA1C()).lowerValueOfHbA1C(labTests.getLowerValueOfHbA1C())
				.valueOfSerumCreatinineRFT(labTests.getValueOfSerumCreatinineRFT())
				.upperValueOfSerumCreatinineRFT(labTests.getUpperValueOfSerumCreatinineRFT())
				.lowerValueOfSerumCreatinineRFT(labTests.getLowerValueOfSerumCreatinineRFT())
				.amountOfUricAcid(labTests.getAmountOfUricAcid())
				.upperAmountOfUricAcid(labTests.getUpperAmountOfUricAcid())
				.lowerAmountOfUricAcid(labTests.getLowerAmountOfUricAcid()).valueOfSGOTAST(labTests.getValueOfSGOTAST())
				.upperValueOfSGOTAST(labTests.getUpperValueOfSGOTAST())
				.lowerValueOfSGOTAST(labTests.getLowerValueOfSGOTAST()).valueOfSGPTALT(labTests.getValueOfSGPTALT())
				.upperValueOfSGPTALT(labTests.getUpperValueOfSGPTALT())
				.lowerValueOfSGPTALT(labTests.getLowerValueOfSGPTALT())
				.ratioBetweenSGOAndSGPT(labTests.getRatioBetweenSGOAndSGPT()).valueOfBUN(labTests.getValueOfBUN())
				.upperValueOfBUN(labTests.getUpperValueOfBUN()).lowerValueOfBUN(labTests.getLowerValueOfBUN())
				.valueOfNA(labTests.getValueOfNA()).upperValueOfNA(labTests.getUpperValueOfNA())
				.lowerValueOfNA(labTests.getLowerValueOfNA()).valueOfK(labTests.getValueOfK())
				.upperValueOfK(labTests.getUpperValueOfK()).lowerValueOfK(labTests.getLowerValueOfK())
				.valueOfCA(labTests.getValueOfCA()).upperValueOfCA(labTests.getUpperValueOfCA())
				.lowerValueOfCA(labTests.getLowerValueOfCA()).valueOfPO4(labTests.getValueOfPO4())
				.upperValueOfPO4(labTests.getUpperValueOfPO4()).lowerValueOfPO4(labTests.getLowerValueOfPO4())
				.valueOfCI(labTests.getValueOfCI()).upperValueOfCI(labTests.getUpperValueOfCI())
				.lowerValueOfCI(labTests.getLowerValueOfCI()).valueOfHCO3(labTests.getValueOfHCO3())
				.upperValueOfHCO3(labTests.getUpperValueOfHCO3()).lowerValueOfHCO3(labTests.getLowerValueOfHCO3())
				.valueOfGGT(labTests.getValueOfGGT()).upperValueOfGGT(labTests.getUpperValueOfGGT())
				.lowerValueOfGGT(labTests.getLowerValueOfGGT()).valueOfALP(labTests.getValueOfALP())
				.upperValueOfALP(labTests.getUpperValueOfALP()).lowerValueOfALP(labTests.getLowerValueOfALP())
				.valueOfTotalBilirubin(labTests.getValueOfTotalBilirubin())
				.upperValueOfTotalBilirubin(labTests.getUpperValueOfTotalBilirubin())
				.lowerValueOfTotalBilirubin(labTests.getLowerValueOfTotalBilirubin())
				.valueOfSerumAlbumin(labTests.getValueOfSerumAlbumin())
				.upperValueOfSerumAlbumin(labTests.getUpperValueOfSerumAlbumin())
				.lowerValueOfSerumAlbumin(labTests.getLowerValueOfSerumAlbumin())
				.valueOfUrineMicroAlbumin(labTests.getValueOfUrineMicroAlbumin())
				.upperValueOfUrineMicroAlbumin(labTests.getUpperValueOfUrineMicroAlbumin())
				.lowerValueOfUrineMicroAlbumin(labTests.getLowerValueOfUrineMicroAlbumin())
				.valueOfTotalProtein(labTests.getValueOfTotalProtein())
				.upperValueOfTotalProtein(labTests.getUpperValueOfTotalProtein())
				.lowerValueOfTotalProtein(labTests.getLowerValueOfTotalProtein()).valueOfPSA(labTests.getValueOfPSA())
				.upperValueOfPSA(labTests.getUpperValueOfPSA()).lowerValueOfPSA(labTests.getLowerValueOfPSA())
				.valueOfTC(labTests.getValueOfTC()).upperValueOfTC(labTests.getUpperValueOfTC())
				.lowerValueOfTC(labTests.getLowerValueOfTC()).valueOfLDL(labTests.getValueOfLDL())
				.upperValueOfLDL(labTests.getUpperValueOfLDL()).lowerValueOfLDL(labTests.getLowerValueOfLDL())
				.heartRate(labTests.getHeartRate()).valueOfHDL(labTests.getValueOfHDL())
				.valueOfHB(labTests.getValueOfHB()).percentageOfLVEF(labTests.getPercentageOfLVEF()).build();

	}

	public LabTestsResponse createLabTests(CreateLabTestsRequestPayload payload) {

		try {

			if (null != payload) {

				Optional<LabTests> tests = labTestsRepository.findLabTestsByLabTestsId(payload.getLabTestsId());

				if (tests.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.LAB_TESTS_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {

					LabTests labTests = labTestsRepository.save(underwritingMapper.createPayloadToLabTests(payload));

					return LabTestsResponse.builder().labTestsId(labTests.getLabTestsId())
							.sugarInUrine(labTests.getSugarInUrine()).bilirubinInUrine(labTests.getBilirubinInUrine())
							.ketonesInUrine(labTests.getKetonesInUrine()).proteinInUrine(labTests.getProteinInUrine())
							.rbcBloodCountInUrine(labTests.getRbcBloodCountInUrine())
							.resultOfTMT(labTests.getResultOfTMT())
							.resultOfDobutamineStressECHO(labTests.getResultOfDobutamineStressECHO())
							.resultOfStressThallium(labTests.getResultOfStressThallium())
							.resultOfCTFindings(labTests.getResultOfCTFindings())
							.resultOfChestXRay(labTests.getResultOfChestXRay()).resultOfEcho(labTests.getResultOfEcho())
							.resultOfECG(labTests.getResultOfECG()).resultOfUSGAbdomen(labTests.getResultOfUSGAbdomen())
							.otherMedicalReports(labTests.getOtherMedicalReports())
							.crystalsInUrine(labTests.getCrystalsInUrine())
							.rbcWBCCastsInUrine(labTests.getRbcWBCCastsInUrine())
							.granularWaxyCasts(labTests.getGranularWaxyCasts())
							.wbcPlusCellsInUrine(labTests.getWbcPlusCellsInUrine()).rbcPerHPF(labTests.getRbcPerHPF())
							.countOfRBC(labTests.getCountOfRBC()).upperCountOfRBC(labTests.getUpperCountOfRBC())
							.lowerCountOfRBC(labTests.getLowerCountOfRBC()).pcvHematocrit(labTests.getPcvHematocrit())
							.upperCountOfPCVHematocrit(labTests.getUpperCountOfPCVHematocrit())
							.lowerCountOfPCVHematocrit(labTests.getLowerCountOfPCVHematocrit())
							.countOfMCV(labTests.getCountOfMCV()).upperCountOfMCV(labTests.getUpperCountOfMCV())
							.lowerCountOfMCV(labTests.getLowerCountOfMCV()).countOfMCH(labTests.getCountOfMCH())
							.upperCountOfMCH(labTests.getUpperCountOfMCH())
							.lowerCountOfMCH(labTests.getLowerCountOfMCH()).countOfMCHC(labTests.getCountOfMCHC())
							.upperCountOfMCHC(labTests.getUpperCountOfMCHC())
							.lowerCountOfMCHC(labTests.getLowerCountOfMCHC()).valueOfTSH(labTests.getValueOfTSH())
							.upperValueOfTSH(labTests.getUpperValueOfTSH())
							.lowerValueOfTSH(labTests.getLowerValueOfTSH()).valueOfTLC(labTests.getValueOfTLC())
							.upperValueOfTLC(labTests.getUpperValueOfTLC())
							.lowerValueOfTLC(labTests.getLowerValueOfTLC())
							.valueOfNeutrophil(labTests.getValueOfNeutrophil())
							.upperValueOfNeutrophil(labTests.getUpperValueOfNeutrophil())
							.lowerValueOfNeutrophil(labTests.getLowerValueOfNeutrophil())
							.valueOfEsoinophil(labTests.getValueOfEsoinophil())
							.upperValueOfEsoinophil(labTests.getUpperValueOfEsoinophil())
							.lowerValueOfEsoinophil(labTests.getLowerValueOfEsoinophil())
							.valueOfBasophil(labTests.getValueOfBasophil())
							.upperValueOfBasophil(labTests.getUpperValueOfBasophil())
							.lowerValueOfBasophil(labTests.getLowerValueOfBasophil())
							.valueOfMonocyte(labTests.getValueOfMonocyte())
							.upperValueOfMonocyte(labTests.getUpperValueOfMonocyte())
							.lowerValueOfMonocyte(labTests.getLowerValueOfMonocyte())
							.valueOfLymphocyte(labTests.getValueOfLymphocyte())
							.upperValueOfLymphocyte(labTests.getUpperValueOfLymphocyte())
							.lowerValueOfLymphocyte(labTests.getLowerValueOfLymphocyte())
							.countOfPlatelet(labTests.getCountOfPlatelet())
							.upperCountOfPlatelet(labTests.getUpperCountOfPlatelet())
							.lowerCountOfPlatelet(labTests.getLowerCountOfPlatelet())
							.valueOfESR(labTests.getValueOfESR()).upperValueOfESR(labTests.getUpperValueOfESR())
							.lowerValueOfESR(labTests.getLowerValueOfESR()).valueOfFBS(labTests.getValueOfFBS())
							.upperValueOfFBS(labTests.getUpperValueOfFBS())
							.lowerValueOfFBS(labTests.getLowerValueOfFBS()).valueOfHbA1C(labTests.getValueOfHbA1C())
							.upperValueOfHbA1C(labTests.getUpperValueOfHbA1C())
							.lowerValueOfHbA1C(labTests.getLowerValueOfHbA1C())
							.valueOfSerumCreatinineRFT(labTests.getValueOfSerumCreatinineRFT())
							.upperValueOfSerumCreatinineRFT(labTests.getUpperValueOfSerumCreatinineRFT())
							.lowerValueOfSerumCreatinineRFT(labTests.getLowerValueOfSerumCreatinineRFT())
							.amountOfUricAcid(labTests.getAmountOfUricAcid())
							.upperAmountOfUricAcid(labTests.getUpperAmountOfUricAcid())
							.lowerAmountOfUricAcid(labTests.getLowerAmountOfUricAcid())
							.valueOfSGOTAST(labTests.getValueOfSGOTAST())
							.upperValueOfSGOTAST(labTests.getUpperValueOfSGOTAST())
							.lowerValueOfSGOTAST(labTests.getLowerValueOfSGOTAST())
							.valueOfSGPTALT(labTests.getValueOfSGPTALT())
							.upperValueOfSGPTALT(labTests.getUpperValueOfSGPTALT())
							.lowerValueOfSGPTALT(labTests.getLowerValueOfSGPTALT())
							.ratioBetweenSGOAndSGPT(labTests.getRatioBetweenSGOAndSGPT())
							.valueOfBUN(labTests.getValueOfBUN()).upperValueOfBUN(labTests.getUpperValueOfBUN())
							.lowerValueOfBUN(labTests.getLowerValueOfBUN()).valueOfNA(labTests.getValueOfNA())
							.upperValueOfNA(labTests.getUpperValueOfNA()).lowerValueOfNA(labTests.getLowerValueOfNA())
							.valueOfK(labTests.getValueOfK()).upperValueOfK(labTests.getUpperValueOfK())
							.lowerValueOfK(labTests.getLowerValueOfK()).valueOfCA(labTests.getValueOfCA())
							.upperValueOfCA(labTests.getUpperValueOfCA()).lowerValueOfCA(labTests.getLowerValueOfCA())
							.valueOfPO4(labTests.getValueOfPO4()).upperValueOfPO4(labTests.getUpperValueOfPO4())
							.lowerValueOfPO4(labTests.getLowerValueOfPO4()).valueOfCI(labTests.getValueOfCI())
							.upperValueOfCI(labTests.getUpperValueOfCI()).lowerValueOfCI(labTests.getLowerValueOfCI())
							.valueOfHCO3(labTests.getValueOfHCO3()).upperValueOfHCO3(labTests.getUpperValueOfHCO3())
							.lowerValueOfHCO3(labTests.getLowerValueOfHCO3()).valueOfGGT(labTests.getValueOfGGT())
							.upperValueOfGGT(labTests.getUpperValueOfGGT())
							.lowerValueOfGGT(labTests.getLowerValueOfGGT()).valueOfALP(labTests.getValueOfALP())
							.upperValueOfALP(labTests.getUpperValueOfALP())
							.lowerValueOfALP(labTests.getLowerValueOfALP())
							.valueOfTotalBilirubin(labTests.getValueOfTotalBilirubin())
							.upperValueOfTotalBilirubin(labTests.getUpperValueOfTotalBilirubin())
							.lowerValueOfTotalBilirubin(labTests.getLowerValueOfTotalBilirubin())
							.valueOfSerumAlbumin(labTests.getValueOfSerumAlbumin())
							.upperValueOfSerumAlbumin(labTests.getUpperValueOfSerumAlbumin())
							.lowerValueOfSerumAlbumin(labTests.getLowerValueOfSerumAlbumin())
							.valueOfUrineMicroAlbumin(labTests.getValueOfUrineMicroAlbumin())
							.upperValueOfUrineMicroAlbumin(labTests.getUpperValueOfUrineMicroAlbumin())
							.lowerValueOfUrineMicroAlbumin(labTests.getLowerValueOfUrineMicroAlbumin())
							.valueOfTotalProtein(labTests.getValueOfTotalProtein())
							.upperValueOfTotalProtein(labTests.getUpperValueOfTotalProtein())
							.lowerValueOfTotalProtein(labTests.getLowerValueOfTotalProtein())
							.valueOfPSA(labTests.getValueOfPSA()).upperValueOfPSA(labTests.getUpperValueOfPSA())
							.lowerValueOfPSA(labTests.getLowerValueOfPSA()).valueOfTC(labTests.getValueOfTC())
							.upperValueOfTC(labTests.getUpperValueOfTC()).lowerValueOfTC(labTests.getLowerValueOfTC())
							.valueOfLDL(labTests.getValueOfLDL()).upperValueOfLDL(labTests.getUpperValueOfLDL())
							.lowerValueOfLDL(labTests.getLowerValueOfLDL()).heartRate(labTests.getHeartRate())
							.valueOfHDL(labTests.getValueOfHDL()).valueOfHB(labTests.getValueOfHB())
							.percentageOfLVEF(labTests.getPercentageOfLVEF()).build();
				}

			}

		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public LabTestsResponse updateLabTests(String labTestsId, UpdateLabTestsRequestPayload payload) {

		try {

			if (null != payload) {

				Optional<LabTests> labTests = labTestsRepository.findLabTestsByLabTestsId(labTestsId);

				log.info("Lab Tests before udpate : {}", labTests);

				if (labTests.isPresent()) {

					labTests.get().setSugarInUrine(payload.getSugarInUrine());
					labTests.get().setBilirubinInUrine(payload.getBilirubinInUrine());
					labTests.get().setKetonesInUrine(payload.getKetonesInUrine());
					labTests.get().setProteinInUrine(payload.getProteinInUrine());
					labTests.get().setRbcBloodCountInUrine(payload.getRbcBloodCountInUrine());
					labTests.get().setResultOfTMT(payload.getResultOfTMT());
					labTests.get().setResultOfDobutamineStressECHO(payload.getResultOfDobutamineStressECHO());
					labTests.get().setResultOfStressThallium(payload.getResultOfStressThallium());
					labTests.get().setResultOfCTFindings(payload.getResultOfCTFindings());
					labTests.get().setResultOfChestXRay(payload.getResultOfChestXRay());
					labTests.get().setResultOfEcho(payload.getResultOfEcho());
					labTests.get().setResultOfECG(payload.getResultOfECG());
					labTests.get().setResultOfUSGAbdomen(payload.getResultOfUSGAbdomen());
					labTests.get().setOtherMedicalReports(payload.getOtherMedicalReports());
					labTests.get().setCrystalsInUrine(payload.getCrystalsInUrine());
					labTests.get().setRbcWBCCastsInUrine(payload.getRbcWBCCastsInUrine());
					labTests.get().setGranularWaxyCasts(payload.getGranularWaxyCasts());
					labTests.get().setWbcPlusCellsInUrine(payload.getWbcPlusCellsInUrine());
					labTests.get().setRbcPerHPF(payload.getRbcPerHPF());
					labTests.get().setCountOfRBC(payload.getCountOfRBC());
					labTests.get().setUpperCountOfRBC(payload.getUpperCountOfRBC());
					labTests.get().setLowerCountOfRBC(payload.getLowerCountOfRBC());
					labTests.get().setPcvHematocrit(payload.getPcvHematocrit());
					labTests.get().setUpperCountOfPCVHematocrit(payload.getUpperCountOfPCVHematocrit());
					labTests.get().setLowerCountOfPCVHematocrit(payload.getLowerCountOfPCVHematocrit());
					labTests.get().setCountOfMCV(payload.getCountOfMCV());
					labTests.get().setUpperCountOfMCV(payload.getUpperCountOfMCV());
					labTests.get().setLowerCountOfMCV(payload.getLowerCountOfMCV());
					labTests.get().setCountOfMCH(payload.getCountOfMCH());
					labTests.get().setUpperCountOfMCH(payload.getUpperCountOfMCH());
					labTests.get().setLowerCountOfMCH(payload.getLowerCountOfMCH());
					labTests.get().setCountOfMCHC(payload.getCountOfMCHC());
					labTests.get().setUpperCountOfMCHC(payload.getUpperCountOfMCHC());
					labTests.get().setLowerCountOfMCHC(payload.getLowerCountOfMCHC());
					labTests.get().setValueOfTSH(payload.getValueOfTSH());
					labTests.get().setUpperValueOfTSH(payload.getUpperValueOfTSH());
					labTests.get().setLowerValueOfTSH(payload.getLowerValueOfTSH());
					labTests.get().setValueOfTLC(payload.getValueOfTLC());
					labTests.get().setUpperValueOfTLC(payload.getUpperValueOfTLC());
					labTests.get().setLowerValueOfTLC(payload.getLowerValueOfTLC());
					labTests.get().setValueOfNeutrophil(payload.getValueOfNeutrophil());
					labTests.get().setUpperValueOfNeutrophil(payload.getUpperValueOfNeutrophil());
					labTests.get().setLowerValueOfNeutrophil(payload.getLowerValueOfNeutrophil());
					labTests.get().setValueOfEsoinophil(payload.getValueOfEsoinophil());
					labTests.get().setUpperValueOfEsoinophil(payload.getUpperValueOfEsoinophil());
					labTests.get().setLowerValueOfEsoinophil(payload.getLowerValueOfEsoinophil());
					labTests.get().setValueOfBasophil(payload.getValueOfBasophil());
					labTests.get().setUpperValueOfBasophil(payload.getUpperValueOfBasophil());
					labTests.get().setLowerValueOfEsoinophil(payload.getLowerValueOfEsoinophil());
					labTests.get().setValueOfMonocyte(payload.getValueOfMonocyte());
					labTests.get().setUpperValueOfMonocyte(payload.getUpperValueOfMonocyte());
					labTests.get().setLowerValueOfMonocyte(payload.getLowerValueOfMonocyte());
					labTests.get().setValueOfLymphocyte(payload.getValueOfLymphocyte());
					labTests.get().setUpperValueOfLymphocyte(payload.getUpperValueOfLymphocyte());
					labTests.get().setLowerValueOfLymphocyte(payload.getLowerValueOfLymphocyte());
					labTests.get().setCountOfPlatelet(payload.getCountOfPlatelet());
					labTests.get().setUpperCountOfPlatelet(payload.getUpperCountOfPlatelet());
					labTests.get().setLowerCountOfPlatelet(payload.getLowerCountOfPlatelet());
					labTests.get().setValueOfESR(payload.getValueOfESR());
					labTests.get().setUpperValueOfESR(payload.getUpperValueOfESR());
					labTests.get().setLowerValueOfESR(payload.getLowerValueOfESR());
					labTests.get().setValueOfFBS(payload.getValueOfFBS());
					labTests.get().setUpperValueOfFBS(payload.getUpperValueOfFBS());
					labTests.get().setLowerValueOfFBS(payload.getLowerValueOfFBS());
					labTests.get().setValueOfHbA1C(payload.getValueOfHbA1C());
					labTests.get().setUpperValueOfHbA1C(payload.getUpperValueOfHbA1C());
					labTests.get().setLowerValueOfHbA1C(payload.getLowerValueOfHbA1C());
					labTests.get().setValueOfSerumCreatinineRFT(payload.getValueOfSerumCreatinineRFT());
					labTests.get().setUpperValueOfSerumCreatinineRFT(payload.getUpperValueOfSerumCreatinineRFT());
					labTests.get().setLowerValueOfSerumCreatinineRFT(payload.getLowerValueOfSerumCreatinineRFT());
					labTests.get().setAmountOfUricAcid(payload.getAmountOfUricAcid());
					labTests.get().setUpperAmountOfUricAcid(payload.getUpperAmountOfUricAcid());
					labTests.get().setLowerAmountOfUricAcid(payload.getLowerAmountOfUricAcid());
					labTests.get().setValueOfSGOTAST(payload.getValueOfSGOTAST());
					labTests.get().setUpperValueOfSGOTAST(payload.getUpperValueOfSGOTAST());
					labTests.get().setLowerValueOfSGOTAST(payload.getLowerValueOfSGOTAST());
					labTests.get().setValueOfSGPTALT(payload.getValueOfSGPTALT());
					labTests.get().setUpperValueOfSGPTALT(payload.getUpperValueOfSGPTALT());
					labTests.get().setLowerValueOfSGPTALT(payload.getLowerValueOfSGPTALT());
					labTests.get().setRatioBetweenSGOAndSGPT(payload.getRatioBetweenSGOAndSGPT());
					labTests.get().setValueOfBUN(payload.getValueOfBUN());
					labTests.get().setUpperValueOfBUN(payload.getUpperValueOfBUN());
					labTests.get().setLowerValueOfBUN(payload.getLowerValueOfBUN());
					labTests.get().setValueOfNA(payload.getValueOfNA());
					labTests.get().setUpperValueOfNA(payload.getUpperValueOfNA());
					labTests.get().setLowerValueOfNA(payload.getLowerValueOfNA());
					labTests.get().setValueOfK(payload.getValueOfK());
					labTests.get().setUpperValueOfK(payload.getUpperValueOfK());
					labTests.get().setLowerValueOfK(payload.getLowerValueOfK());
					labTests.get().setValueOfCA(payload.getValueOfCA());
					labTests.get().setUpperValueOfCA(payload.getUpperValueOfCA());
					labTests.get().setLowerValueOfCA(payload.getLowerValueOfCA());
					labTests.get().setValueOfPO4(payload.getValueOfPO4());
					labTests.get().setUpperValueOfPO4(payload.getUpperValueOfPO4());
					labTests.get().setLowerValueOfPO4(payload.getLowerValueOfPO4());
					labTests.get().setValueOfCI(payload.getValueOfCI());
					labTests.get().setUpperValueOfCI(payload.getUpperValueOfCI());
					labTests.get().setLowerValueOfCI(payload.getLowerValueOfCI());
					labTests.get().setValueOfHCO3(payload.getValueOfHCO3());
					labTests.get().setUpperValueOfHCO3(payload.getUpperValueOfHCO3());
					labTests.get().setLowerValueOfHCO3(payload.getLowerValueOfHCO3());
					labTests.get().setValueOfGGT(payload.getValueOfGGT());
					labTests.get().setUpperValueOfGGT(payload.getUpperValueOfGGT());
					labTests.get().setLowerValueOfGGT(payload.getLowerValueOfGGT());
					labTests.get().setValueOfALP(payload.getValueOfALP());
					labTests.get().setUpperValueOfALP(payload.getUpperValueOfALP());
					labTests.get().setLowerValueOfALP(payload.getLowerValueOfALP());
					labTests.get().setValueOfTotalBilirubin(payload.getValueOfTotalBilirubin());
					labTests.get().setUpperValueOfTotalBilirubin(payload.getUpperValueOfTotalBilirubin());
					labTests.get().setLowerValueOfTotalBilirubin(payload.getLowerValueOfTotalBilirubin());
					labTests.get().setValueOfSerumAlbumin(payload.getValueOfSerumAlbumin());
					labTests.get().setUpperValueOfSerumAlbumin(payload.getUpperValueOfSerumAlbumin());
					labTests.get().setLowerValueOfSerumAlbumin(payload.getLowerValueOfSerumAlbumin());
					labTests.get().setValueOfUrineMicroAlbumin(payload.getValueOfUrineMicroAlbumin());
					labTests.get().setUpperValueOfUrineMicroAlbumin(payload.getUpperValueOfUrineMicroAlbumin());
					labTests.get().setLowerValueOfUrineMicroAlbumin(payload.getLowerValueOfUrineMicroAlbumin());
					labTests.get().setValueOfTotalProtein(payload.getValueOfTotalProtein());
					labTests.get().setUpperValueOfTotalProtein(payload.getUpperValueOfTotalProtein());
					labTests.get().setLowerValueOfTotalProtein(payload.getLowerValueOfTotalProtein());
					labTests.get().setValueOfPSA(payload.getValueOfPSA());
					labTests.get().setUpperValueOfPSA(payload.getUpperValueOfPSA());
					labTests.get().setLowerValueOfPSA(payload.getLowerValueOfPSA());
					labTests.get().setValueOfTC(payload.getValueOfTC());
					labTests.get().setUpperValueOfTC(payload.getUpperValueOfTC());
					labTests.get().setLowerValueOfTC(payload.getLowerValueOfTC());
					labTests.get().setValueOfLDL(payload.getValueOfLDL());
					labTests.get().setUpperValueOfLDL(payload.getUpperValueOfLDL());
					labTests.get().setLowerValueOfLDL(payload.getLowerValueOfLDL());
					labTests.get().setHeartRate(payload.getHeartRate());
					labTests.get().setValueOfHDL(payload.getValueOfHDL());
					labTests.get().setValueOfHB(payload.getValueOfHB());
					labTests.get().setPercentageOfLVEF(payload.getPercentageOfLVEF());

					labTestsRepository.save(labTests.get());

					log.info("Lab Tests after update : {}", labTests);

					return LabTestsResponse.builder().labTestsId(labTests.get().getLabTestsId())
							.sugarInUrine(labTests.get().getSugarInUrine())
							.bilirubinInUrine(labTests.get().getBilirubinInUrine())
							.ketonesInUrine(labTests.get().getKetonesInUrine())
							.proteinInUrine(labTests.get().getProteinInUrine())
							.rbcBloodCountInUrine(labTests.get().getRbcBloodCountInUrine())
							.resultOfTMT(labTests.get().getResultOfTMT())
							.resultOfDobutamineStressECHO(labTests.get().getResultOfDobutamineStressECHO())
							.resultOfStressThallium(labTests.get().getResultOfStressThallium())
							.resultOfCTFindings(labTests.get().getResultOfCTFindings())
							.resultOfChestXRay(labTests.get().getResultOfChestXRay())
							.resultOfEcho(labTests.get().getResultOfEcho()).resultOfECG(labTests.get().getResultOfECG())
							.resultOfUSGAbdomen(labTests.get().getResultOfUSGAbdomen())
							.otherMedicalReports(labTests.get().getOtherMedicalReports())
							.crystalsInUrine(labTests.get().getCrystalsInUrine())
							.rbcWBCCastsInUrine(labTests.get().getRbcWBCCastsInUrine())
							.granularWaxyCasts(labTests.get().getGranularWaxyCasts())
							.wbcPlusCellsInUrine(labTests.get().getWbcPlusCellsInUrine())
							.rbcPerHPF(labTests.get().getRbcPerHPF()).countOfRBC(labTests.get().getCountOfRBC())
							.upperCountOfRBC(labTests.get().getUpperCountOfRBC())
							.lowerCountOfRBC(labTests.get().getLowerCountOfRBC())
							.pcvHematocrit(labTests.get().getPcvHematocrit())
							.upperCountOfPCVHematocrit(labTests.get().getUpperCountOfPCVHematocrit())
							.lowerCountOfPCVHematocrit(labTests.get().getLowerCountOfPCVHematocrit())
							.countOfMCV(labTests.get().getCountOfMCV())
							.upperCountOfMCV(labTests.get().getUpperCountOfMCV())
							.lowerCountOfMCV(labTests.get().getLowerCountOfMCV())
							.countOfMCH(labTests.get().getCountOfMCH())
							.upperCountOfMCH(labTests.get().getUpperCountOfMCH())
							.lowerCountOfMCH(labTests.get().getLowerCountOfMCH())
							.countOfMCHC(labTests.get().getCountOfMCHC())
							.upperCountOfMCHC(labTests.get().getUpperCountOfMCHC())
							.lowerCountOfMCHC(labTests.get().getLowerCountOfMCHC())
							.valueOfTSH(labTests.get().getValueOfTSH())
							.upperValueOfTSH(labTests.get().getUpperValueOfTSH())
							.lowerValueOfTSH(labTests.get().getLowerValueOfTSH())
							.valueOfTLC(labTests.get().getValueOfTLC())
							.upperValueOfTLC(labTests.get().getUpperValueOfTLC())
							.lowerValueOfTLC(labTests.get().getLowerValueOfTLC())
							.valueOfNeutrophil(labTests.get().getValueOfNeutrophil())
							.upperValueOfNeutrophil(labTests.get().getUpperValueOfNeutrophil())
							.lowerValueOfNeutrophil(labTests.get().getLowerValueOfNeutrophil())
							.valueOfEsoinophil(labTests.get().getValueOfEsoinophil())
							.upperValueOfEsoinophil(labTests.get().getUpperValueOfEsoinophil())
							.lowerValueOfEsoinophil(labTests.get().getLowerValueOfEsoinophil())
							.valueOfBasophil(labTests.get().getValueOfBasophil())
							.upperValueOfBasophil(labTests.get().getUpperValueOfBasophil())
							.lowerValueOfBasophil(labTests.get().getLowerValueOfBasophil())
							.valueOfMonocyte(labTests.get().getValueOfMonocyte())
							.upperValueOfMonocyte(labTests.get().getUpperValueOfMonocyte())
							.lowerValueOfMonocyte(labTests.get().getLowerValueOfMonocyte())
							.valueOfLymphocyte(labTests.get().getValueOfLymphocyte())
							.upperValueOfLymphocyte(labTests.get().getUpperValueOfLymphocyte())
							.lowerValueOfLymphocyte(labTests.get().getLowerValueOfLymphocyte())
							.countOfPlatelet(labTests.get().getCountOfPlatelet())
							.upperCountOfPlatelet(labTests.get().getUpperCountOfPlatelet())
							.lowerCountOfPlatelet(labTests.get().getLowerCountOfPlatelet())
							.valueOfESR(labTests.get().getValueOfESR())
							.upperValueOfESR(labTests.get().getUpperValueOfESR())
							.lowerValueOfESR(labTests.get().getLowerValueOfESR())
							.valueOfFBS(labTests.get().getValueOfFBS())
							.upperValueOfFBS(labTests.get().getUpperValueOfFBS())
							.lowerValueOfFBS(labTests.get().getLowerValueOfFBS())
							.valueOfHbA1C(labTests.get().getValueOfHbA1C())
							.upperValueOfHbA1C(labTests.get().getUpperValueOfHbA1C())
							.lowerValueOfHbA1C(labTests.get().getLowerValueOfHbA1C())
							.valueOfSerumCreatinineRFT(labTests.get().getValueOfSerumCreatinineRFT())
							.upperValueOfSerumCreatinineRFT(labTests.get().getUpperValueOfSerumCreatinineRFT())
							.lowerValueOfSerumCreatinineRFT(labTests.get().getLowerValueOfSerumCreatinineRFT())
							.amountOfUricAcid(labTests.get().getAmountOfUricAcid())
							.upperAmountOfUricAcid(labTests.get().getUpperAmountOfUricAcid())
							.lowerAmountOfUricAcid(labTests.get().getLowerAmountOfUricAcid())
							.valueOfSGOTAST(labTests.get().getValueOfSGOTAST())
							.upperValueOfSGOTAST(labTests.get().getUpperValueOfSGOTAST())
							.lowerValueOfSGOTAST(labTests.get().getLowerValueOfSGOTAST())
							.valueOfSGPTALT(labTests.get().getValueOfSGPTALT())
							.upperValueOfSGPTALT(labTests.get().getUpperValueOfSGPTALT())
							.lowerValueOfSGPTALT(labTests.get().getLowerValueOfSGPTALT())
							.ratioBetweenSGOAndSGPT(labTests.get().getRatioBetweenSGOAndSGPT())
							.valueOfBUN(labTests.get().getValueOfBUN())
							.upperValueOfBUN(labTests.get().getUpperValueOfBUN())
							.lowerValueOfBUN(labTests.get().getLowerValueOfBUN())
							.valueOfNA(labTests.get().getValueOfNA()).upperValueOfNA(labTests.get().getUpperValueOfNA())
							.lowerValueOfNA(labTests.get().getLowerValueOfNA()).valueOfK(labTests.get().getValueOfK())
							.upperValueOfK(labTests.get().getUpperValueOfK())
							.lowerValueOfK(labTests.get().getLowerValueOfK()).valueOfCA(labTests.get().getValueOfCA())
							.upperValueOfCA(labTests.get().getUpperValueOfCA())
							.lowerValueOfCA(labTests.get().getLowerValueOfCA())
							.valueOfPO4(labTests.get().getValueOfPO4())
							.upperValueOfPO4(labTests.get().getUpperValueOfPO4())
							.lowerValueOfPO4(labTests.get().getLowerValueOfPO4())
							.valueOfCI(labTests.get().getValueOfCI()).upperValueOfCI(labTests.get().getUpperValueOfCI())
							.lowerValueOfCI(labTests.get().getLowerValueOfCI())
							.valueOfHCO3(labTests.get().getValueOfHCO3())
							.upperValueOfHCO3(labTests.get().getUpperValueOfHCO3())
							.lowerValueOfHCO3(labTests.get().getLowerValueOfHCO3())
							.valueOfGGT(labTests.get().getValueOfGGT())
							.upperValueOfGGT(labTests.get().getUpperValueOfGGT())
							.lowerValueOfGGT(labTests.get().getLowerValueOfGGT())
							.valueOfALP(labTests.get().getValueOfALP())
							.upperValueOfALP(labTests.get().getUpperValueOfALP())
							.lowerValueOfALP(labTests.get().getLowerValueOfALP())
							.valueOfTotalBilirubin(labTests.get().getValueOfTotalBilirubin())
							.upperValueOfTotalBilirubin(labTests.get().getUpperValueOfTotalBilirubin())
							.lowerValueOfTotalBilirubin(labTests.get().getLowerValueOfTotalBilirubin())
							.valueOfSerumAlbumin(labTests.get().getValueOfSerumAlbumin())
							.upperValueOfSerumAlbumin(labTests.get().getUpperValueOfSerumAlbumin())
							.lowerValueOfSerumAlbumin(labTests.get().getLowerValueOfSerumAlbumin())
							.valueOfUrineMicroAlbumin(labTests.get().getValueOfUrineMicroAlbumin())
							.upperValueOfUrineMicroAlbumin(labTests.get().getUpperValueOfUrineMicroAlbumin())
							.lowerValueOfUrineMicroAlbumin(labTests.get().getLowerValueOfUrineMicroAlbumin())
							.valueOfTotalProtein(labTests.get().getValueOfTotalProtein())
							.upperValueOfTotalProtein(labTests.get().getUpperValueOfTotalProtein())
							.lowerValueOfTotalProtein(labTests.get().getLowerValueOfTotalProtein())
							.valueOfPSA(labTests.get().getValueOfPSA())
							.upperValueOfPSA(labTests.get().getUpperValueOfPSA())
							.lowerValueOfPSA(labTests.get().getLowerValueOfPSA())
							.valueOfTC(labTests.get().getValueOfTC()).upperValueOfTC(labTests.get().getUpperValueOfTC())
							.lowerValueOfTC(labTests.get().getLowerValueOfTC())
							.valueOfLDL(labTests.get().getValueOfLDL())
							.upperValueOfLDL(labTests.get().getUpperValueOfLDL())
							.lowerValueOfLDL(labTests.get().getLowerValueOfLDL())
							.heartRate(labTests.get().getHeartRate()).valueOfHDL(labTests.get().getValueOfHDL())
							.valueOfHB(labTests.get().getValueOfHB())
							.percentageOfLVEF(labTests.get().getPercentageOfLVEF()).build();

				} else {
					throw new UnderwritingException("404", UnderwritingConstants.LAB_TESTS_ID_NOT_FOUND,
							HttpStatus.NOT_FOUND);
				}

			}

		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public void deleteLabTestsById(String labTestsId) {

		try {
			Optional<LabTests> labTests = labTestsRepository.findLabTestsByLabTestsId(labTestsId);
			labTests.ifPresent(labTestsRepository::delete);
		} catch (UnderwritingException e) {
			throw new UnderwritingException("404", UnderwritingConstants.LAB_TESTS_ID_NOT_FOUND, HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * Business logics related to personal medical conditions - Test PMC regressive
	 */

	public PersonalMedicalConditionsResponse findPersonalMedicalConditionsById(String personalMedicalConditionsId) {

		PersonalMedicalConditions personalMedicalConditions = personalMedicalConditionsRepository
				.findPersonalMedicalConditionsByPersonalMedicalConditionsId(personalMedicalConditionsId)
				.orElseThrow(() -> new UnderwritingException("404",
						UnderwritingConstants.PERSONAL_MEDICAL_CONDITIONS_ID_NOT_FOUND, HttpStatus.NOT_FOUND));

		return PersonalMedicalConditionsResponse.builder()
				.personalMedicalConditionsId(personalMedicalConditions.getPersonalMedicalConditionsId())
				.diseaseQuestionnaire(findDiseaseQuestionnaireById(
						personalMedicalConditions.getDiseaseQuestionnaire().getDiseaseQuestionnaireId()))
				.nameOfDisease(personalMedicalConditions.getNameOfDisease())
				.typeOfDisease(personalMedicalConditions.getTypeOfDisease())
				.typeOfTreatment(personalMedicalConditions.getTypeOfTreatment())
				.currentStatusOfDisease(personalMedicalConditions.getCurrentStatusOfDisease())
				.typeOfComplication(personalMedicalConditions.getTypeOfComplication())
				.typeOfBiopsy(personalMedicalConditions.getTypeOfBiopsy())
				.lastConsultationDate(personalMedicalConditions.getLastConsultationDate())
				.yearWhenFirstDiagnosisWasTaken(personalMedicalConditions.getYearWhenFirstDiagnosisWasTaken()).build();

	}

	public PersonalMedicalConditionsResponse createPersonalMedicalConditions(
			CreatePersonalMedicalConditionsRequestPayload payload) {

		try {

			if (null != payload) {

				Optional<PersonalMedicalConditions> personalMedicalConditions = personalMedicalConditionsRepository
						.findPersonalMedicalConditionsByPersonalMedicalConditionsId(
								payload.getPersonalMedicalConditionsId());

				if (personalMedicalConditions.isPresent()) {
					throw new UnderwritingException("409", UnderwritingConstants.PERSONAL_MEDICAL_CONDITIONS_ID_FOUND,
							HttpStatus.CONFLICT);
				} else {

					PersonalMedicalConditions medicalConditions = personalMedicalConditionsRepository
							.save(underwritingMapper.createPayloadToPersonalMedicalConditions(payload));

					return PersonalMedicalConditionsResponse.builder()
							.personalMedicalConditionsId(medicalConditions.getPersonalMedicalConditionsId())
							.diseaseQuestionnaire(underwritingMapper
									.diseaseQuestionnaireEntityToResponse(medicalConditions.getDiseaseQuestionnaire()))
							.nameOfDisease(medicalConditions.getNameOfDisease())
							.typeOfDisease(medicalConditions.getTypeOfDisease())
							.typeOfTreatment(medicalConditions.getTypeOfTreatment())
							.currentStatusOfDisease(medicalConditions.getCurrentStatusOfDisease())
							.typeOfComplication(medicalConditions.getTypeOfComplication())
							.typeOfBiopsy(medicalConditions.getTypeOfBiopsy())
							.lastConsultationDate(medicalConditions.getLastConsultationDate())
							.yearWhenFirstDiagnosisWasTaken(medicalConditions.getYearWhenFirstDiagnosisWasTaken())
							.build();

				}

			}

		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public PersonalMedicalConditionsResponse updatePersonalMedicalConditions(String personalMedicalConditionsId,
			UpdatePersonalMedicalConditionsRequestPayload payload) {

		try {

			if (null != payload) {

				Optional<PersonalMedicalConditions> medicalConditions = personalMedicalConditionsRepository
						.findPersonalMedicalConditionsByPersonalMedicalConditionsId(personalMedicalConditionsId);

				if (medicalConditions.isPresent()) {

					medicalConditions.get().setDiseaseQuestionnaire(
							underwritingMapper.diseaseQuestionnaireResponseToEntity(updateDiseaseQuestionnaire(
									medicalConditions.get().getDiseaseQuestionnaire().getDiseaseQuestionnaireId(),
									payload.getDiseaseQuestionnaire())));
					medicalConditions.get().setNameOfDisease(payload.getNameOfDisease());
					medicalConditions.get().setTypeOfDisease(payload.getTypeOfDisease());
					medicalConditions.get().setTypeOfTreatment(payload.getTypeOfTreatment());
					medicalConditions.get().setCurrentStatusOfDisease(payload.getCurrentStatusOfDisease());
					medicalConditions.get().setTypeOfComplication(payload.getTypeOfComplication());
					medicalConditions.get().setTypeOfBiopsy(payload.getTypeOfBiopsy());
					medicalConditions.get().setLastConsultationDate(payload.getLastConsultationDate());
					medicalConditions.get()
							.setYearWhenFirstDiagnosisWasTaken(payload.getYearWhenFirstDiagnosisWasTaken());

					personalMedicalConditionsRepository.save(medicalConditions.get());

					return PersonalMedicalConditionsResponse.builder()
							.personalMedicalConditionsId(medicalConditions.get().getPersonalMedicalConditionsId())
							.diseaseQuestionnaire(findDiseaseQuestionnaireById(
									medicalConditions.get().getDiseaseQuestionnaire().getDiseaseQuestionnaireId()))
							.nameOfDisease(medicalConditions.get().getNameOfDisease())
							.typeOfDisease(medicalConditions.get().getTypeOfDisease())
							.typeOfTreatment(medicalConditions.get().getTypeOfTreatment())
							.currentStatusOfDisease(medicalConditions.get().getCurrentStatusOfDisease())
							.typeOfComplication(medicalConditions.get().getTypeOfComplication())
							.typeOfBiopsy(medicalConditions.get().getTypeOfBiopsy())
							.lastConsultationDate(medicalConditions.get().getLastConsultationDate())
							.yearWhenFirstDiagnosisWasTaken(medicalConditions.get().getYearWhenFirstDiagnosisWasTaken())
							.build();

				} else {
					throw new UnderwritingException("404",
							UnderwritingConstants.PERSONAL_MEDICAL_CONDITIONS_ID_NOT_FOUND, HttpStatus.NOT_FOUND);
				}
			}

		} catch (UnderwritingException e) {
			throw new UnderwritingException("400", UnderwritingConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}

		return null;

	}

	public void deletePersonalMedicalConditionsById(String personalMedicalConditionsId) {

		try {

			Optional<PersonalMedicalConditions> personalMedicalConditions = personalMedicalConditionsRepository
					.findPersonalMedicalConditionsByPersonalMedicalConditionsId(personalMedicalConditionsId);
			personalMedicalConditions.ifPresent(personalMedicalConditionsRepository::delete);

		} catch (UnderwritingException e) {
			throw new UnderwritingException("404", UnderwritingConstants.PERSONAL_MEDICAL_CONDITIONS_ID_NOT_FOUND,
					HttpStatus.NOT_FOUND);
		}

	}

}
