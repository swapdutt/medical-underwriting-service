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
import com.medical.underwriting.payloads.request.update.UpdateLifestyleDetailsRequestPayload;
import com.medical.underwriting.payloads.response.LifestyleDetailsResponse;
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
	@Operation(summary = "Delete the record of disease questionnaire by disease questionnaire id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : disease questionnaire record successfully deleted"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : disease questionnaire record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : disease questionnaire record not deleted successfully") })
	public ResponseEntity<?> deleteLifestyleDetailsById(
			@RequestParam(value = "lifestyleDetailsId", required = false) @PathVariable("lifestyleDetailsId") @Nullable final String lifestyleDetailsId) {
		memberDetailsService.deleteLifestyleDetailsById(lifestyleDetailsId);
		return ResponseEntity.ok(Boolean.TRUE);
	}

	/**
	 * API endpoints for medical conditions
	 */

	/**
	 * API endpoints for member details
	 */

}
