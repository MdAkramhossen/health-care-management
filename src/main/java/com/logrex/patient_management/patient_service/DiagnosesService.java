package com.logrex.patient_management.patient_service;

import com.logrex.patient_management.patient_DTO.DiagnosisDTO;

import java.util.List;

public interface DiagnosesService {
    DiagnosisDTO addDiagnosisToPatient(DiagnosisDTO diagnosisDTO);



    void deleteDiagnosisFromPatient(Long id);

    DiagnosisDTO updateDiagnosisForPatient(DiagnosisDTO diagnosisDTO, Long id);

    List<DiagnosisDTO> getAllDiagnosesByPatientId();
}
