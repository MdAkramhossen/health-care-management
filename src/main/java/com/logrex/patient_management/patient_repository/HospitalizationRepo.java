package com.logrex.patient_management.patient_repository;
import com.logrex.patient_management.patient_entity.Hospitalizations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalizationRepo extends JpaRepository<Hospitalizations,Long> {

    List<Hospitalizations> findByPatientId(Long patientId);
}
