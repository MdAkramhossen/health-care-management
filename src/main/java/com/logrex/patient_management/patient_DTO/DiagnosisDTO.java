package com.logrex.patient_management.patient_DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;



public class DiagnosisDTO {
    private Long id;

    @NotBlank(message = "Diagnosis name is required")
    private String diagnosisName;


    private Date diagnosisDate;

    @NotBlank(message = "Severity/Stage is required")
    private String severityStage;

    private String notes;

    @JsonBackReference
    private PatientDTO patient;

    public DiagnosisDTO() {
    }

    public DiagnosisDTO(Long id, String diagnosisName, Date diagnosisDate, String severityStage, String notes, PatientDTO patient) {
        this.id = id;
        this.diagnosisName = diagnosisName;
        this.diagnosisDate = diagnosisDate;
        this.severityStage = severityStage;
        this.notes = notes;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName;
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
}