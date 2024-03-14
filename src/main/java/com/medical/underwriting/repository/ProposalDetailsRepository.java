package com.medical.underwriting.repository;

import com.medical.underwriting.model.entity.proposal.ProposalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProposalDetailsRepository extends JpaRepository<ProposalDetails, Integer> {

	Optional<ProposalDetails> findProposalDetailsByProposalDetailsId(Integer proposalDetailsId);

}
