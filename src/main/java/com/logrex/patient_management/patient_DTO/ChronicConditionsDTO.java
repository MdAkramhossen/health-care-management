package com.logrex.patient_management.patient_DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.util.Date;


public class ChronicConditionsDTO {
    private Long id;

    @NotBlank(message = "Condition name is required")
    private String conditionName;

    @NotNull(message = "Diagnosis date is required")
    @PastOrPresent(message = "Diagnosis date must be in the past or present")
    private Date diagnosisDate;

    @NotBlank(message = "Severity/Stage is required")
    private String severityStage;

    @NotBlank(message = "Current status is required")
    private String currentStatus;

    private String treatmentPlan;
    @JsonIgnore
    private PatientDTO patient;

    public ChronicConditionsDTO() {
    }

    public ChronicConditionsDTO(Long id, String conditionName, Date diagnosisDate, String severityStage, String currentStatus, String treatmentPlan, PatientDTO patient) {
        this.id = id;
        this.conditionName = conditionName;
        this.diagnosisDate = diagnosisDate;
        this.severityStage = severityStage;
        this.currentStatus = currentStatus;
        this.treatmentPlan = treatmentPlan;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getSeverityStage() {
        return severityStage;
    }

    public void setSeverityStage(String severityStage) {
        this.severityStage = severityStage;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }
}