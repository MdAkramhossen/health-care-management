package com.logrex.patient_management.patient_service;

import com.logrex.patient_management.patient_DTO.CurrentMedicationsDTO;

import java.util.List;

public interface CurrentMedicationsService {
    CurrentMedicationsDTO addMedicationToPatient(CurrentMedicationsDTO currentMedicationsDTO);

    CurrentMedicationsDTO getCurrentMedicationsByPatientId();

    List<CurrentMedicationsDTO> getAllCurrentMedicationsByPatientId();

    CurrentMedicationsDTO updateMedicationForPatient(CurrentMedicationsDTO currentMedicationsDTO, Long id);

    void deleteMedicationFromPatient(Long id);
}
