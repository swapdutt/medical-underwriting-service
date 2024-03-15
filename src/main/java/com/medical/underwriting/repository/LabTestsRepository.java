package com.medical.underwriting.repository;

import com.medical.underwriting.model.entity.medical.LabTests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LabTestsRepository extends JpaRepository<LabTests, String> {

	Optional<LabTests> findLabTestsByLabTestsId(String labTestsId);

}
