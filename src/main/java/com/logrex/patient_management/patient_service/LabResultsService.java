package com.logrex.patient_management.patient_service;

import com.logrex.patient_management.patient_DTO.LabResultDTO;

import java.util.List;

public interface LabResultsService {
    LabResultDTO addLabResultToPatient(Long patientId, LabResultDTO labResultDTO);

    List<LabResultDTO> getLabResultsByPatientId(Long patientId);

    LabResultDTO updateLabResultForPatient(Long patientId, LabResultDTO labResultDTO);

    void deleteLabResultFromPatient(Long patientId);
}
