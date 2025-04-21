package com.logrex.patient_management.patient_DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.util.Date;


public class HospitalizationDTO {
    private Long id;

    @NotNull(message = "Admission date is required")
    @PastOrPresent(message = "Admission date must be in the past or present")
    private Date admissionDate;

    @PastOrPresent(message = "Discharge date must be in the past or present")
    private Date dischargeDate;

    @NotBlank(message = "Reason for hospitalization is required")
    private String reasonForHospitalization;

    private String outcomeOrComplications;
    private String observations;
    private String referredBy;
    private String referredTo;
    private String reasonForReferral;


    private PatientDTO patient;

    public HospitalizationDTO() {
    }

    public HospitalizationDTO(Long id, Date admissionDate, Date dischargeDate, String reasonForHospitalization, String outcomeOrComplications, String observations, String referredBy, String referredTo, String reasonForReferral, PatientDTO patient) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }
}
