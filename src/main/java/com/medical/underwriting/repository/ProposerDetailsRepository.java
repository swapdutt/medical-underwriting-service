package com.medical.underwriting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.underwriting.model.proposal.ProposerDetails;

import java.util.Optional;

@Repository
public interface ProposerDetailsRepository extends JpaRepository<ProposerDetails, String> {

	Optional<ProposerDetails> findProposerDetailsByProposerDetailsId(String proposerDetailsId);

}
