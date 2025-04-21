package com.logrex.patient_management.patient_repository;

import com.logrex.patient_management.patient_entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosesRepo extends JpaRepository <Diagnosis,Long> {
    List<Diagnosis> findByPatientId(Long patientId);
}
