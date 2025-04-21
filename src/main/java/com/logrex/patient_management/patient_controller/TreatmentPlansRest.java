package com.logrex.patient_management.patient_controller;

import com.logrex.patient_management.patient_DTO.TreatmentPlansDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients/{patientId}/treatment-plans")
public class TreatmentPlansRest {
    @PostMapping
    public ResponseEntity<TreatmentPlansDTO> createTreatmentPlan(@PathVariable Long patientId,
                                                                 @RequestBody TreatmentPlansDTO treatmentPlanDTO) {

        return  null;
    }

    @GetMapping("/active")
    public ResponseEntity<List<TreatmentPlansDTO>> getActivePlans(@PathVariable Long patientId) {

        return null;
    }

    @PutMapping("/{planId}")
    public ResponseEntity<TreatmentPlansDTO> modifyTreatmentPlan(@PathVariable Long patientId,
                                                                 @PathVariable Long planId,
                                                                 @RequestBody TreatmentPlansDTO treatmentPlanDTO) {

        return null;
    }

    @PutMapping("/{planId}/progress")
    public ResponseEntity<TreatmentPlansDTO> updateProgress(@PathVariable Long patientId,
                                                            @PathVariable Long planId,
                                                            @RequestBody String progressNote) {

        return null;
    }

    @DeleteMapping("/{planId}")
    public ResponseEntity<Void> cancelPlan(@PathVariable Long patientId,
                                           @PathVariable Long planId) {

        return null;
    }
}
