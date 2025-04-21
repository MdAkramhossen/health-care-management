package com.logrex.patient_management.patient_entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "hospitalization_records")

public class Hospitalizations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admission_date", nullable = false)
    private Date admissionDate;

    @Column(name = "discharge_date")
    private Date dischargeDate;

    @Column(name = "reason_for_hospitalization", nullable = false)
    private String reasonForHospitalization;

    @Column(name = "outcome_or_complications")
    private String outcomeOrComplications;

    @Column(name = "observations")
    private String observations;

    @Column(name = "referred_by")
    private String referredBy;

    @Column(name = "referred_to")
    private String referredTo;

    @Column(name = "reason_for_referral")
    private String reasonForReferral;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private  Patient patient;
}
