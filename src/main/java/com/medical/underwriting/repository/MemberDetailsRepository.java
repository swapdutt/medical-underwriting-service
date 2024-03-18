package com.medical.underwriting.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.underwriting.model.entity.member.MemberDetails;

@Repository
public interface MemberDetailsRepository extends JpaRepository<MemberDetails, String> {

	Optional<MemberDetails> findMemberDetailsByMemberId(String memberDetailsId);

}
