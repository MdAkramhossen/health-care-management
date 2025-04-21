package com.logrex.patient_management.patient_entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "surgical_procedures")

public class Surgeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "procedure_name", nullable = false)

    private String procedureName;

    @Column(name = "date_of_surgery", nullable = false)
    private Date dateOfSurgery;

    @Column(name = "outcome_complications")
    private String outcomeOrComplications;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;


}
