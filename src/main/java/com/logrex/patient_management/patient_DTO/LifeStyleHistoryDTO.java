package com.logrex.patient_management.patient_DTO;
import com.logrex.patient_management.patient_enums.ExerciseHabit;
import jakarta.validation.constraints.NotBlank;

public class LifeStyleHistoryDTO {
    private Long id;

    @NotBlank(message = "Smoking status is required")
    private String smokingStatus;

    @NotBlank(message = "Alcohol consumption is required")
    private String alcoholConsumption;

    @NotBlank(message = "Diet information is required")
    private String diet;

    private ExerciseHabit exerciseHabit;


    private PatientDTO patient;
}
