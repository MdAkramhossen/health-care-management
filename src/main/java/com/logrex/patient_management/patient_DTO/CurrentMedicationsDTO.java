package com.logrex.patient_management.patient_DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class CurrentMedicationsDTO {
    private Long id;

    @NotBlank(message = "Medication name is required")
    private String medicationName;

    private String dosage;
    private String frequency;
    private String route;
    private String form;
    private String indication;

    @NotNull(message = "Start date is required")
    private Date startDate;

    private Date endDate;
    private String additionalInstructions;

    @NotBlank(message = "Prescribing physician name is required")
    private String prescribingPhysicianName;


    private PatientDTO patient;
}