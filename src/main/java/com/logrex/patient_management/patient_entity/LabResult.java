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
}
