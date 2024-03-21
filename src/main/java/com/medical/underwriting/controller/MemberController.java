package com.medical.underwriting.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.underwriting.payloads.request.create.CreateLifestyleDetailsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateMemberDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateLifestyleDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateMedicalConditionsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateMemberDetailsRequestPayload;
import com.medical.underwriting.payloads.response.LifestyleDetailsResponse;
import com.medical.underwriting.payloads.response.MedicalConditionsResponse;
import com.medical.underwriting.payloads.response.MemberDetailsResponse;
import com.medical.underwriting.service.MemberDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/medical-underwriting/member")
public class MemberController {

	private final MemberDetailsService memberDetailsService;

	/**
	 * API endpoints for lifestyle details
	 */

	@GetMapping(value = "/findLifestyleDetailsById/{lifestyleDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get the record of lifestyle details by lifestyle details id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : lifestyle details record successfully found"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : lifestyle details record not found successfully") })
	public ResponseEntity<LifestyleDetailsResponse> findLifestyleDetailsById(
			@RequestParam(value = "lifestyleDetailsId", required = false) @PathVariable("lifestyleDetailsId") @Nullable final String lifestyleDetailsId) {
		return ResponseEntity.ok(memberDetailsService.findLifestyleDetailsById(lifestyleDetailsId));
	}

	@PostMapping(value = "/createLifestyleDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create the record of lifestyle details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "CREATED : lifestyle details record successfully created"),
			@ApiResponse(responseCode = "409", description = "CONFLICT : lifestyle details record not created successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : lifestyle details record not created successfully") })
	public ResponseEntity<LifestyleDetailsResponse> createLifestyleDetails(
			@RequestBody @Valid @NonNull final CreateLifestyleDetailsRequestPayload payload) {
		return new ResponseEntity<>(memberDetailsService.createLifestyleDetails(payload), HttpStatus.CREATED);
	}

	@PutMapping(value = "/updateLifestyleDetails/{lifestyleDetailsId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Update the record of lifestyle details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : lifestyle details record updated successfully"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : lifestyle details record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : lifestyle details record not updated successfully") })
	public ResponseEntity<LifestyleDetailsResponse> updateLifestyleDetails(
			@RequestParam(value = "lifestyleDetailsId", required = false) @PathVariable("lifestyleDetailsId") @Nullable final String lifestyleDetailsId,
			@RequestBody @Valid @NonNull final UpdateLifestyleDetailsRequestPayload payload) {
		return ResponseEntity.ok(memberDetailsService.updateLifestyleDetails(lifestyleDetailsId, payload));
	}

	@DeleteMapping(value = "/deleteLifestyleDetailsById/{lifestyleDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete the record of ifestyle details by ifestyle details id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : lifestyle details record successfully deleted"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : lifestyle details record not found successfully") })
	public ResponseEntity<Boolean> deleteLifestyleDetailsById(
			@RequestParam(value = "lifestyleDetailsId", required = false) @PathVariable("lifestyleDetailsId") @Nullable final String lifestyleDetailsId) {
		memberDetailsService.deleteLifestyleDetailsById(lifestyleDetailsId);
		return ResponseEntity.ok(Boolean.TRUE);
	}

	/**
	 * API endpoints for medical conditions
	 */

	@GetMapping(value = "/findMedicalConditionsDetailsById/{medicalConditionsDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get the record of medical conditions details by medical conditions details id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : medical conditions details record successfully found"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : medical conditions details record not found successfully") })
	public ResponseEntity<MedicalConditionsResponse> findMedicalConditionsDetailsById(
			@RequestParam(value = "medicalConditionsDetailsId", required = false) @PathVariable("medicalConditionsDetailsId") @Nullable final String medicalConditionsDetailsId) {
		return ResponseEntity.ok(memberDetailsService.findMedicalConditionsById(medicalConditionsDetailsId));
	}

	@PostMapping(value = "/createMedicalConditionsDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create the record of medical conditions details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "CREATED : medical conditions details record successfully created"),
			@ApiResponse(responseCode = "409", description = "CONFLICT : medical conditions details record not created successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : medical conditions details record not created successfully") })
	public ResponseEntity<MedicalConditionsResponse> createMedicalConditionsDetails(
			@RequestBody @Valid @NonNull final CreateMedicalConditionsRequestPayload payload) {
		return new ResponseEntity<>(memberDetailsService.createMedicalConditions(payload), HttpStatus.CREATED);
	}

	@PutMapping(value = "/updateMedicalConditionsDetails/{medicalConditionsDetailsId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Update the record of medical conditions details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : medical conditions details record updated successfully"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : medical conditions details record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : medical conditions details record not updated successfully") })
	public ResponseEntity<MedicalConditionsResponse> updateMedicalConditionsDetails(
			@RequestParam(value = "medicalConditionsDetailsId", required = false) @PathVariable("medicalConditionsDetailsId") @Nullable final String medicalConditionsDetailsId,
			@RequestBody @Valid @NonNull final UpdateMedicalConditionsRequestPayload payload) {
		return ResponseEntity.ok(memberDetailsService.updateMedicalConditions(medicalConditionsDetailsId, payload));
	}

	@DeleteMapping(value = "/deleteMedicalConditionsById/{medicalConditionsDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete the record of medical conditions details by medical conditions details id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : medical conditions details record successfully deleted"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : medical conditions details record not found successfully") })
	public ResponseEntity<Boolean> deleteMedicalConditionsById(
			@RequestParam(value = "medicalConditionsDetailsId", required = false) @PathVariable("medicalConditionsDetailsId") @Nullable final String medicalConditionsDetailsId) {
		memberDetailsService.deleteMedicalConditionsById(medicalConditionsDetailsId);
		return ResponseEntity.ok(Boolean.TRUE);
	}

	/**
	 * API endpoints for member details
	 */

	@GetMapping(value = "/findMemberDetailsById/{memberDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get the record of member details by member details id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : member details record successfully found"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : member details record not found successfully") })
	public ResponseEntity<MemberDetailsResponse> findMemberDetailsById(
			@RequestParam(value = "memberDetailsId", required = false) @PathVariable("memberDetailsId") @Nullable final String memberDetailsId) {
		return ResponseEntity.ok(memberDetailsService.findMemberDetailsById(memberDetailsId));
	}

	@PostMapping(value = "/createMemberDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create the record of member details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "CREATED : member details record successfully created"),
			@ApiResponse(responseCode = "409", description = "CONFLICT : member details record not created successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : member details record not created successfully") })
	public ResponseEntity<MemberDetailsResponse> createMemberDetails(
			@RequestBody @Valid @NonNull final CreateMemberDetailsRequestPayload payload) {
		return new ResponseEntity<>(memberDetailsService.createMemberDetails(payload), HttpStatus.CREATED);
	}

	@PutMapping(value = "/updateMemberDetails/{memberDetailsId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Update the record of member details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : member details record updated successfully"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : member details record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : member details record not updated successfully") })
	public ResponseEntity<MemberDetailsResponse> updateMemberDetails(
			@RequestParam(value = "memberDetailsId", required = false) @PathVariable("memberDetailsId") @Nullable final String memberDetailsId,
			@RequestBody @Valid @NonNull final UpdateMemberDetailsRequestPayload payload) {
		return ResponseEntity.ok(memberDetailsService.updateMemberDetails(memberDetailsId, payload));
	}

	@DeleteMapping(value = "/deleteMemberDetailsById/{memberDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete the record of member details by member details id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : member details record successfully deleted"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : member details record not found successfully") })
	public ResponseEntity<Boolean> deleteMemberDetailsById(
			@RequestParam(value = "memberDetailsId", required = false) @PathVariable("memberDetailsId") @Nullable final String memberDetailsId) {
		memberDetailsService.deleteMemberDetailsById(memberDetailsId);
		return ResponseEntity.ok(Boolean.TRUE);
	}

}
