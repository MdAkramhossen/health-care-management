package com.logrex.patient_management.patient_service;

import com.logrex.patient_management.patient_DTO.PrescriptionDTO;

import java.util.List;

public interface PrescriptionService {
    void cancelPrescription(Long patientId, Long prescriptionId);



    PrescriptionDTO updatePrescription(Long patientId, Long prescriptionId, PrescriptionDTO prescriptionDTO);

    List<PrescriptionDTO> getActivePrescriptions(Long patientId);

    PrescriptionDTO createPrescription(Long patientId, PrescriptionDTO prescriptionDTO);
}
