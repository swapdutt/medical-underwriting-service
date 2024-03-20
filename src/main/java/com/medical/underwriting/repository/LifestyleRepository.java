package com.medical.underwriting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.underwriting.model.member.LifestyleDetails;

import java.util.Optional;

@Repository
public interface LifestyleRepository extends JpaRepository<LifestyleDetails, String> {

	Optional<LifestyleDetails> findLifestyleDetailsByLifestyleDetailsId(String lifestyleDetailsId);

}
