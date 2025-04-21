package com.logrex.patient_management.doctor_repo;

import com.logrex.patient_management.doctor_entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
