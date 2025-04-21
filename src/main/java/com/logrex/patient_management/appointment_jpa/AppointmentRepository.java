package com.logrex.patient_management.appointment_jpa;

import com.logrex.patient_management.appointment_entity.Appointment;
import com.logrex.patient_management.appointment_enums.AppointmentStatus;
import com.logrex.patient_management.patient_entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findByDoctorId(Long doctorId);
    List<Appointment> findByStatus(AppointmentStatus status);
    List<Appointment> findByStartTimeBetween(ZonedDateTime start, ZonedDateTime end);
    List<Patient> findDistinctByDoctorId(Long doctorId);




}
