package com.logrex.patient_management.appointment_DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.logrex.patient_management.appointment_enums.AppointmentStatus;
import com.logrex.patient_management.appointment_enums.AppointmentType;
import com.logrex.patient_management.doctorDTO.DoctorDTO;
import com.logrex.patient_management.patient_DTO.PatientDTO;


import java.time.LocalDateTime;


public class AppointmentDTO {


    private Long doctorId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private AppointmentStatus status = AppointmentStatus.SCHEDULED;
    private AppointmentType appointmentType;
    private String cancellationReason;
    private String notes;

    private PatientDTO patient;

  private DoctorDTO doctor;
    public AppointmentDTO() {
    }

    public AppointmentDTO(Long doctorId, LocalDateTime startTime, LocalDateTime endTime, String location, AppointmentStatus status, AppointmentType appointmentType, String cancellationReason, String notes, PatientDTO patient, DoctorDTO doctor) {
        this.doctorId = doctorId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.status = status;
        this.appointmentType = appointmentType;
        this.cancellationReason = cancellationReason;
        this.notes = notes;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }
}
