package com.logrex.patient_management.patient_repository;

import com.logrex.patient_management.patient_entity.VaccinationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationRepo  extends JpaRepository<VaccinationRecord,Long> {


    List<VaccinationRecord> findAllByPatientId(Long id);
}
