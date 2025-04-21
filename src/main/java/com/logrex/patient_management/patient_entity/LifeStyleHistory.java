package com.logrex.patient_management.patient_entity;

import com.logrex.patient_management.patient_enums.ExerciseHabit;
import jakarta.persistence.*;


@Entity
@Table(name = "life_stype_history")

public class LifeStyleHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    @Column(name = "smoking_status" , nullable = false)
    private  String smokingStatus;

    @Column(name = "alcohol_consumption",nullable = false)
    private  String alcoholConsumption;

    @Column(nullable = false)
    private String diet;

    @Enumerated(EnumType.STRING)
    @Column(name = "exercise_habit", nullable = false)
    private ExerciseHabit exerciseHabit;

    @OneToOne
    @JoinColumn(name="patient_id")

    private  Patient patient;
}
