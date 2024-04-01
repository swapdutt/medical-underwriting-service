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

import com.medical.underwriting.payloads.request.create.CreatePaymentDetailsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateProposalDetailsRequestPayload;
import com.medical.underwriting.payloads.request.create.CreateProposerDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdatePaymentDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateProposalDetailsRequestPayload;
import com.medical.underwriting.payloads.request.update.UpdateProposerDetailsRequestPayload;
import com.medical.underwriting.payloads.response.PaymentDetailsResponse;
import com.medical.underwriting.payloads.response.ProposalDetailsResponse;
import com.medical.underwriting.payloads.response.ProposerDetailsResponse;
import com.medical.underwriting.service.ProposalDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/medical-underwriting/proposal")
public class ProposalController {

    private final ProposalDetailsService proposalDetailsService;

    /**
     * API endpoints for payment details
     */

    @GetMapping(value = "/findPaymentDetailsById/{paymentDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get the record of payment details by payment details id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : payment details record successfully found"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : payment details record not found successfully")})
    public ResponseEntity<PaymentDetailsResponse> findPaymentDetailsById(@PathVariable("paymentDetailsId") @Nullable final String paymentDetailsId) {
        return ResponseEntity.ok(proposalDetailsService.findPaymentDetailsById(paymentDetailsId));
    }

    @PostMapping(value = "/createPaymentDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create the record of payment details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED : payment details record successfully created"),
            @ApiResponse(responseCode = "409", description = "CONFLICT : payment details record not created successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : payment details record not created successfully")})
    public ResponseEntity<PaymentDetailsResponse> createPaymentDetails(@RequestBody @Valid @NonNull final CreatePaymentDetailsRequestPayload payload) {
        return new ResponseEntity<>(proposalDetailsService.createPaymentDetails(payload), HttpStatus.CREATED);
    }

    @PutMapping(value = "/updatePaymentDetails/{paymentDetailsId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update the record of payment details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : payment details record updated successfully"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : payment details record not found successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : payment details record not updated successfully")})
    public ResponseEntity<PaymentDetailsResponse> updatePaymentDetails(@PathVariable("paymentDetailsId") @Nullable final String paymentDetailsId,
                                                                       @RequestBody @Valid @NonNull final UpdatePaymentDetailsRequestPayload payload) {
        return ResponseEntity.ok(proposalDetailsService.updatePaymentDetails(paymentDetailsId, payload));
    }

    @DeleteMapping(value = "/deletePaymentDetailsById/{paymentDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete the record of payment details by payment details id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : payment details record successfully found"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : payment details record not found successfully")})
    public ResponseEntity<String> deletePaymentDetailsById(@PathVariable("paymentDetailsId") @Nullable final String paymentDetailsId) {
        proposalDetailsService.deletePaymentDetailsById(paymentDetailsId);
        return new ResponseEntity<>(UnderwritingConstants.SUCCESSFUL_DELETE_ENTITY + paymentDetailsId, HttpStatus.OK);
    }

    /**
     * API endpoints for proposer details
     */

    @GetMapping(value = "/findProposerDetailsById/{proposerDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get the record of proposal details by proposer details id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : proposer details record successfully found"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : proposer details record not found successfully")})
    public ResponseEntity<ProposerDetailsResponse> findProposerDetailsById(@PathVariable("proposerDetailsId") @Nullable final String proposerDetailsId) {
        return ResponseEntity.ok(proposalDetailsService.findProposerDetailsById(proposerDetailsId));
    }

    @PostMapping(value = "/createProposerDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create the record of proposer details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED : proposer details record successfully created"),
            @ApiResponse(responseCode = "409", description = "CONFLICT : proposer details record not created successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : proposer details record not created successfully")})
    public ResponseEntity<ProposerDetailsResponse> createProposerDetails(@RequestBody @Valid @NonNull final CreateProposerDetailsRequestPayload payload) {
        return new ResponseEntity<>(proposalDetailsService.createProposerDetails(payload), HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateProposerDetails/{proposerDetailsId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update the record of proposer details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : proposer details record updated successfully"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : proposer details record not found successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : proposer details record not updated successfully")})
    public ResponseEntity<ProposerDetailsResponse> updateProposerDetails(@PathVariable("proposerDetailsId") @Nullable final String proposerDetailsId,
                                                                         @RequestBody @Valid @NonNull final UpdateProposerDetailsRequestPayload payload) {
        return ResponseEntity.ok(proposalDetailsService.updateProposerDetails(proposerDetailsId, payload));
    }

    @DeleteMapping(value = "/deleteProposerDetailsById/{proposerDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete the record of proposer details by proposer details id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : proposer details record successfully found"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : proposer details record not found successfully")})
    public ResponseEntity<String> deleteProposerDetailsById(@PathVariable("proposerDetailsId") @Nullable final String proposerDetailsId) {
        proposalDetailsService.deleteProposerDetailsById(proposerDetailsId);
        return new ResponseEntity<>(UnderwritingConstants.SUCCESSFUL_DELETE_ENTITY + proposerDetailsId, HttpStatus.OK);
    }

    /**
     * API endpoints for proposal details
     */

    @GetMapping(value = "/findProposalDetailsById/{proposalDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get the record of proposal details by proposal details id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : proposal details record successfully found"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : proposal details record not found successfully")})
    public ResponseEntity<ProposalDetailsResponse> findProposalDetailsById(@PathVariable("proposalDetailsId") @Nullable final String proposalDetailsId) {
        return ResponseEntity.ok(proposalDetailsService.findProposalDetailsById(proposalDetailsId));
    }

    @PostMapping(value = "/createProposalDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create the record of proposal details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED : proposal details record successfully created"),
            @ApiResponse(responseCode = "409", description = "CONFLICT : proposal details record not created successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : proposal details record not created successfully")})
    public ResponseEntity<ProposalDetailsResponse> createProposalDetails(@RequestBody @Valid @NonNull final CreateProposalDetailsRequestPayload payload) {
        return new ResponseEntity<>(proposalDetailsService.createProposalDetails(payload), HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateProposalDetails/{proposalDetailsId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update the record of proposal details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : proposal details record updated successfully"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : proposal details record not found successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : proposal details record not updated successfully")})
    public ResponseEntity<ProposalDetailsResponse> updateProposalDetails(@PathVariable("proposalDetailsId") @Nullable final String proposalDetailsId,
                                                                         @RequestBody @Valid @NonNull final UpdateProposalDetailsRequestPayload payload) {
        return ResponseEntity.ok(proposalDetailsService.updateProposalDetails(proposalDetailsId, payload));
    }

    @DeleteMapping(value = "/deleteProposalDetailsById/{proposalDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete the record of proposal details by proposal details id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : proposal details record successfully found"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : proposal details record not found successfully")})
    public ResponseEntity<String> deleteProposalDetailsById(@PathVariable("proposalDetailsId") @Nullable final String proposalDetailsId) {
        proposalDetailsService.deleteProposalDetailsById(proposalDetailsId);
        return new ResponseEntity<>(UnderwritingConstants.SUCCESSFUL_DELETE_ENTITY + proposalDetailsId, HttpStatus.OK);
    }

}
