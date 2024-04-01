package com.medical.underwriting.controller;

import com.medical.underwriting.utility.UnderwritingConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.underwriting.payloads.request.create.CreateDiseaseQuestionnaireRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateLabTestsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreatePersonalMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateDiseaseQuestionnaireRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateLabTestsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdatePersonalMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.response.DiseaseQuestionnaireResponse;
import com.medical.underwriting.payloads.response.LabTestsResponse;
import com.medical.underwriting.payloads.response.PersonalMedicalConditionsResponse;
import com.medical.underwriting.service.MedicalConditionsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/medical-underwriting/medical")
public class MedicalConditionsController {

    private final MedicalConditionsService medicalConditionsService;

    /**
     * API endpoints for Disease Questionnaire
     */

    @GetMapping(value = "/findDiseaseQuestionnaireById/{diseaseQuestionnaireId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get the record of disease questionnaire by disease questionnaire id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : disease questionnaire record successfully found"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : disease questionnaire record not found successfully")})
    public ResponseEntity<DiseaseQuestionnaireResponse> findDiseaseQuestionnaireById(@PathVariable("diseaseQuestionnaireId") @Nullable final String diseaseQuestionnaireId) {
        return ResponseEntity.ok(medicalConditionsService.findDiseaseQuestionnaireById(diseaseQuestionnaireId));
    }

    @PostMapping(value = "/createDiseaseQuestionnaire", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create the record of disease questionnaire")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED : disease questionnaire record successfully created"),
            @ApiResponse(responseCode = "409", description = "CONFLICT : disease questionnaire record not created successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : disease questionnaire record not created successfully")})
    public ResponseEntity<DiseaseQuestionnaireResponse> createDiseaseQuestionnaire(@RequestBody @Valid @NonNull final CreateDiseaseQuestionnaireRequestPayload payload) {
        return new ResponseEntity<>(medicalConditionsService.createDiseaseQuestionnaire(payload), HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateDiseaseQuestionnaire/{diseaseQuestionnaireId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update the record of disease questionnaire")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : disease questionnaire record updated successfully"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : disease questionnaire record not found successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : disease questionnaire record not updated successfully")})
    public ResponseEntity<DiseaseQuestionnaireResponse> updateDiseaseQuestionnaire(@PathVariable("diseaseQuestionnaireId") @Nullable final String diseaseQuestionnaireId,
                                                                                   @RequestBody @Valid @NonNull final UpdateDiseaseQuestionnaireRequestPayload payload) {
        return ResponseEntity.ok(medicalConditionsService.updateDiseaseQuestionnaire(diseaseQuestionnaireId, payload));
    }

    @DeleteMapping(value = "/deleteDiseaseQuestionnaireById/{diseaseQuestionnaireId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete the record of disease questionnaire by disease questionnaire id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : disease questionnaire record successfully deleted"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : disease questionnaire record not found successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : disease questionnaire record not deleted successfully")})
    public ResponseEntity<String> deleteDiseaseQuestionnaireById(@PathVariable("diseaseQuestionnaireId") @Nullable final String diseaseQuestionnaireId) {
        medicalConditionsService.deleteDiseaseQuestionnaireById(diseaseQuestionnaireId);
        return new ResponseEntity<>(UnderwritingConstants.SUCCESSFUL_DELETE_ENTITY + diseaseQuestionnaireId, HttpStatus.OK);

    }

    /**
     * API endpoints for Lab Tests
     */

    @GetMapping(value = "/findLabTestsById/{labTestsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get the record of lab tests by lab tests id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : lab tests record successfully found"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : lab tests record not found successfully")})
    public ResponseEntity<LabTestsResponse> findLabTestsById(@PathVariable("labTestsId") @Nullable final String labTestsId) {
        return ResponseEntity.ok(medicalConditionsService.findLabTestsById(labTestsId));
    }

    @PostMapping(value = "/createLabTests", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create the record of lab tests")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED : lab tests record successfully created"),
            @ApiResponse(responseCode = "409", description = "CONFLICT : lab tests record not created successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : lab tests record not created successfully")})
    public ResponseEntity<LabTestsResponse> createLabTests(@RequestBody @Valid @NonNull final CreateLabTestsRequestPayload payload) {
        return new ResponseEntity<>(medicalConditionsService.createLabTests(payload), HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateLabTests/{labTestsId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update the record of lab tests")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : lab tests record updated successfully"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : lab tests record not found successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : lab tests record not updated successfully")})
    public ResponseEntity<LabTestsResponse> updateLabTests(@PathVariable("labTestsId") @Nullable final String labTestsId,
                                                           @RequestBody @Valid @NonNull final UpdateLabTestsRequestPayload payload) {
        return ResponseEntity.ok(medicalConditionsService.updateLabTests(labTestsId, payload));
    }

    @DeleteMapping(value = "/deleteLabTestsById/{labTestsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete the record of lab tests by lab tests id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : lab tests record successfully deleted"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : lab tests record not found successfully")})
    public ResponseEntity<String> deleteLabTestsById(@PathVariable("labTestsId") @Nullable final String labTestsId) {
        medicalConditionsService.deleteLabTestsById(labTestsId);
        return new ResponseEntity<>(UnderwritingConstants.SUCCESSFUL_DELETE_ENTITY + labTestsId, HttpStatus.OK);
    }

    /**
     * API endpoints for Personal Medical Conditions
     */

    @GetMapping(value = "/findPersonalMedicalConditionsById/{personalMedicalConditionsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get the record of personal medical conditions by personal medical conditions id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : personal medical conditions record successfully found"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : personal medical conditions record not found successfully")})
    public ResponseEntity<PersonalMedicalConditionsResponse> findPersonalMedicalConditionsById(@PathVariable("personalMedicalConditionsId") @Nullable final String personalMedicalConditionsId) {
        return ResponseEntity
                .ok(medicalConditionsService.findPersonalMedicalConditionsById(personalMedicalConditionsId));
    }

    @PostMapping(value = "/createPersonalMedicalConditions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create the record of personal medical conditions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED : personal medical conditions record successfully created"),
            @ApiResponse(responseCode = "409", description = "CONFLICT : personal medical conditions record not created successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : personal medical conditions record not created successfully")})
    public ResponseEntity<PersonalMedicalConditionsResponse> createPersonalMedicalConditions(@RequestBody @Valid @NonNull final CreatePersonalMedicalConditionsRequestPayload payload) {
        return new ResponseEntity<>(medicalConditionsService.createPersonalMedicalConditions(payload),
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/updatePersonalMedicalConditions/{personalMedicalConditionsId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update the record of personal medical conditions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : personal medical conditions record updated successfully"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : personal medical conditions record not found successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : personal medical conditions record not updated successfully")})
    public ResponseEntity<PersonalMedicalConditionsResponse> updatePersonalMedicalConditions(@PathVariable("personalMedicalConditionsId") @Nullable final String personalMedicalConditionsId,
                                                                                             @RequestBody @Valid @NonNull final UpdatePersonalMedicalConditionsRequestPayload payload) {
        return ResponseEntity
                .ok(medicalConditionsService.updatePersonalMedicalConditions(personalMedicalConditionsId, payload));
    }

    @DeleteMapping(value = "/deletePersonalMedicalConditionsById/{personalMedicalConditionsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete the record of personal medical conditions by personal medical conditions id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : personal medical conditions record successfully deleted"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : personal medical conditions record not found successfully")})
    public ResponseEntity<String> deletePersonalMedicalConditionsById(@PathVariable("personalMedicalConditionsId") @Nullable final String personalMedicalConditionsId) {
        medicalConditionsService.deletePersonalMedicalConditionsById(personalMedicalConditionsId);
        return new ResponseEntity<>(UnderwritingConstants.SUCCESSFUL_DELETE_ENTITY + personalMedicalConditionsId, HttpStatus.OK);
    }

}
