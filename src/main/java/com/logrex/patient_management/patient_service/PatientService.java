package com.logrex.patient_management.patient_service;

import com.logrex.patient_management.patient_DTO.PatientDTO;
import com.logrex.patient_management.patient_DTO.PatientResponse;

public interface PatientService {
    PatientDTO createPatient(PatientDTO patientDTO);

    PatientDTO updatePatient(Long id, PatientDTO patientDTO);

    void deletePatient(Long id);

    PatientDTO getPatientById(Long id);

    PatientDTO checkPatientExists(String email, String phone);


    PatientResponse getAllPatients(int pageNo, int size, String sortBy, String sortDir);
}
