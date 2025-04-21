package com.logrex.patient_management.patient_repository;

import com.logrex.patient_management.patient_entity.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllergyRepo extends JpaRepository<Allergy, Long> {
    List<Allergy> findAllByPatientId(Long patientId);
}
