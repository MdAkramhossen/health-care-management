package com.logrex.patient_management.patient_service;

import com.logrex.patient_management.patient_DTO.ChronicConditionsDTO;

import java.util.List;

public interface ChronicConditionsService {
    ChronicConditionsDTO addChronicConditionToPatient(ChronicConditionsDTO chronicConditionsDTO, Long patientId);

    List<ChronicConditionsDTO> getChronicConditionsByPatientId(Long patientId);

    ChronicConditionsDTO updateChronicConditionForPatient(Long conditionId, ChronicConditionsDTO chronicConditionsDTO);
}
