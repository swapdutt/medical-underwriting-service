package com.medical.underwriting.model.proposal;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.medical.underwriting.model.member.MemberDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@ToString
@Entity
@Table(name = "PROPOSAL")
public class ProposalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String proposalDetailsId;
	String sourcingApplication;
	@Builder.Default
	String applicationNumber = RandomStringUtils.randomAlphanumeric(5, 8);
	@Builder.Default
	String policyNumber = RandomStringUtils.randomAlphanumeric(5, 8);
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
	@ToString.Exclude
	List<MemberDetails> memberDetails;

}
