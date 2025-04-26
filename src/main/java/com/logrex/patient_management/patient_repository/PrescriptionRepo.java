package com.logrex.patient_management.patient_repository;

import com.logrex.patient_management.patient_entity.Prescription;
import com.logrex.patient_management.patient_enums.PrescriptionStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepo extends CrudRepository<Prescription, Long> {
    List<Prescription> findByPatientIdAndStatus(Long patientId, PrescriptionStatus status);

}
