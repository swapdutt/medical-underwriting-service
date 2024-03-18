package com.medical.underwriting.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.medical.underwriting.model.entity.medical.DiseaseQuestionnaire;
import com.medical.underwriting.model.entity.medical.LabTests;
import com.medical.underwriting.model.entity.medical.PersonalMedicalConditions;
import com.medical.underwriting.payloads.request.update.UpdateDiseaseQuestionnaireRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateLabTestsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdatePersonalMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.response.DiseaseQuestionnaireResponse;
import com.medical.underwriting.payloads.response.LabTestsResponse;
import com.medical.underwriting.payloads.response.PersonalMedicalConditionsResponse;

@Component
public class UnderwritingUtility {

	public DiseaseQuestionnaireResponse diseaseQuestionnaireEntityToResponse(DiseaseQuestionnaire questionnaire) {

		DiseaseQuestionnaireResponse response = new DiseaseQuestionnaireResponse();

		if (!questionnaire.getId().isBlank() || !questionnaire.getDiseaseQuestionnaireId().isBlank()
				|| !questionnaire.getQuestion1().isBlank() || !questionnaire.getQuestion2().isBlank()
				|| !questionnaire.getQuestion3().isBlank() || !questionnaire.getQuestion4().isBlank()
				|| !questionnaire.getQuestion5().isBlank() || !questionnaire.getQuestion6().isBlank()
				|| !questionnaire.getQuestion7().isBlank() || !questionnaire.getQuestion8().isBlank()
				|| !questionnaire.getQuestion9().isBlank() || !questionnaire.getQuestion10().isBlank()
				|| !questionnaire.getQuestion11().isBlank() || !questionnaire.getQuestion12().isBlank()) {

			response.setDiseaseQuestionnaireId(questionnaire.getDiseaseQuestionnaireId());
			response.setQuestion1(questionnaire.getQuestion1());
			response.setQuestion2(questionnaire.getQuestion2());
			response.setQuestion3(questionnaire.getQuestion3());
			response.setQuestion4(questionnaire.getQuestion4());
			response.setQuestion5(questionnaire.getQuestion5());
			response.setQuestion6(questionnaire.getQuestion6());
			response.setQuestion7(questionnaire.getQuestion7());
			response.setQuestion8(questionnaire.getQuestion8());
			response.setQuestion9(questionnaire.getQuestion9());
			response.setQuestion10(questionnaire.getQuestion10());
			response.setQuestion11(questionnaire.getQuestion11());
			response.setQuestion12(questionnaire.getQuestion12());

		}

		return response;

	}

	public DiseaseQuestionnaire diseaseQuestionnaireResponseToEntity(DiseaseQuestionnaireResponse response) {

		DiseaseQuestionnaire questionnaire = new DiseaseQuestionnaire();

		if (!response.getDiseaseQuestionnaireId().isBlank() || !response.getQuestion1().isBlank()
				|| !response.getQuestion2().isBlank() || !response.getQuestion3().isBlank()
				|| !response.getQuestion4().isBlank() || !response.getQuestion5().isBlank()
				|| !response.getQuestion6().isBlank() || !response.getQuestion7().isBlank()
				|| !response.getQuestion8().isBlank() || !response.getQuestion9().isBlank()
				|| !response.getQuestion10().isBlank() || !response.getQuestion11().isBlank()
				|| !response.getQuestion12().isBlank()) {

			questionnaire.setDiseaseQuestionnaireId(response.getDiseaseQuestionnaireId());
			questionnaire.setQuestion1(response.getQuestion1());
			questionnaire.setQuestion2(response.getQuestion2());
			questionnaire.setQuestion3(response.getQuestion3());
			questionnaire.setQuestion4(response.getQuestion4());
			questionnaire.setQuestion5(response.getQuestion5());
			questionnaire.setQuestion6(response.getQuestion6());
			questionnaire.setQuestion7(response.getQuestion7());
			questionnaire.setQuestion8(response.getQuestion8());
			questionnaire.setQuestion9(response.getQuestion9());
			questionnaire.setQuestion10(response.getQuestion10());
			questionnaire.setQuestion11(response.getQuestion11());
			questionnaire.setQuestion12(response.getQuestion12());

		}

		return questionnaire;

	}

	public LabTestsResponse labTestsEntityToResponse(LabTests labTests) {

		LabTestsResponse labTestsResponse = new LabTestsResponse();

		if (null != labTests) {
			labTestsResponse.setLabTestsId(labTests.getLabTestsId());
			labTestsResponse.setSugarInUrine(labTests.getSugarInUrine());
			labTestsResponse.setBilirubinInUrine(labTests.getBilirubinInUrine());
			labTestsResponse.setKetonesInUrine(labTests.getKetonesInUrine());
			labTestsResponse.setProteinInUrine(labTests.getProteinInUrine());
			labTestsResponse.setRbcBloodCountInUrine(labTests.getRbcBloodCountInUrine());
			labTestsResponse.setResultOfTMT(labTests.getResultOfTMT());
			labTestsResponse.setResultOfDobutamineStressECHO(labTests.getResultOfDobutamineStressECHO());
			labTestsResponse.setResultOfStressThallium(labTests.getResultOfStressThallium());
			labTestsResponse.setResultOfCTFindings(labTests.getResultOfCTFindings());
			labTestsResponse.setResultOfChestXRay(labTests.getResultOfChestXRay());
			labTestsResponse.setResultOfEcho(labTests.getResultOfEcho());
			labTestsResponse.setResultOfECG(labTests.getResultOfECG());
			labTestsResponse.setResultOfUSGAbdomen(labTests.getResultOfUSGAbdomen());
			labTestsResponse.setOtherMedicalReports(labTests.getOtherMedicalReports());
			labTestsResponse.setCrystalsInUrine(labTests.getCrystalsInUrine());
			labTestsResponse.setRbcWBCCastsInUrine(labTests.getRbcWBCCastsInUrine());
			labTestsResponse.setGranularWaxyCasts(labTests.getGranularWaxyCasts());
			labTestsResponse.setWbcPlusCellsInUrine(labTests.getWbcPlusCellsInUrine());
			labTestsResponse.setRbcPerHPF(labTests.getRbcPerHPF());
			labTestsResponse.setCountOfRBC(labTests.getCountOfRBC());
			labTestsResponse.setUpperCountOfRBC(labTests.getUpperCountOfRBC());
			labTestsResponse.setLowerCountOfRBC(labTests.getLowerCountOfRBC());
			labTestsResponse.setPcvHematocrit(labTests.getPcvHematocrit());
			labTestsResponse.setUpperCountOfPCVHematocrit(labTests.getUpperCountOfPCVHematocrit());
			labTestsResponse.setLowerCountOfPCVHematocrit(labTests.getLowerCountOfPCVHematocrit());
			labTestsResponse.setCountOfMCV(labTests.getCountOfMCV());
			labTestsResponse.setUpperCountOfMCV(labTests.getUpperCountOfMCV());
			labTestsResponse.setLowerCountOfMCV(labTests.getLowerCountOfMCV());
			labTestsResponse.setCountOfMCH(labTests.getCountOfMCH());
			labTestsResponse.setUpperCountOfMCH(labTests.getUpperCountOfMCH());
			labTestsResponse.setLowerCountOfMCH(labTests.getLowerCountOfMCH());
			labTestsResponse.setCountOfMCHC(labTests.getCountOfMCHC());
			labTestsResponse.setUpperCountOfMCHC(labTests.getUpperCountOfMCHC());
			labTestsResponse.setLowerCountOfMCHC(labTests.getLowerCountOfMCHC());
			labTestsResponse.setValueOfTSH(labTests.getValueOfTSH());
			labTestsResponse.setUpperValueOfTSH(labTests.getUpperValueOfTSH());
			labTestsResponse.setLowerValueOfTSH(labTests.getLowerValueOfTSH());
			labTestsResponse.setValueOfTLC(labTests.getValueOfTLC());
			labTestsResponse.setUpperValueOfTLC(labTests.getUpperValueOfTLC());
			labTestsResponse.setLowerValueOfTLC(labTests.getLowerValueOfTLC());
			labTestsResponse.setValueOfNeutrophil(labTests.getValueOfNeutrophil());
			labTestsResponse.setUpperValueOfNeutrophil(labTests.getUpperValueOfNeutrophil());
			labTestsResponse.setLowerValueOfNeutrophil(labTests.getLowerValueOfNeutrophil());
			labTestsResponse.setValueOfEsoinophil(labTests.getValueOfEsoinophil());
			labTestsResponse.setUpperValueOfEsoinophil(labTests.getUpperValueOfEsoinophil());
			labTestsResponse.setLowerValueOfEsoinophil(labTests.getLowerValueOfEsoinophil());
			labTestsResponse.setValueOfBasophil(labTests.getValueOfBasophil());
			labTestsResponse.setUpperValueOfBasophil(labTests.getUpperValueOfBasophil());
			labTestsResponse.setLowerValueOfEsoinophil(labTests.getLowerValueOfEsoinophil());
			labTestsResponse.setValueOfMonocyte(labTests.getValueOfMonocyte());
			labTestsResponse.setUpperValueOfMonocyte(labTests.getUpperValueOfMonocyte());
			labTestsResponse.setLowerValueOfMonocyte(labTests.getLowerValueOfMonocyte());
			labTestsResponse.setValueOfLymphocyte(labTests.getValueOfLymphocyte());
			labTestsResponse.setUpperValueOfLymphocyte(labTests.getUpperValueOfLymphocyte());
			labTestsResponse.setLowerValueOfLymphocyte(labTests.getLowerValueOfLymphocyte());
			labTestsResponse.setCountOfPlatelet(labTests.getCountOfPlatelet());
			labTestsResponse.setUpperCountOfPlatelet(labTests.getUpperCountOfPlatelet());
			labTestsResponse.setLowerCountOfPlatelet(labTests.getLowerCountOfPlatelet());
			labTestsResponse.setValueOfESR(labTests.getValueOfESR());
			labTestsResponse.setUpperValueOfESR(labTests.getUpperValueOfESR());
			labTestsResponse.setLowerValueOfESR(labTests.getLowerValueOfESR());
			labTestsResponse.setValueOfFBS(labTests.getValueOfFBS());
			labTestsResponse.setUpperValueOfFBS(labTests.getUpperValueOfFBS());
			labTestsResponse.setLowerValueOfFBS(labTests.getLowerValueOfFBS());
			labTestsResponse.setValueOfHbA1C(labTests.getValueOfHbA1C());
			labTestsResponse.setUpperValueOfHbA1C(labTests.getUpperValueOfHbA1C());
			labTestsResponse.setLowerValueOfHbA1C(labTests.getLowerValueOfHbA1C());
			labTestsResponse.setValueOfSerumCreatinineRFT(labTests.getValueOfSerumCreatinineRFT());
			labTestsResponse.setUpperValueOfSerumCreatinineRFT(labTests.getUpperValueOfSerumCreatinineRFT());
			labTestsResponse.setLowerValueOfSerumCreatinineRFT(labTests.getLowerValueOfSerumCreatinineRFT());
			labTestsResponse.setAmountOfUricAcid(labTests.getAmountOfUricAcid());
			labTestsResponse.setUpperAmountOfUricAcid(labTests.getUpperAmountOfUricAcid());
			labTestsResponse.setLowerAmountOfUricAcid(labTests.getLowerAmountOfUricAcid());
			labTestsResponse.setValueOfSGOTAST(labTests.getValueOfSGOTAST());
			labTestsResponse.setUpperValueOfSGOTAST(labTests.getUpperValueOfSGOTAST());
			labTestsResponse.setLowerValueOfSGOTAST(labTests.getLowerValueOfSGOTAST());
			labTestsResponse.setValueOfSGPTALT(labTests.getValueOfSGPTALT());
			labTestsResponse.setUpperValueOfSGPTALT(labTests.getUpperValueOfSGPTALT());
			labTestsResponse.setLowerValueOfSGPTALT(labTests.getLowerValueOfSGPTALT());
			labTestsResponse.setRatioBetweenSGOAndSGPT(labTests.getRatioBetweenSGOAndSGPT());
			labTestsResponse.setValueOfBUN(labTests.getValueOfBUN());
			labTestsResponse.setUpperValueOfBUN(labTests.getUpperValueOfBUN());
			labTestsResponse.setLowerValueOfBUN(labTests.getLowerValueOfBUN());
			labTestsResponse.setValueOfNA(labTests.getValueOfNA());
			labTestsResponse.setUpperValueOfNA(labTests.getUpperValueOfNA());
			labTestsResponse.setLowerValueOfNA(labTests.getLowerValueOfNA());
			labTestsResponse.setValueOfK(labTests.getValueOfK());
			labTestsResponse.setUpperValueOfK(labTests.getUpperValueOfK());
			labTestsResponse.setLowerValueOfK(labTests.getLowerValueOfK());
			labTestsResponse.setValueOfCA(labTests.getValueOfCA());
			labTestsResponse.setUpperValueOfCA(labTests.getUpperValueOfCA());
			labTestsResponse.setLowerValueOfCA(labTests.getLowerValueOfCA());
			labTestsResponse.setValueOfPO4(labTests.getValueOfPO4());
			labTestsResponse.setUpperValueOfPO4(labTests.getUpperValueOfPO4());
			labTestsResponse.setLowerValueOfPO4(labTests.getLowerValueOfPO4());
			labTestsResponse.setValueOfCI(labTests.getValueOfCI());
			labTestsResponse.setUpperValueOfCI(labTests.getUpperValueOfCI());
			labTestsResponse.setLowerValueOfCI(labTests.getLowerValueOfCI());
			labTestsResponse.setValueOfHCO3(labTests.getValueOfHCO3());
			labTestsResponse.setUpperValueOfHCO3(labTests.getUpperValueOfHCO3());
			labTestsResponse.setLowerValueOfHCO3(labTests.getLowerValueOfHCO3());
			labTestsResponse.setValueOfGGT(labTests.getValueOfGGT());
			labTestsResponse.setUpperValueOfGGT(labTests.getUpperValueOfGGT());
			labTestsResponse.setLowerValueOfGGT(labTests.getLowerValueOfGGT());
			labTestsResponse.setValueOfALP(labTests.getValueOfALP());
			labTestsResponse.setUpperValueOfALP(labTests.getUpperValueOfALP());
			labTestsResponse.setLowerValueOfALP(labTests.getLowerValueOfALP());
			labTestsResponse.setValueOfTotalBilirubin(labTests.getValueOfTotalBilirubin());
			labTestsResponse.setUpperValueOfTotalBilirubin(labTests.getUpperValueOfTotalBilirubin());
			labTestsResponse.setLowerValueOfTotalBilirubin(labTests.getLowerValueOfTotalBilirubin());
			labTestsResponse.setValueOfSerumAlbumin(labTests.getValueOfSerumAlbumin());
			labTestsResponse.setUpperValueOfSerumAlbumin(labTests.getUpperValueOfSerumAlbumin());
			labTestsResponse.setLowerValueOfSerumAlbumin(labTests.getLowerValueOfSerumAlbumin());
			labTestsResponse.setValueOfUrineMicroAlbumin(labTests.getValueOfUrineMicroAlbumin());
			labTestsResponse.setUpperValueOfUrineMicroAlbumin(labTests.getUpperValueOfUrineMicroAlbumin());
			labTestsResponse.setLowerValueOfUrineMicroAlbumin(labTests.getLowerValueOfUrineMicroAlbumin());
			labTestsResponse.setValueOfTotalProtein(labTests.getValueOfTotalProtein());
			labTestsResponse.setUpperValueOfTotalProtein(labTests.getUpperValueOfTotalProtein());
			labTestsResponse.setLowerValueOfTotalProtein(labTests.getLowerValueOfTotalProtein());
			labTestsResponse.setValueOfPSA(labTests.getValueOfPSA());
			labTestsResponse.setUpperValueOfPSA(labTests.getUpperValueOfPSA());
			labTestsResponse.setLowerValueOfPSA(labTests.getLowerValueOfPSA());
			labTestsResponse.setValueOfTC(labTests.getValueOfTC());
			labTestsResponse.setUpperValueOfTC(labTests.getUpperValueOfTC());
			labTestsResponse.setLowerValueOfTC(labTests.getLowerValueOfTC());
			labTestsResponse.setValueOfLDL(labTests.getValueOfLDL());
			labTestsResponse.setUpperValueOfLDL(labTests.getUpperValueOfLDL());
			labTestsResponse.setLowerValueOfLDL(labTests.getLowerValueOfLDL());
			labTestsResponse.setHeartRate(labTests.getHeartRate());
			labTestsResponse.setValueOfHDL(labTests.getValueOfHDL());
			labTestsResponse.setValueOfHB(labTests.getValueOfHB());
			labTestsResponse.setPercentageOfLVEF(labTests.getPercentageOfLVEF());

		}

		return null;

	}

	public List<PersonalMedicalConditionsResponse> addPMCtoPMCR(
			List<PersonalMedicalConditions> personalMedicalConditions) {

		List<PersonalMedicalConditionsResponse> conditionsResponses = new ArrayList<>();
		PersonalMedicalConditionsResponse conditionsResponse = new PersonalMedicalConditionsResponse();

		if (!personalMedicalConditions.isEmpty()) {
			for (PersonalMedicalConditions medicalConditions : personalMedicalConditions) {
				conditionsResponse.setPersonalMedicalConditionsId(medicalConditions.getPersonalMedicalConditionsId());
				conditionsResponse.setDiseaseQuestionnaire(
						diseaseQuestionnaireEntityToResponse(medicalConditions.getDiseaseQuestionnaire()));
				conditionsResponse.setNameOfDisease(medicalConditions.getNameOfDisease());
				conditionsResponse.setTypeOfDisease(medicalConditions.getTypeOfDisease());
				conditionsResponse.setTypeOfTreatment(medicalConditions.getTypeOfTreatment());
				conditionsResponse.setCurrentStatusOfDisease(medicalConditions.getCurrentStatusOfDisease());
				conditionsResponse.setTypeOfComplication(medicalConditions.getTypeOfComplication());
				conditionsResponse.setTypeOfBiopsy(medicalConditions.getTypeOfBiopsy());
				conditionsResponse.setLastConsultationDate(medicalConditions.getLastConsultationDate());
				conditionsResponse
						.setYearWhenFirstDiagnosisWasTaken(medicalConditions.getYearWhenFirstDiagnosisWasTaken());

				conditionsResponses.add(conditionsResponse);

			}

			return conditionsResponses;
		}

		return Collections.emptyList();

	}

	public List<PersonalMedicalConditions> addUPMCtoPMC(List<UpdatePersonalMedicalConditionsRequestPayload> payloads) {

		List<PersonalMedicalConditions> medicalConditions = new ArrayList<>();
		PersonalMedicalConditions pmc = new PersonalMedicalConditions();

		if (!payloads.isEmpty()) {
			for (UpdatePersonalMedicalConditionsRequestPayload conditionsRequestPayload : payloads) {
				pmc.setPersonalMedicalConditionsId(conditionsRequestPayload.getPersonalMedicalConditionsId());
				pmc.setDiseaseQuestionnaire(
						diseaseQuestionnaireUpdatePayloadToEntity(conditionsRequestPayload.getDiseaseQuestionnaire()));
				pmc.setNameOfDisease(conditionsRequestPayload.getNameOfDisease());
				pmc.setTypeOfDisease(conditionsRequestPayload.getTypeOfDisease());
				pmc.setTypeOfTreatment(conditionsRequestPayload.getTypeOfTreatment());
				pmc.setCurrentStatusOfDisease(conditionsRequestPayload.getCurrentStatusOfDisease());
				pmc.setTypeOfComplication(conditionsRequestPayload.getTypeOfComplication());
				pmc.setTypeOfBiopsy(conditionsRequestPayload.getTypeOfBiopsy());
				pmc.setLastConsultationDate(conditionsRequestPayload.getLastConsultationDate());
				pmc.setYearWhenFirstDiagnosisWasTaken(conditionsRequestPayload.getYearWhenFirstDiagnosisWasTaken());

				medicalConditions.add(pmc);
			}

			return medicalConditions;

		}

		return Collections.emptyList();

	}

	private DiseaseQuestionnaire diseaseQuestionnaireUpdatePayloadToEntity(
			UpdateDiseaseQuestionnaireRequestPayload payload) {

		DiseaseQuestionnaire questionnaire = new DiseaseQuestionnaire();

		if (!payload.getQuestion1().isBlank() || !payload.getQuestion2().isBlank() || !payload.getQuestion3().isBlank()
				|| !payload.getQuestion4().isBlank() || !payload.getQuestion5().isBlank()
				|| !payload.getQuestion6().isBlank() || !payload.getQuestion7().isBlank()
				|| !payload.getQuestion8().isBlank() || !payload.getQuestion9().isBlank()
				|| !payload.getQuestion10().isBlank() || !payload.getQuestion11().isBlank()
				|| !payload.getQuestion12().isBlank()) {

			questionnaire.setQuestion1(payload.getQuestion1());
			questionnaire.setQuestion2(payload.getQuestion2());
			questionnaire.setQuestion3(payload.getQuestion3());
			questionnaire.setQuestion4(payload.getQuestion4());
			questionnaire.setQuestion5(payload.getQuestion5());
			questionnaire.setQuestion6(payload.getQuestion6());
			questionnaire.setQuestion7(payload.getQuestion7());
			questionnaire.setQuestion8(payload.getQuestion8());
			questionnaire.setQuestion9(payload.getQuestion9());
			questionnaire.setQuestion10(payload.getQuestion10());
			questionnaire.setQuestion11(payload.getQuestion11());
			questionnaire.setQuestion12(payload.getQuestion12());

		}

		return questionnaire;

	}

	public LabTests labTestsUpdatePayloadToEntity(UpdateLabTestsRequestPayload payload) {

		LabTests labTests = new LabTests();

		if (null != payload) {
			labTests.setSugarInUrine(payload.getSugarInUrine());
			labTests.setBilirubinInUrine(payload.getBilirubinInUrine());
			labTests.setKetonesInUrine(payload.getKetonesInUrine());
			labTests.setProteinInUrine(payload.getProteinInUrine());
			labTests.setRbcBloodCountInUrine(payload.getRbcBloodCountInUrine());
			labTests.setResultOfTMT(payload.getResultOfTMT());
			labTests.setResultOfDobutamineStressECHO(payload.getResultOfDobutamineStressECHO());
			labTests.setResultOfStressThallium(payload.getResultOfStressThallium());
			labTests.setResultOfCTFindings(payload.getResultOfCTFindings());
			labTests.setResultOfChestXRay(payload.getResultOfChestXRay());
			labTests.setResultOfEcho(payload.getResultOfEcho());
			labTests.setResultOfECG(payload.getResultOfECG());
			labTests.setResultOfUSGAbdomen(payload.getResultOfUSGAbdomen());
			labTests.setOtherMedicalReports(payload.getOtherMedicalReports());
			labTests.setCrystalsInUrine(payload.getCrystalsInUrine());
			labTests.setRbcWBCCastsInUrine(payload.getRbcWBCCastsInUrine());
			labTests.setGranularWaxyCasts(payload.getGranularWaxyCasts());
			labTests.setWbcPlusCellsInUrine(payload.getWbcPlusCellsInUrine());
			labTests.setRbcPerHPF(payload.getRbcPerHPF());
			labTests.setCountOfRBC(payload.getCountOfRBC());
			labTests.setUpperCountOfRBC(payload.getUpperCountOfRBC());
			labTests.setLowerCountOfRBC(payload.getLowerCountOfRBC());
			labTests.setPcvHematocrit(payload.getPcvHematocrit());
			labTests.setUpperCountOfPCVHematocrit(payload.getUpperCountOfPCVHematocrit());
			labTests.setLowerCountOfPCVHematocrit(payload.getLowerCountOfPCVHematocrit());
			labTests.setCountOfMCV(payload.getCountOfMCV());
			labTests.setUpperCountOfMCV(payload.getUpperCountOfMCV());
			labTests.setLowerCountOfMCV(payload.getLowerCountOfMCV());
			labTests.setCountOfMCH(payload.getCountOfMCH());
			labTests.setUpperCountOfMCH(payload.getUpperCountOfMCH());
			labTests.setLowerCountOfMCH(payload.getLowerCountOfMCH());
			labTests.setCountOfMCHC(payload.getCountOfMCHC());
			labTests.setUpperCountOfMCHC(payload.getUpperCountOfMCHC());
			labTests.setLowerCountOfMCHC(payload.getLowerCountOfMCHC());
			labTests.setValueOfTSH(payload.getValueOfTSH());
			labTests.setUpperValueOfTSH(payload.getUpperValueOfTSH());
			labTests.setLowerValueOfTSH(payload.getLowerValueOfTSH());
			labTests.setValueOfTLC(payload.getValueOfTLC());
			labTests.setUpperValueOfTLC(payload.getUpperValueOfTLC());
			labTests.setLowerValueOfTLC(payload.getLowerValueOfTLC());
			labTests.setValueOfNeutrophil(payload.getValueOfNeutrophil());
			labTests.setUpperValueOfNeutrophil(payload.getUpperValueOfNeutrophil());
			labTests.setLowerValueOfNeutrophil(payload.getLowerValueOfNeutrophil());
			labTests.setValueOfEsoinophil(payload.getValueOfEsoinophil());
			labTests.setUpperValueOfEsoinophil(payload.getUpperValueOfEsoinophil());
			labTests.setLowerValueOfEsoinophil(payload.getLowerValueOfEsoinophil());
			labTests.setValueOfBasophil(payload.getValueOfBasophil());
			labTests.setUpperValueOfBasophil(payload.getUpperValueOfBasophil());
			labTests.setLowerValueOfEsoinophil(payload.getLowerValueOfEsoinophil());
			labTests.setValueOfMonocyte(payload.getValueOfMonocyte());
			labTests.setUpperValueOfMonocyte(payload.getUpperValueOfMonocyte());
			labTests.setLowerValueOfMonocyte(payload.getLowerValueOfMonocyte());
			labTests.setValueOfLymphocyte(payload.getValueOfLymphocyte());
			labTests.setUpperValueOfLymphocyte(payload.getUpperValueOfLymphocyte());
			labTests.setLowerValueOfLymphocyte(payload.getLowerValueOfLymphocyte());
			labTests.setCountOfPlatelet(payload.getCountOfPlatelet());
			labTests.setUpperCountOfPlatelet(payload.getUpperCountOfPlatelet());
			labTests.setLowerCountOfPlatelet(payload.getLowerCountOfPlatelet());
			labTests.setValueOfESR(payload.getValueOfESR());
			labTests.setUpperValueOfESR(payload.getUpperValueOfESR());
			labTests.setLowerValueOfESR(payload.getLowerValueOfESR());
			labTests.setValueOfFBS(payload.getValueOfFBS());
			labTests.setUpperValueOfFBS(payload.getUpperValueOfFBS());
			labTests.setLowerValueOfFBS(payload.getLowerValueOfFBS());
			labTests.setValueOfHbA1C(payload.getValueOfHbA1C());
			labTests.setUpperValueOfHbA1C(payload.getUpperValueOfHbA1C());
			labTests.setLowerValueOfHbA1C(payload.getLowerValueOfHbA1C());
			labTests.setValueOfSerumCreatinineRFT(payload.getValueOfSerumCreatinineRFT());
			labTests.setUpperValueOfSerumCreatinineRFT(payload.getUpperValueOfSerumCreatinineRFT());
			labTests.setLowerValueOfSerumCreatinineRFT(payload.getLowerValueOfSerumCreatinineRFT());
			labTests.setAmountOfUricAcid(payload.getAmountOfUricAcid());
			labTests.setUpperAmountOfUricAcid(payload.getUpperAmountOfUricAcid());
			labTests.setLowerAmountOfUricAcid(payload.getLowerAmountOfUricAcid());
			labTests.setValueOfSGOTAST(payload.getValueOfSGOTAST());
			labTests.setUpperValueOfSGOTAST(payload.getUpperValueOfSGOTAST());
			labTests.setLowerValueOfSGOTAST(payload.getLowerValueOfSGOTAST());
			labTests.setValueOfSGPTALT(payload.getValueOfSGPTALT());
			labTests.setUpperValueOfSGPTALT(payload.getUpperValueOfSGPTALT());
			labTests.setLowerValueOfSGPTALT(payload.getLowerValueOfSGPTALT());
			labTests.setRatioBetweenSGOAndSGPT(payload.getRatioBetweenSGOAndSGPT());
			labTests.setValueOfBUN(payload.getValueOfBUN());
			labTests.setUpperValueOfBUN(payload.getUpperValueOfBUN());
			labTests.setLowerValueOfBUN(payload.getLowerValueOfBUN());
			labTests.setValueOfNA(payload.getValueOfNA());
			labTests.setUpperValueOfNA(payload.getUpperValueOfNA());
			labTests.setLowerValueOfNA(payload.getLowerValueOfNA());
			labTests.setValueOfK(payload.getValueOfK());
			labTests.setUpperValueOfK(payload.getUpperValueOfK());
			labTests.setLowerValueOfK(payload.getLowerValueOfK());
			labTests.setValueOfCA(payload.getValueOfCA());
			labTests.setUpperValueOfCA(payload.getUpperValueOfCA());
			labTests.setLowerValueOfCA(payload.getLowerValueOfCA());
			labTests.setValueOfPO4(payload.getValueOfPO4());
			labTests.setUpperValueOfPO4(payload.getUpperValueOfPO4());
			labTests.setLowerValueOfPO4(payload.getLowerValueOfPO4());
			labTests.setValueOfCI(payload.getValueOfCI());
			labTests.setUpperValueOfCI(payload.getUpperValueOfCI());
			labTests.setLowerValueOfCI(payload.getLowerValueOfCI());
			labTests.setValueOfHCO3(payload.getValueOfHCO3());
			labTests.setUpperValueOfHCO3(payload.getUpperValueOfHCO3());
			labTests.setLowerValueOfHCO3(payload.getLowerValueOfHCO3());
			labTests.setValueOfGGT(payload.getValueOfGGT());
			labTests.setUpperValueOfGGT(payload.getUpperValueOfGGT());
			labTests.setLowerValueOfGGT(payload.getLowerValueOfGGT());
			labTests.setValueOfALP(payload.getValueOfALP());
			labTests.setUpperValueOfALP(payload.getUpperValueOfALP());
			labTests.setLowerValueOfALP(payload.getLowerValueOfALP());
			labTests.setValueOfTotalBilirubin(payload.getValueOfTotalBilirubin());
			labTests.setUpperValueOfTotalBilirubin(payload.getUpperValueOfTotalBilirubin());
			labTests.setLowerValueOfTotalBilirubin(payload.getLowerValueOfTotalBilirubin());
			labTests.setValueOfSerumAlbumin(payload.getValueOfSerumAlbumin());
			labTests.setUpperValueOfSerumAlbumin(payload.getUpperValueOfSerumAlbumin());
			labTests.setLowerValueOfSerumAlbumin(payload.getLowerValueOfSerumAlbumin());
			labTests.setValueOfUrineMicroAlbumin(payload.getValueOfUrineMicroAlbumin());
			labTests.setUpperValueOfUrineMicroAlbumin(payload.getUpperValueOfUrineMicroAlbumin());
			labTests.setLowerValueOfUrineMicroAlbumin(payload.getLowerValueOfUrineMicroAlbumin());
			labTests.setValueOfTotalProtein(payload.getValueOfTotalProtein());
			labTests.setUpperValueOfTotalProtein(payload.getUpperValueOfTotalProtein());
			labTests.setLowerValueOfTotalProtein(payload.getLowerValueOfTotalProtein());
			labTests.setValueOfPSA(payload.getValueOfPSA());
			labTests.setUpperValueOfPSA(payload.getUpperValueOfPSA());
			labTests.setLowerValueOfPSA(payload.getLowerValueOfPSA());
			labTests.setValueOfTC(payload.getValueOfTC());
			labTests.setUpperValueOfTC(payload.getUpperValueOfTC());
			labTests.setLowerValueOfTC(payload.getLowerValueOfTC());
			labTests.setValueOfLDL(payload.getValueOfLDL());
			labTests.setUpperValueOfLDL(payload.getUpperValueOfLDL());
			labTests.setLowerValueOfLDL(payload.getLowerValueOfLDL());
			labTests.setHeartRate(payload.getHeartRate());
			labTests.setValueOfHDL(payload.getValueOfHDL());
			labTests.setValueOfHB(payload.getValueOfHB());
			labTests.setPercentageOfLVEF(payload.getPercentageOfLVEF());

		}

		return null;

	}

}
