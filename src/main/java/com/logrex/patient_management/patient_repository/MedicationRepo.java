package com.logrex.patient_management.patient_repository;

import com.logrex.patient_management.patient_entity.CurrentMedications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepo extends JpaRepository<CurrentMedications,Long> {
    List<CurrentMedications> findMedicationsByPatientId(Long patientId);

}
