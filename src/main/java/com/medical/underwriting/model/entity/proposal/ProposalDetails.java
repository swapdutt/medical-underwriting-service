package com.medical.underwriting.model.entity.proposal;

import com.medical.underwriting.model.entity.member.MemberDetails;
import jakarta.persistence.*;
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
@Entity
@Table(name = "PROPOSAL")
public class ProposalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer proposalDetailsId;
	String sourcingApplication;
	@Builder.Default
	String applicationNumber = UUID.randomUUID().toString();
	@Builder.Default
	String policyNumber = UUID.randomUUID().toString();
	String productName;
	String productCode;
	String planOption;
	String businessType;
	LocalDate proposalCreationDate;
	String businessMode;
	@OneToOne
	ProposerDetails proposerDetails;
	@OneToOne
	PaymentDetails paymentDetails;
	// @JdbcTypeCode(SqlTypes.JSON)
	@OneToMany
	List<MemberDetails> memberDetails;

}
