package com.medical.underwriting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.underwriting.model.medical.LabTests;

import java.util.Optional;

@Repository
public interface LabTestsRepository extends JpaRepository<LabTests, String> {

	Optional<LabTests> findLabTestsByLabTestsId(String labTestsId);

}
