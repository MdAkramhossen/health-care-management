package com.logrex.patient_management.patient_entity;

import com.logrex.patient_management.patient_enums.AdministrationRoute;
import com.logrex.patient_management.patient_enums.PrescriptionStatus;
import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "medication_prescriptions")

public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "patient_id", nullable = false)
//    @NotNull(message = "Patient ID is required")
//    private Long patientId;
//
//    @Column(name = "doctor_id", nullable = false)
//    @NotNull(message = "Doctor ID is required")
//    private Long doctorId;

    @Column(name = "medication_name", nullable = false)

    private String medicationName;

    @Column(name = "dosage", nullable = false)
    private String dosage;

    @Column(name = "frequency", nullable = false)
    private String frequency;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "administration_route", nullable = false)
    private AdministrationRoute route;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PrescriptionStatus status;

    @Column(name = "refills_remaining", nullable = false)
    private int refillsRemaining;

    @Column(name = "refill_limit", nullable = false)
    private int refillLimit;

    @Column(name = "is_generic_allowed", nullable = false)
    private Boolean isGenericAllowed;

    @Column(name = "pharmacy_id", nullable = false)
    private Long pharmacyId;

    @Column(name = "instructions")
    private String instructions;

    @Column(name = "prior_authorization", nullable = false)
    private Boolean priorAuthorization;

    @ElementCollection
    @CollectionTable(name = "interaction_warnings", joinColumns = @JoinColumn(name = "prescription_id"))
    @Column(name = "warning", nullable = false)
    private List<String> interactionWarnings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private  Patient patient;
}
