package com.logrex.patient_management.patient_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lab_results")

public class LabResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "test_name", nullable = false)
    private String testName;

    @Column(name = "result_values", nullable = false)
    private String resultValues;

    @Column(name = "reference_range", nullable = false)
    private String referenceRange;

    @Column(name = "ordering_provider")
    private String orderingProvider;

    @Column(name = "performing_laboratory", nullable = false)
    private String performingLaboratory;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public LabResult() {
    }

    public LabResult(Long id, String testName, String resultValues, String referenceRange, String orderingProvider, String performingLaboratory, Patient patient) {
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
