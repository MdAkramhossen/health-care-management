package com.logrex.patient_management.patient_repository;

import com.logrex.patient_management.patient_entity.LabResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabResultsRepo extends JpaRepository<LabResult,Long> {
    List<LabResult> findLabResultsByPatientId(Long patientId);
}
