package com.logrex.patient_management.patient_entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "diagnoses")

public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "diagnosis_name", nullable = false)

    private String diagnosisName;

    @Column(name = "diagnosis_date", nullable = false)
    private Date diagnosisDate;

    @Column(name = "severity_stage", nullable = false)
    private String severityStage;

    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private  Patient patient;

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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
