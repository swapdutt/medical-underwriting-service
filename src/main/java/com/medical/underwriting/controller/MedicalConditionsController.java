package com.medical.underwriting.controller;

import com.medical.underwriting.model.dto.medical.DiseaseQuestionnaireDto;
import com.medical.underwriting.model.dto.medical.LabTestsDto;
import com.medical.underwriting.model.dto.medical.PersonalMedicalConditionsDto;
import com.medical.underwriting.service.MedicalConditionsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/medical-underwriting/medical")
public class MedicalConditionsController {

	private final MedicalConditionsService medicalConditionsService;

	@GetMapping(value = "/findDiseaseQuestionnaireById/{diseaseQuestionnaireId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get the record of disease questionnaire by disease questionnaire id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : disease questionnaire record successfully found"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : disease questionnaire record not found successfully") })
	public ResponseEntity<DiseaseQuestionnaireDto> findDiseaseQuestionnaireById(
			@RequestParam(value = "diseaseQuestionnaireId", required = false) @PathVariable("diseaseQuestionnaireId") @Nullable final Integer diseaseQuestionnaireId) {
		return ResponseEntity.ok(medicalConditionsService.findDiseaseQuestionnaireById(diseaseQuestionnaireId));
	}

	@GetMapping(value = "/findLabTestsById/{labTestsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get the record of lab tests by lab tests id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : lab tests record successfully found"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : lab tests record not found successfully") })
	public ResponseEntity<LabTestsDto> findLabTestsById(
			@RequestParam(value = "labTestsId", required = false) @PathVariable("labTestsId") @Nullable final Integer labTestsId) {
		return ResponseEntity.ok(medicalConditionsService.findLabTestsById(labTestsId));
	}

	@GetMapping(value = "/findPersonalMedicalConditionsById/{personalMedicalConditionsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get the record of personal medical conditions by personal medical conditions id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : personal medical conditions record successfully found"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : personal medical conditions record not found successfully") })
	public ResponseEntity<PersonalMedicalConditionsDto> findPersonalMedicalConditionsById(
			@RequestParam(value = "personalMedicalConditionsId", required = false) @PathVariable("personalMedicalConditionsId") @Nullable final Integer personalMedicalConditionsId) {
		return ResponseEntity
				.ok(medicalConditionsService.findPersonalMedicalConditionsById(personalMedicalConditionsId));
	}

	@PostMapping(value = "/createDiseaseQuestionnaire", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create the record of disease questionnaire")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "CREATED : disease questionnaire record successfully created"),
			@ApiResponse(responseCode = "409", description = "CONFLICT : disease questionnaire record not created successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : disease questionnaire record not created successfully") })
	public ResponseEntity<DiseaseQuestionnaireDto> createDiseaseQuestionnaire(
			@RequestBody @Valid @NonNull final DiseaseQuestionnaireDto diseaseQuestionnaireDto) {
		return new ResponseEntity<>(medicalConditionsService.createDiseaseQuestionnaire(diseaseQuestionnaireDto),
				HttpStatus.CREATED);
	}

	@PostMapping(value = "/createLabTests", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create the record of lab tests")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "CREATED : lab tests record successfully created"),
			@ApiResponse(responseCode = "409", description = "CONFLICT : lab tests record not created successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : lab tests record not created successfully") })
	public ResponseEntity<LabTestsDto> createLabTests(@RequestBody @Valid @NonNull final LabTestsDto labTestsDto) {
		return new ResponseEntity<>(medicalConditionsService.createLabTests(labTestsDto), HttpStatus.CREATED);
	}

	@PostMapping(value = "/createPersonalMedicalConditions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create the record of personal medical conditions")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "CREATED : personal medical conditions record successfully created"),
			@ApiResponse(responseCode = "409", description = "CONFLICT : personal medical conditions record not created successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : personal medical conditions record not created successfully") })
	public ResponseEntity<PersonalMedicalConditionsDto> createPersonalMedicalConditions(
			@RequestBody @Valid @NonNull final PersonalMedicalConditionsDto personalMedicalConditionsDto) {
		return new ResponseEntity<>(
				medicalConditionsService.createPersonalMedicalConditions(personalMedicalConditionsDto),
				HttpStatus.CREATED);
	}

	@PutMapping(value = "/updateDiseaseQuestionnaire", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Update the record of disease questionnaire")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : disease questionnaire record updated successfully"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : disease questionnaire record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : disease questionnaire record not updated successfully") })
	public ResponseEntity<DiseaseQuestionnaireDto> updateDiseaseQuestionnaire(
			@RequestBody @Valid @NonNull final DiseaseQuestionnaireDto diseaseQuestionnaireDto) {
		return ResponseEntity.ok(medicalConditionsService.updateDiseaseQuestionnaire(diseaseQuestionnaireDto));
	}

	@PutMapping(value = "/updateLabTests", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Update the record of lab tests")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : lab tests record updated successfully"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : lab tests record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : lab tests record not updated successfully") })
	public ResponseEntity<LabTestsDto> updateLabTests(@RequestBody @Valid @NonNull final LabTestsDto labTestsDto) {
		return ResponseEntity.ok(medicalConditionsService.updateLabTests(labTestsDto));
	}

	@PutMapping(value = "/updatePersonalMedicalConditions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Update the record of disease questionnaire")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : personal medical conditions record updated successfully"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : personal medical conditions record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : personal medical conditions record not updated successfully") })
	public ResponseEntity<PersonalMedicalConditionsDto> updatePersonalMedicalConditions(
			@RequestBody @Valid @NonNull final PersonalMedicalConditionsDto personalMedicalConditionsDto) {
		return ResponseEntity
				.ok(medicalConditionsService.updatePersonalMedicalConditions(personalMedicalConditionsDto));
	}

	@DeleteMapping(value = "/deleteDiseaseQuestionnaireById/{diseaseQuestionnaireId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete the record of disease questionnaire by disease questionnaire id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : disease questionnaire record successfully deleted"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : disease questionnaire record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : disease questionnaire record not deleted successfully") })
	public ResponseEntity<?> deleteDiseaseQuestionnaireById(
			@RequestParam(value = "diseaseQuestionnaireId", required = false) @PathVariable("diseaseQuestionnaireId") @Nullable final Integer diseaseQuestionnaireId) {
		medicalConditionsService.deleteDiseaseQuestionnaireById(diseaseQuestionnaireId);
		return ResponseEntity.ok(Boolean.TRUE);
	}

	@DeleteMapping(value = "/deleteLabTestsById/{labTestsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete the record of lab tests by lab tests id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : lab tests record successfully deleted"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : lab tests record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : lab tests record not deleted successfully") })
	public ResponseEntity<?> deleteLabTestsById(
			@RequestParam(value = "labTestsId", required = false) @PathVariable("labTestsId") @Nullable final Integer labTestsId) {
		medicalConditionsService.deleteLabTestsById(labTestsId);
		return ResponseEntity.ok(Boolean.TRUE);
	}

	@DeleteMapping(value = "/deletePersonalMedicalConditionsById/{personalMedicalConditionsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete the record of personal medical conditions by personal medical conditions id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : personal medical conditions record successfully deleted"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : personal medical conditions record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : personal medical conditions record not deleted successfully") })
	public ResponseEntity<?> deletePersonalMedicalConditionsById(
			@RequestParam(value = "personalMedicalConditionsId", required = false) @PathVariable("personalMedicalConditionsId") @Nullable final Integer personalMedicalConditionsId) {
		medicalConditionsService.deletePersonalMedicalConditionsById(personalMedicalConditionsId);
		return ResponseEntity.ok(Boolean.TRUE);
	}

}
