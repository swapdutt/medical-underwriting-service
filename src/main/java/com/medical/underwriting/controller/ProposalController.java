package com.medical.underwriting.controller;

import com.medical.underwriting.model.dto.proposal.PaymentDetailsDto;
import com.medical.underwriting.model.dto.proposal.ProposalDetailsDto;
import com.medical.underwriting.model.dto.proposal.ProposerDetailsDto;
import com.medical.underwriting.service.ProposalDetailsService;
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
@RequestMapping(value = "/api/medical-underwriting/proposal")
public class ProposalController {

    private final ProposalDetailsService proposalDetailsService;

    @GetMapping(value = "/findPaymentDetailsById/{paymentDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get the record of payment details by payment details id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : payment details record successfully found"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : payment details record not found successfully")
    })
    public ResponseEntity<PaymentDetailsDto> findPaymentDetailsById (@RequestParam(value = "paymentDetailsId", required = false)
                                                                     @PathVariable("paymentDetailsId")
                                                                     @Nullable final String paymentDetailsId) {
        return ResponseEntity.ok(proposalDetailsService.findPaymentDetailsById(paymentDetailsId));
    }

    @GetMapping(value = "/findProposerDetailsById/{proposerDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get the record of proposal details by proposer details id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : proposer details record successfully found"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : proposer details record not found successfully")
    })
    public ResponseEntity<ProposerDetailsDto> findProposerDetailsById (@RequestParam(value = "proposerDetailsId", required = false)
                                                                       @PathVariable("proposerDetailsId")
                                                                       @Nullable final String proposerDetailsId) {
        return ResponseEntity.ok(proposalDetailsService.findProposerDetailsById(proposerDetailsId));
    }

    @GetMapping(value = "/findProposalDetailsById/{proposalDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get the record of proposal details by proposal details id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : proposal details record successfully found"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : proposal details record not found successfully")
    })
    public ResponseEntity<ProposalDetailsDto> findProposalDetailsById (@RequestParam(value = "proposalDetailsId", required = false)
                                                                       @PathVariable("proposalDetailsId")
                                                                       @Nullable final String proposalDetailsId) {
        return ResponseEntity.ok(proposalDetailsService.findProposalDetailsById(proposalDetailsId));
    }

    @PostMapping(value = "/createPaymentDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create the record of payment details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED : payment details record successfully created"),
            @ApiResponse(responseCode = "409", description = "CONFLICT : payment details record not created successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : payment details record not created successfully")
    })
    public ResponseEntity<PaymentDetailsDto> createPaymentDetails (@RequestBody @Valid @NonNull final PaymentDetailsDto paymentDetailsDto) {
        return new ResponseEntity<>(proposalDetailsService.createPaymentDetails(paymentDetailsDto), HttpStatus.CREATED);
    }

    @PostMapping(value = "/createProposerDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create the record of proposer details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED : proposer details record successfully created"),
            @ApiResponse(responseCode = "409", description = "CONFLICT : proposer details record not created successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : proposer details record not created successfully")
    })
    public ResponseEntity<ProposerDetailsDto> createProposerDetails (@RequestBody @Valid @NonNull final ProposerDetailsDto proposerDetailsDto) {
        return new ResponseEntity<>(proposalDetailsService.createProposerDetails(proposerDetailsDto), HttpStatus.CREATED);
    }

    @PostMapping(value = "/createProposalDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create the record of proposal details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED : proposal details record successfully created"),
            @ApiResponse(responseCode = "409", description = "CONFLICT : proposal details record not created successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : proposal details record not created successfully")
    })
    public ResponseEntity<ProposalDetailsDto> createProposalDetails (@RequestBody @Valid @NonNull final ProposalDetailsDto proposalDetailsDto) {
        return new ResponseEntity<>(proposalDetailsService.createProposalDetails(proposalDetailsDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/updatePaymentDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update the record of payment details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : payment details record updated successfully"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : payment details record not found successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : payment details record not updated successfully")
    })
    public ResponseEntity<PaymentDetailsDto> updatePaymentDetails (@RequestBody @Valid @NonNull final PaymentDetailsDto paymentDetailsDto) {
        return ResponseEntity.ok(proposalDetailsService.updatePaymentDetails(paymentDetailsDto));
    }

    @PutMapping(value = "/updateProposerDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update the record of proposer details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : proposer details record updated successfully"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : proposer details record not found successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : proposer details record not updated successfully")
    })
    public ResponseEntity<ProposerDetailsDto> updateProposerDetails (@RequestBody @Valid @NonNull final ProposerDetailsDto proposerDetailsDto) {
        return ResponseEntity.ok(proposalDetailsService.updateProposerDetails(proposerDetailsDto));
    }

    @PutMapping(value = "/updateProposalDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update the record of disease questionnaire")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : disease questionnaire record updated successfully"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : disease questionnaire record not found successfully"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST : disease questionnaire record not updated successfully")
    })
    public ResponseEntity<ProposalDetailsDto> updateProposalDetails (@RequestBody @Valid @NonNull final ProposalDetailsDto proposalDetailsDto) {
        return ResponseEntity.ok(proposalDetailsService.updateProposalDetails(proposalDetailsDto));
    }

    @GetMapping(value = "/deletePaymentDetailsById/{paymentDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get the record of payment details by payment details id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : payment details record successfully found"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : payment details record not found successfully"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : payment details record not found successfully")
    })
    public ResponseEntity<?> deletePaymentDetailsById (@RequestParam(value = "paymentDetailsId", required = false)
                                                       @PathVariable("paymentDetailsId")
                                                       @Nullable final String paymentDetailsId) {
        proposalDetailsService.deletePaymentDetailsById(paymentDetailsId);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping(value = "/deleteProposerDetailsById/{proposerDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get the record of proposal details by proposer details id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : proposer details record successfully found"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : proposer details record not found successfully"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : proposer details record not found successfully")
    })
    public ResponseEntity<?> deleteProposerDetailsById (@RequestParam(value = "proposerDetailsId", required = false)
                                                        @PathVariable("proposerDetailsId")
                                                        @Nullable final String proposerDetailsId) {
        proposalDetailsService.deleteProposerDetailsById(proposerDetailsId);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping(value = "/deleteProposalDetailsById/{proposalDetailsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get the record of proposal details by proposal details id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK : proposal details record successfully found"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : proposal details record not found successfully"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND : proposal details record not found successfully")
    })
    public ResponseEntity<?> deleteProposalDetailsById (@RequestParam(value = "proposalDetailsId", required = false)
                                                        @PathVariable("proposalDetailsId")
                                                        @Nullable final String proposalDetailsId) {
        proposalDetailsService.deleteProposalDetailsById(proposalDetailsId);
        return ResponseEntity.ok(Boolean.TRUE);
    }

}
