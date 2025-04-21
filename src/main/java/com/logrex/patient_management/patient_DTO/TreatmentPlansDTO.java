package com.logrex.patient_management.patient_DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;
import java.util.List;

public class TreatmentPlansDTO {

    private Long id;

    @NotBlank(message = "Treatment type is required")
    private String treatmentType;

    @NotBlank(message = "Plan description is required")
    private String planDescription;

    @NotBlank(message = "Goals and objectives are required")
    private String goalsAndObjectives;

    @NotEmpty(message = "At least one follow-up date is required")
    private List<Date> followUpSchedule;

    private String patientInstructions;


    private PatientDTO patient;

    public TreatmentPlansDTO() {
    }

    public TreatmentPlansDTO(Long id, String treatmentType, String planDescription, String goalsAndObjectives, List<Date> followUpSchedule, String patientInstructions, PatientDTO patient) {
        this.id = id;
        this.treatmentType = treatmentType;
        this.planDescription = planDescription;
        this.goalsAndObjectives = goalsAndObjectives;
        this.followUpSchedule = followUpSchedule;
        this.patientInstructions = patientInstructions;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public String getGoalsAndObjectives() {
        return goalsAndObjectives;
    }

    public void setGoalsAndObjectives(String goalsAndObjectives) {
        this.goalsAndObjectives = goalsAndObjectives;
    }

    public List<Date> getFollowUpSchedule() {
        return followUpSchedule;
    }

    public void setFollowUpSchedule(List<Date> followUpSchedule) {
        this.followUpSchedule = followUpSchedule;
    }

    public String getPatientInstructions() {
        return patientInstructions;
    }

    public void setPatientInstructions(String patientInstructions) {
        this.patientInstructions = patientInstructions;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }
}
