package com.medical.underwriting.controller;

import com.medical.underwriting.model.dto.member.LifestyleDetailsDto;
import com.medical.underwriting.model.dto.member.MedicalConditionsDetailsDto;
import com.medical.underwriting.model.dto.member.MemberDetailsDto;
import com.medical.underwriting.service.MemberDetailsService;
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
@RequestMapping(value = "/api/medical-underwriting/member")
public class MemberController {

	private final MemberDetailsService memberDetailsService;

	@GetMapping(value = "/findMemberDetailsById/{memberDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get the record of member details by member details id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : member details record successfully found"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : member details record not found successfully") })
	public ResponseEntity<MemberDetailsDto> findMemberDetailsById(
			@RequestParam(value = "memberDetailsId", required = false) @PathVariable("memberDetailsId") @Nullable final Integer memberDetailsId) {
		return ResponseEntity.ok(memberDetailsService.findMemberDetailsById(memberDetailsId));
	}

	@GetMapping(value = "/findLifestyleDetailsById/{lifestyleDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get the record of lifestyle details by lifestyle details id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : lifestyle details record successfully found"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : lifestyle details record not found successfully") })
	public ResponseEntity<LifestyleDetailsDto> findLifestyleDetailsById(
			@RequestParam(value = "lifestyleDetailsId", required = false) @PathVariable("lifestyleDetailsId") @Nullable final Integer lifestyleDetailsId) {
		return ResponseEntity.ok(memberDetailsService.findLifestyleDetailsById(lifestyleDetailsId));
	}

	@GetMapping(value = "/findMedicalConditionsDetailsById/{medicalConditionsDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get the record of medical conditions details by medical conditions details id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : medical conditions details record successfully found"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : medical conditions details record not found successfully") })
	public ResponseEntity<MedicalConditionsDetailsDto> findMedicalConditionsDetailsById(
			@RequestParam(value = "medicalConditionsDetailsId", required = false) @PathVariable("medicalConditionsDetailsId") @Nullable final Integer medicalConditionsDetailsId) {
		return ResponseEntity.ok(memberDetailsService.findMedicalConditionsDetailsById(medicalConditionsDetailsId));
	}

	@PostMapping(value = "/createMemberDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create the record of member details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "CREATED : member details record successfully created"),
			@ApiResponse(responseCode = "409", description = "CONFLICT : member details record not created successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : member details record not created successfully") })
	public ResponseEntity<MemberDetailsDto> createMemberDetails(
			@RequestBody @Valid @NonNull final MemberDetailsDto memberDetailsDto) {
		return new ResponseEntity<>(memberDetailsService.createMemberDetails(memberDetailsDto), HttpStatus.CREATED);
	}

	@PostMapping(value = "/createLifestyleDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create the record of lifestyle details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "CREATED : lifestyle details record successfully created"),
			@ApiResponse(responseCode = "409", description = "CONFLICT : lifestyle details record not created successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : lifestyle details record not created successfully") })
	public ResponseEntity<LifestyleDetailsDto> createLifestyleDetails(
			@RequestBody @Valid @NonNull final LifestyleDetailsDto lifestyleDetailsDto) {
		return new ResponseEntity<>(memberDetailsService.createLifestyleDetails(lifestyleDetailsDto),
				HttpStatus.CREATED);
	}

	@PostMapping(value = "/createMedicalConditionsDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create the record of medical conditions details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "CREATED : medical conditions details record successfully created"),
			@ApiResponse(responseCode = "409", description = "CONFLICT : medical conditions details record not created successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : medical conditions details record not created successfully") })
	public ResponseEntity<MedicalConditionsDetailsDto> createMedicalConditionsDetails(
			@RequestBody @Valid @NonNull final MedicalConditionsDetailsDto medicalConditionsDetailsDto) {
		return new ResponseEntity<>(memberDetailsService.createMedicalConditionsDetails(medicalConditionsDetailsDto),
				HttpStatus.CREATED);
	}

	@PutMapping(value = "/updateMemberDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Update the record of member details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : member details record updated successfully"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : member details record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : member details record not updated successfully") })
	public ResponseEntity<MemberDetailsDto> updateMemberDetails(
			@RequestBody @Valid @NonNull final MemberDetailsDto memberDetailsDto) {
		return ResponseEntity.ok(memberDetailsService.updateMemberDetails(memberDetailsDto));
	}

	@PutMapping(value = "/updateLifestyleDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Update the record of lifestyle details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : lifestyle details record updated successfully"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : lifestyle details record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : lifestyle details record not updated successfully") })
	public ResponseEntity<LifestyleDetailsDto> updateLifestyleDetails(
			@RequestBody @Valid @NonNull final LifestyleDetailsDto lifestyleDetailsDto) {
		return ResponseEntity.ok(memberDetailsService.updateLifestyleDetails(lifestyleDetailsDto));
	}

	@PutMapping(value = "/updateMedicalConditionsDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Update the record of medical conditions details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : medical conditions details record updated successfully"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : medical conditions details record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : medical conditions details record not updated successfully") })
	public ResponseEntity<MedicalConditionsDetailsDto> updateMedicalConditionsDetails(
			@RequestBody @Valid @NonNull final MedicalConditionsDetailsDto medicalConditionsDetailsDto) {
		return ResponseEntity.ok(memberDetailsService.updateMedicalConditionsDetails(medicalConditionsDetailsDto));
	}

	@DeleteMapping(value = "/deleteMemberDetailsById/{memberDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete the record of member details by member details id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : member details record successfully deleted"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : member details record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : member details record not deleted successfully") })
	public ResponseEntity<?> deleteMemberDetailsById(
			@RequestParam(value = "memberDetailsId", required = false) @PathVariable("memberDetailsId") @Nullable final Integer memberDetailsId) {
		memberDetailsService.deleteMemberDetailsById(memberDetailsId);
		return ResponseEntity.ok(Boolean.TRUE);
	}

	@DeleteMapping(value = "/deleteLifestyleDetailsById/{lifestyleDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete the record of disease questionnaire by disease questionnaire id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : disease questionnaire record successfully deleted"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : disease questionnaire record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : disease questionnaire record not deleted successfully") })
	public ResponseEntity<?> deleteLifestyleDetailsById(
			@RequestParam(value = "lifestyleDetailsId", required = false) @PathVariable("lifestyleDetailsId") @Nullable final Integer lifestyleDetailsId) {
		memberDetailsService.deleteLifestyleDetailsById(lifestyleDetailsId);
		return ResponseEntity.ok(Boolean.TRUE);
	}

	@DeleteMapping(value = "/deleteMedicalConditionsById/{medicalConditionsDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete the record of disease questionnaire by disease questionnaire id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK : disease questionnaire record successfully deleted"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND : disease questionnaire record not found successfully"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST : disease questionnaire record not deleted successfully") })
	public ResponseEntity<?> deleteMedicalConditionsById(
			@RequestParam(value = "medicalConditionsDetailsId", required = false) @PathVariable("medicalConditionsDetailsId") @Nullable final Integer medicalConditionsDetailsId) {
		memberDetailsService.deleteMedicalConditionsById(medicalConditionsDetailsId);
		return ResponseEntity.ok(Boolean.TRUE);
	}

}
