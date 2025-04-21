package com.logrex.patient_management.patient_DTO;

import com.logrex.patient_management.patient_enums.AdministrationRoute;
import com.logrex.patient_management.patient_enums.PrescriptionStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

import java.util.Date;
import java.util.List;


public class PrescriptionDTO {
    private Long id;

    @NotBlank(message = "Medication name is required")
    private String medicationName;

    @NotBlank(message = "Dosage is required")
    private String dosage;

    @NotBlank(message = "Frequency is required")
    private String frequency;

    @NotBlank(message = "Duration is required")
    private String duration;

    @NotNull(message = "Start date is required")
    private Date startDate;

    private Date endDate;

    @NotNull(message = "Administration route is required")
    private AdministrationRoute route;

    @NotNull(message = "Status is required")
    private PrescriptionStatus status;

    @Min(value = 0, message = "Refills remaining must be 0 or more")
    private int refillsRemaining;

    @Min(value = 0, message = "Refill limit must be 0 or more")
    private int refillLimit;

    @NotNull(message = "Generic allowed flag is required")
    private Boolean isGenericAllowed;

    @NotNull(message = "Pharmacy ID is required")
    private Long pharmacyId;

    private String instructions;

    @NotNull(message = "Prior authorization flag is required")
    private Boolean priorAuthorization;

    private List<String> interactionWarnings;


    private PatientDTO patient;

    public PrescriptionDTO() {
    }

    public PrescriptionDTO(Long id, String medicationName, String dosage, String frequency, String duration, Date startDate, Date endDate, AdministrationRoute route, PrescriptionStatus status, int refillsRemaining, int refillLimit, Boolean isGenericAllowed, Long pharmacyId, String instructions, Boolean priorAuthorization, List<String> interactionWarnings, PatientDTO patient) {
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

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }
}
