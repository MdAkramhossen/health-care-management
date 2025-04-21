package com.logrex.patient_management.patient_controller;

import com.logrex.patient_management.patient_DTO.LabResultDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lab-results")
public class LabResultsRest {

    @PostMapping("/{patientId}")
    public ResponseEntity<LabResultDTO> addLabResultToPatient(@PathVariable Long patientId,
                                                              @RequestBody LabResultDTO labResultDTO) {

        return null;
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<LabResultDTO>> getLabResultsByPatientId(@PathVariable Long patientId) {

        return null;
    }

    @PutMapping("/{patientId}/{labResultId}")
    public ResponseEntity<LabResultDTO> updateLabResultForPatient(@PathVariable Long patientId,
                                                                  @PathVariable Long labResultId,
                                                                  @RequestBody LabResultDTO labResultDTO) {
     return null;
    }

    @DeleteMapping("/{patientId}/{labResultId}")
    public ResponseEntity<Void> deleteLabResultFromPatient(@PathVariable Long patientId,
                                                           @PathVariable Long labResultId) {
       return null;
    }

}
