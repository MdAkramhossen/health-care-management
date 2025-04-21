package com.logrex.patient_management.patient_entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "hospitalization_records")

public class Hospitalizations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admission_date", nullable = false)
    private Date admissionDate;

    @Column(name = "discharge_date")
    private Date dischargeDate;

    @Column(name = "reason_for_hospitalization", nullable = false)
    private String reasonForHospitalization;

    @Column(name = "outcome_or_complications")
    private String outcomeOrComplications;

    @Column(name = "observations")
    private String observations;

    @Column(name = "referred_by")
    private String referredBy;

    @Column(name = "referred_to")
    private String referredTo;

    @Column(name = "reason_for_referral")
    private String reasonForReferral;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private  Patient patient;

    public Hospitalizations() {
    }

    public Hospitalizations(Long id, Date admissionDate, Date dischargeDate, String reasonForHospitalization, String outcomeOrComplications, String observations, String referredBy, String referredTo, String reasonForReferral, Patient patient) {
        this.id = id;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.reasonForHospitalization = reasonForHospitalization;
        this.outcomeOrComplications = outcomeOrComplications;
        this.observations = observations;
        this.referredBy = referredBy;
        this.referredTo = referredTo;
        this.reasonForReferral = reasonForReferral;
        this.patient = patient;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getReasonForHospitalization() {
        return reasonForHospitalization;
    }

    public void setReasonForHospitalization(String reasonForHospitalization) {
        this.reasonForHospitalization = reasonForHospitalization;
    }

    public String getOutcomeOrComplications() {
        return outcomeOrComplications;
    }

    public void setOutcomeOrComplications(String outcomeOrComplications) {
        this.outcomeOrComplications = outcomeOrComplications;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public String getReferredTo() {
        return referredTo;
    }

    public void setReferredTo(String referredTo) {
        this.referredTo = referredTo;
    }

    public String getReasonForReferral() {
        return reasonForReferral;
    }

    public void setReasonForReferral(String reasonForReferral) {
        this.reasonForReferral = reasonForReferral;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
