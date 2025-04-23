package com.logrex.patient_management.patient_DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;


public class LabResultDTO {
    private Long id;

    @NotBlank(message = "Test name is required")
    private String testName;

    @NotBlank(message = "Result values are required")
    private String resultValues;

    @NotBlank(message = "Reference range is required")
    private String referenceRange;

    private String orderingProvider;

    @NotBlank(message = "Performing laboratory is required")
    private String performingLaboratory;

    @JsonIgnore
    private PatientDTO patient;

    public LabResultDTO() {
    }

    public LabResultDTO(Long id, String testName, String resultValues, String referenceRange, String orderingProvider, String performingLaboratory, PatientDTO patient) {
        this.id = id;
        this.testName = testName;
        this.resultValues = resultValues;
        this.referenceRange = referenceRange;
        this.orderingProvider = orderingProvider;
        this.performingLaboratory = performingLaboratory;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getResultValues() {
        return resultValues;
    }

    public void setResultValues(String resultValues) {
        this.resultValues = resultValues;
    }

    public String getReferenceRange() {
        return referenceRange;
    }

    public void setReferenceRange(String referenceRange) {
        this.referenceRange = referenceRange;
    }

    public String getOrderingProvider() {
        return orderingProvider;
    }

    public void setOrderingProvider(String orderingProvider) {
        this.orderingProvider = orderingProvider;
    }

    public String getPerformingLaboratory() {
        return performingLaboratory;
    }

    public void setPerformingLaboratory(String performingLaboratory) {
        this.performingLaboratory = performingLaboratory;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }
}
