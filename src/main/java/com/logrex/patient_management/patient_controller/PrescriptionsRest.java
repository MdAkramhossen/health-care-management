package com.logrex.patient_management.patient_controller;

import com.logrex.patient_management.patient_DTO.PrescriptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients/{patientId}/prescriptions")
public class PrescriptionsRest {
    @PostMapping
    public ResponseEntity<PrescriptionDTO> createPrescription(@PathVariable Long patientId,
                                                              @RequestBody PrescriptionDTO prescriptionDTO) {


        return null;
    }

    @GetMapping("/active")
    public ResponseEntity<List<PrescriptionDTO>> getActivePrescriptions(@PathVariable Long patientId) {

        return null;
    }

    @PutMapping("/{prescriptionId}")
    public ResponseEntity<PrescriptionDTO> updatePrescription(@PathVariable Long patientId,
                                                              @PathVariable Long prescriptionId,
                                                              @RequestBody PrescriptionDTO prescriptionDTO) {
        return null;
    }

    @PutMapping("/{prescriptionId}/refill")
    public ResponseEntity<PrescriptionDTO> requestRefill(@PathVariable Long patientId,
                                                         @PathVariable Long prescriptionId) {

        return null;
    }

    @DeleteMapping("/{prescriptionId}")
    public ResponseEntity<Void> cancelPrescription(@PathVariable Long patientId,
                                                   @PathVariable Long prescriptionId) {
      return null;
    }
}
