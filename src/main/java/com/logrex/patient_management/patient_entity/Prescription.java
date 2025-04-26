package com.logrex.patient_management.patient_entity;

import com.logrex.patient_management.doctor_entity.Doctor;
import com.logrex.patient_management.patient_enums.AdministrationRoute;
import com.logrex.patient_management.patient_enums.PrescriptionStatus;
import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "medication_prescriptions")

public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "medication_name", nullable = false)
    private String medicationName;

    @Column(name = "dosage", nullable = false)
    private String dosage;

    @Column(name = "frequency", nullable = false)
    private String frequency;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "administration_route", nullable = false)
    private AdministrationRoute route;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PrescriptionStatus status;

    @Column(name = "refills_remaining", nullable = false)
    private int refillsRemaining;

    @Column(name = "refill_limit", nullable = false)
    private int refillLimit;

    @Column(name = "is_generic_allowed", nullable = false)
    private Boolean isGenericAllowed;

    @Column(name = "pharmacy_id", nullable = false)
    private Long pharmacyId;

    @Column(name = "instructions")
    private String instructions;

    @Column(name = "prior_authorization", nullable = false)
    private Boolean priorAuthorization;

    @ElementCollection
    @CollectionTable(name = "interaction_warnings", joinColumns = @JoinColumn(name = "prescription_id"))
    @Column(name = "warning", nullable = false)
    private List<String> interactionWarnings;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private  Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;

    public Prescription() {
    }

    public Prescription(Long id, String medicationName, String dosage, String frequency, String duration, Date startDate, Date endDate, AdministrationRoute route, PrescriptionStatus status, int refillsRemaining, int refillLimit, Boolean isGenericAllowed, Long pharmacyId, String instructions, Boolean priorAuthorization, List<String> interactionWarnings, Patient patient, Doctor doctor) {
        this.id = id;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.frequency = frequency;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.route = route;
        this.status = status;
        this.refillsRemaining = refillsRemaining;
        this.refillLimit = refillLimit;
        this.isGenericAllowed = isGenericAllowed;
        this.pharmacyId = pharmacyId;
        this.instructions = instructions;
        this.priorAuthorization = priorAuthorization;
        this.interactionWarnings = interactionWarnings;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public AdministrationRoute getRoute() {
        return route;
    }

    public void setRoute(AdministrationRoute route) {
        this.route = route;
    }

    public PrescriptionStatus getStatus() {
        return status;
    }

    public void setStatus(PrescriptionStatus status) {
        this.status = status;
    }

    public int getRefillsRemaining() {
        return refillsRemaining;
    }

    public void setRefillsRemaining(int refillsRemaining) {
        this.refillsRemaining = refillsRemaining;
    }

    public int getRefillLimit() {
        return refillLimit;
    }

    public void setRefillLimit(int refillLimit) {
        this.refillLimit = refillLimit;
    }

    public Boolean getGenericAllowed() {
        return isGenericAllowed;
    }

    public void setGenericAllowed(Boolean genericAllowed) {
        isGenericAllowed = genericAllowed;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Boolean getPriorAuthorization() {
        return priorAuthorization;
    }

    public void setPriorAuthorization(Boolean priorAuthorization) {
        this.priorAuthorization = priorAuthorization;
    }

    public List<String> getInteractionWarnings() {
        return interactionWarnings;
    }

    public void setInteractionWarnings(List<String> interactionWarnings) {
        this.interactionWarnings = interactionWarnings;
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
