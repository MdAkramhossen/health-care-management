package com.logrex.patient_management.appointment_entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.logrex.patient_management.appointment_enums.AppointmentStatus;
import com.logrex.patient_management.appointment_enums.AppointmentType;
import com.logrex.patient_management.doctor_entity.Doctor;
import com.logrex.patient_management.patient_entity.Patient;
import jakarta.persistence.*;


import java.time.LocalDateTime;




@Entity
@Table(name = "appointments")

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
   @Column
    private LocalDateTime  startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private String location;

    @Enumerated(EnumType.STRING)

    private AppointmentStatus status = AppointmentStatus.SCHEDULED;

    @Enumerated(EnumType.STRING)
    @Column
    private AppointmentType appointmentType=AppointmentType.CHECKUP;

    private String cancellationReason;

    @Lob
    private String notes;

 @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name ="patient_id" )
    @JsonIgnore
    private Patient patient;

 @ManyToOne(fetch = FetchType.EAGER)
 @JoinColumn(name = "doctor_id", nullable = false)
 private Doctor doctor;


 public Appointment() {
 }

 public Appointment(Long appointmentId, LocalDateTime startTime, LocalDateTime endTime, String location, AppointmentStatus status, AppointmentType appointmentType, String cancellationReason, String notes, Patient patient) {
  this.appointmentId = appointmentId;

  this.startTime = startTime;
  this.endTime = endTime;
  this.location = location;
  this.status = status;
  this.appointmentType = appointmentType;
  this.cancellationReason = cancellationReason;
  this.notes = notes;
  this.patient = patient;
 }

 public Appointment(Long appointmentId, LocalDateTime startTime, LocalDateTime endTime, String location, AppointmentStatus status, AppointmentType appointmentType, String cancellationReason, String notes, Patient patient, Doctor doctor) {
  this.appointmentId = appointmentId;
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

 public Long getAppointmentId() {
  return appointmentId;
 }

 public void setAppointmentId(Long appointmentId) {
  this.appointmentId = appointmentId;
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

 public Patient getPatient() {
  return patient;
 }

 public void setPatient(Patient patient) {
  this.patient = patient;
 }

 public Doctor getDoctor() {
  return doctor;
 }

 public void setDoctor(Doctor doctor) {
  this.doctor = doctor;
 }
}
