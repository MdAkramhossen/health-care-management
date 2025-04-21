package com.logrex.patient_management.patient_repository;

import com.logrex.patient_management.patient_entity.VaccinationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepo  extends JpaRepository<VaccinationRecord,Long> {

}
