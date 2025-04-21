package com.logrex.patient_management.patient_repository;

import com.logrex.patient_management.patient_entity.ChronicConditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChoronicRepo extends JpaRepository<ChronicConditions,Long> {
    List<ChronicConditions> findByPatientId(Long patientId);

}
