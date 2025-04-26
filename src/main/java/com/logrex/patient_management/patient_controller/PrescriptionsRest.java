package com.logrex.patient_management.patient_controller;

import com.logrex.patient_management.patient_DTO.PrescriptionDTO;
import com.logrex.patient_management.patient_service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients/{patientId}/prescriptions")
public class PrescriptionsRest {

    private final PrescriptionService prescriptionService;

    public PrescriptionsRest(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping
    public ResponseEntity<PrescriptionDTO> createPrescription(@PathVariable Long patientId,
                                                           @Valid @RequestBody PrescriptionDTO prescriptionDTO) {
        PrescriptionDTO createdPrescription = prescriptionService.createPrescription(patientId, prescriptionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPrescription);
    }

    @GetMapping("/active")
    public ResponseEntity<List<PrescriptionDTO>> getActivePrescriptions(@PathVariable Long patientId) {
        List<PrescriptionDTO> activePrescriptions = prescriptionService.getActivePrescriptions(patientId);
        return ResponseEntity.ok(activePrescriptions);
    }

    @PutMapping("/{prescriptionId}")
    public ResponseEntity<PrescriptionDTO> updatePrescription(@PathVariable Long patientId,
                                                              @PathVariable Long prescriptionId,
                                                              @RequestBody PrescriptionDTO prescriptionDTO) {
        PrescriptionDTO updatedPrescription = prescriptionService.updatePrescription(patientId, prescriptionId, prescriptionDTO);
        return ResponseEntity.ok(updatedPrescription);
    }



    @DeleteMapping("/{prescriptionId}")
    public ResponseEntity<String> cancelPrescription(@PathVariable Long patientId,
                                                   @PathVariable Long prescriptionId) {
        prescriptionService.cancelPrescription(patientId, prescriptionId);
        return new ResponseEntity<>("Prescription Cancelled", HttpStatus.OK);
    }
}


