package com.logrex.patient_management.appointment_service;

import com.logrex.patient_management.appointment_DTO.AppointmentDTO;
import com.logrex.patient_management.appointment_enums.AppointmentStatus;
import com.logrex.patient_management.patient_DTO.PatientDTO;

import java.time.ZonedDateTime;
import java.util.List;

public interface AppointmentService {

    AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);

    AppointmentDTO updateAppointment(Long appointmentId, AppointmentDTO appointmentDTO);

    void deleteAppointment(Long appointmentId);

    AppointmentDTO getAppointmentById(Long appointmentId);

    List<AppointmentDTO> getAllAppointments();



    List<AppointmentDTO> getAppointmentsByStatus(AppointmentStatus status);

    List<AppointmentDTO> getAppointmentsByDateRange(ZonedDateTime start, ZonedDateTime end);

    void cancelAppointment(Long appointmentId, String reason);

    boolean isDoctorAvailable(Long doctorId, ZonedDateTime startTime, ZonedDateTime endTime);

    List<PatientDTO> getPatientsByDoctorId(Long doctorId);
}
