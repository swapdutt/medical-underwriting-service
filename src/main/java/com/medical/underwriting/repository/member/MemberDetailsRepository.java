package com.medical.underwriting.repository.member;

import com.medical.underwriting.model.entity.member.MemberDetails;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberDetailsRepository extends JpaRepository<MemberDetails, Integer> {

	// @Query(value = "select m from MemberDetails where m.memberDetailsId")
	Optional<MemberDetails> findMemberDetailsByMemberId(Integer memberDetailsId);

}
