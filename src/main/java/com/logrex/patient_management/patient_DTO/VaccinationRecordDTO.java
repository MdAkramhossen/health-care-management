package com.logrex.patient_management.patient_DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.logrex.patient_management.patient_entity.Patient;
import jakarta.validation.constraints.NotBlank;

import java.util.List;


public class VaccinationRecordDTO {

    private Long id;

    @NotBlank(message = "Vaccine name is required")
    private String vaccineName;



    @NotBlank(message = "Dosage/Formulation is required")
    private String dosageFormulation;

    @NotBlank(message = "Lot number is required")
    private String lotNumber;

    @NotBlank(message = "Administering provider is required")
    private String administeringProvider;

    @JsonBackReference
    private List<Patient> patients;

    public VaccinationRecordDTO() {
    }

    public VaccinationRecordDTO(Long id, String vaccineName, String dosageFormulation, String lotNumber, String administeringProvider, List<Patient> patients) {
        this.id = id;
        this.vaccineName = vaccineName;
        this.dosageFormulation = dosageFormulation;
        this.lotNumber = lotNumber;
        this.administeringProvider = administeringProvider;
        this.patients = patients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getDosageFormulation() {
        return dosageFormulation;
    }

    public void setDosageFormulation(String dosageFormulation) {
        this.dosageFormulation = dosageFormulation;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getAdministeringProvider() {
        return administeringProvider;
    }

    public void setAdministeringProvider(String administeringProvider) {
        this.administeringProvider = administeringProvider;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

}
