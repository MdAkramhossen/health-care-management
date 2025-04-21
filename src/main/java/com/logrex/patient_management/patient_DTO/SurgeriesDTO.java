package com.logrex.patient_management.patient_DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.util.Date;


public class SurgeriesDTO {

    private Long id;

    @NotBlank(message = "Procedure name is required")
    private String procedureName;

    @NotNull(message = "Date of surgery is required")
    @PastOrPresent(message = "Date of surgery must be in the past or present")
    private Date dateOfSurgery;

    private String outcomeOrComplications;


    private PatientDTO patient;

    public SurgeriesDTO() {
    }

    public SurgeriesDTO(Long id, String procedureName, Date dateOfSurgery, String outcomeOrComplications, PatientDTO patient) {
        this.id = id;
        this.procedureName = procedureName;
        this.dateOfSurgery = dateOfSurgery;
        this.outcomeOrComplications = outcomeOrComplications;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Date getDateOfSurgery() {
        return dateOfSurgery;
    }

    public void setDateOfSurgery(Date dateOfSurgery) {
        this.dateOfSurgery = dateOfSurgery;
    }

    public String getOutcomeOrComplications() {
        return outcomeOrComplications;
    }

    public void setOutcomeOrComplications(String outcomeOrComplications) {
        this.outcomeOrComplications = outcomeOrComplications;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }
}
