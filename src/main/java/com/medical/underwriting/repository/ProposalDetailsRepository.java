package com.medical.underwriting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.underwriting.model.proposal.ProposalDetails;

import java.util.Optional;

@Repository
public interface ProposalDetailsRepository extends JpaRepository<ProposalDetails, String> {

	Optional<ProposalDetails> findProposalDetailsByProposalDetailsId(String proposalDetailsId);

}
