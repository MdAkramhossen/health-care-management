package com.logrex.patient_management.patient_service;

import com.logrex.patient_management.patient_DTO.PatientDTO;
import com.logrex.patient_management.patient_DTO.VaccinationRecordDTO;

import java.util.List;

public interface VaccinationService {


    VaccinationRecordDTO createVaccination(VaccinationRecordDTO vaccinationDTO);

    List<VaccinationRecordDTO> getAllVaccinations();

    VaccinationRecordDTO getVaccinationById(Long vaccinationId);

    VaccinationRecordDTO updateVaccination(Long vaccinationId, VaccinationRecordDTO vaccinationDTO);

    void deleteVaccination(Long vaccinationId);

    List<PatientDTO> getPatientsByVaccinationId(Long vaccinationId);

    void addPatientToVaccination(Long vaccinationId, Long patientId);

    void removePatientFromVaccination(Long vaccinationId, Long patientId);
}
