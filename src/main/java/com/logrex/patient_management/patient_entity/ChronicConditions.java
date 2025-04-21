package com.logrex.patient_management.patient_entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "chronic_conditions")

public class ChronicConditions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "condition_name", nullable = false)

    private String conditionName;

    @Column(name = "diagnosis_date", nullable = false)

    private Date diagnosisDate;

    @Column(name = "severity_stage", nullable = false)

    private String severityStage;

    @Column(name = "current_status", nullable = false)

    private String currentStatus;

    @Column(name = "treatment_plan")
    private String treatmentPlan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id")
    private  Patient patient;

    public ChronicConditions() {
    }

    public ChronicConditions(Long id, String conditionName, Date diagnosisDate, String severityStage, String currentStatus, String treatmentPlan, Patient patient) {
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
