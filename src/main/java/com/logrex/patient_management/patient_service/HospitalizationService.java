package com.logrex.patient_management.patient_service;

import com.logrex.patient_management.patient_DTO.HospitalizationDTO;

import java.util.List;

public interface HospitalizationService {
    HospitalizationDTO addHospitalizationToPatient(Long patientId, HospitalizationDTO hospitalizationDTO);

    List<HospitalizationDTO> getHospitalizationsByPatientId(Long patientId);

    HospitalizationDTO updateHospitalizationForPatient(Long hospitalizationId, HospitalizationDTO hospitalizationDTO);
}
