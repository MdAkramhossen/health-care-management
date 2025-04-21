package com.logrex.patient_management.patient_entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "treatment_plans")

public class TreatmentPlans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "treatment_type", nullable = false)
    private String treatmentType;

   @Column(name = "plan_description", nullable = false, columnDefinition = "TEXT")
   private String planDescription;

    @Column(name = "goals_and_objectives", nullable = false, columnDefinition = "TEXT")
    private String goalsAndObjectives;


    @ElementCollection
    @CollectionTable(name = "followup_schedule", joinColumns = @JoinColumn(name = "treatment_plan_id"))
    @Column(name = "follow_up_date", nullable = false)
    private List<Date> followUpSchedule;

    @Column(name = "patient_instructions", columnDefinition = "TEXT")
    private String patientInstructions;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
}
