package com.logrex.patient_management.patient_entity;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name="current_medications")

public class CurrentMedications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "medication_name", nullable = false)

    private String medicationName;

    private String dosage;
    private String frequency;
    private String route;
    private String form;
    private String indication;

    @Column(name = "start_date", nullable = false)

    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "additional_instructions")
    private String additionalInstructions;

    @Column(name = "prescribing_physician_name", nullable = false)

    private String prescribingPhysicianName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id")
    private  Patient patient;


}
