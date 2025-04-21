package com.logrex.patient_management.patient_service;

import com.logrex.patient_management.patient_DTO.AllergyDTO;

import java.util.List;

public interface AllergyService {
    AllergyDTO addAllergyToPatient(AllergyDTO allergyDTO);

    List<AllergyDTO> getAllergiesByPatientId();

    AllergyDTO updateAllergyForPatient(AllergyDTO allergyDTO, Long id);

    void deleteAllergyFromPatient(Long id);
}
