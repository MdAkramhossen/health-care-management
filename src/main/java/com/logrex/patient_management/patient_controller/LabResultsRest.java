package com.logrex.patient_management.patient_controller;

import com.logrex.patient_management.patient_DTO.LabResultDTO;
import com.logrex.patient_management.patient_service.LabResultsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lab-results")
public class LabResultsRest {

    private final LabResultsService labResultsService;

    public LabResultsRest(LabResultsService labResultsService) {
        this.labResultsService = labResultsService;
    }

    @PostMapping("/{patientId}")
    public ResponseEntity<LabResultDTO> addLabResultToPatient(@PathVariable Long patientId,
                                                              @RequestBody LabResultDTO labResultDTO) {
        LabResultDTO createdResult = labResultsService.addLabResultToPatient(patientId, labResultDTO);
        return new ResponseEntity<>(createdResult, HttpStatus.OK);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<LabResultDTO>> getLabResultsByPatientId(@PathVariable Long patientId) {
        List<LabResultDTO> results = labResultsService.getLabResultsByPatientId(patientId);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @PutMapping("{labResultId}")
    public ResponseEntity<LabResultDTO> updateLabResultForPatient(@PathVariable Long labResultId, @RequestBody LabResultDTO labResultDTO) {
        LabResultDTO updatedResult = labResultsService.updateLabResultForPatient(labResultId, labResultDTO);
        return new ResponseEntity<>(updatedResult, HttpStatus.OK);
    }

    @DeleteMapping("{labResultId}")
    public ResponseEntity<String> deleteLabResultFromPatient(@PathVariable Long labResultId) {
        labResultsService.deleteLabResultFromPatient(labResultId);
        return new ResponseEntity<>("Successfully deleted ! ",HttpStatus.NO_CONTENT);
    }
}
