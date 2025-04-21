package com.logrex.patient_management.patient_DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.logrex.patient_management.patient_enums.Severity;
import jakarta.validation.constraints.NotBlank;


import java.util.Date;



public class AllergyDTO {

    @NotBlank(message = "Allergen name is required")
    private String allergenName;

    @NotBlank(message = "Reaction type is required")
    private String reactionType;


    private Severity severity;


    private Date onsetDate;

    private String notes;
    @JsonBackReference
    private PatientDTO patient;

    public AllergyDTO() {
    }

    public AllergyDTO(String allergenName, String reactionType, Severity severity, Date onsetDate, String notes, PatientDTO patient) {
        this.allergenName = allergenName;
        this.reactionType = reactionType;
        this.severity = severity;
        this.onsetDate = onsetDate;
        this.notes = notes;
        this.patient = patient;
    }

    public String getAllergenName() {
        return allergenName;
    }

    public void setAllergenName(String allergenName) {
        this.allergenName = allergenName;
    }

    public String getReactionType() {
        return reactionType;
    }

    public void setReactionType(String reactionType) {
        this.reactionType = reactionType;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Date getOnsetDate() {
        return onsetDate;
    }

    public void setOnsetDate(Date onsetDate) {
        this.onsetDate = onsetDate;
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
