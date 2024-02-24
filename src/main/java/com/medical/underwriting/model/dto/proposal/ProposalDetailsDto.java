package com.medical.underwriting.model.dto.proposal;

import com.medical.underwriting.model.dto.member.MemberDetailsDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProposalDetailsDto {

    Integer id;
    String proposalDetailsId = UUID.randomUUID().toString();
    String sourcingApplication;
    String applicationNumber = UUID.randomUUID().toString();
    String policyNumber = UUID.randomUUID().toString();
    String productName;
    String productCode;
    String planOption;
    String businessType;
    LocalDate proposalCreationDate;
    String businessMode;
    ProposerDetailsDto proposerDetails;
    PaymentDetailsDto paymentDetails;
    List<MemberDetailsDto> memberDetails;


}
