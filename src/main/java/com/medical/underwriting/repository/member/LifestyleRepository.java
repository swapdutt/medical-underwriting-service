package com.medical.underwriting.repository.member;

import com.medical.underwriting.model.entity.member.LifestyleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LifestyleRepository extends JpaRepository<LifestyleDetails, Integer> {

    Optional<LifestyleDetails> findLifestyleDetailsByLifestyleDetailsId (String lifestyleDetailsId);

}
