package com.logrex.patient_management.patient_service;

import com.logrex.patient_management.patient_DTO.VaccinationRecordDTO;

import java.util.List;

public interface VaccinationService {
    List<VaccinationRecordDTO> createcreateVaccination(List<VaccinationRecordDTO> vaccinationRecordDTO);


    VaccinationRecordDTO addVaccinationRecordToPatient(VaccinationRecordDTO vaccinationRecordDTO);

    List<VaccinationRecordDTO> getAllVaccinationRecordsByPatientId();

    VaccinationRecordDTO updateVaccinationRecordForPatient(VaccinationRecordDTO vaccinationRecord, Long id);

    void deleteVaccinationRecordFromPatient(Long id);


}
