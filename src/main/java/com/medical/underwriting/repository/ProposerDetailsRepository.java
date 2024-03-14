package com.medical.underwriting.repository;

import com.medical.underwriting.model.entity.proposal.ProposerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProposerDetailsRepository extends JpaRepository<ProposerDetails, Integer> {

	Optional<ProposerDetails> findProposerDetailsByProposerDetailsId(Integer proposerDetailsId);

}
