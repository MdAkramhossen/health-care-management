package com.logrex.patient_management.patient_controller;

import com.logrex.patient_management.patient_DTO.DiagnosisDTO;
import com.logrex.patient_management.patient_service.DiagnosesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagnoses")
public class DiagnosesRest {

public  final DiagnosesService diagnosesService;


    public DiagnosesRest(DiagnosesService diagnosesService) {
        this.diagnosesService = diagnosesService;
    }

    @PostMapping
    public ResponseEntity<DiagnosisDTO> addDiagnosisToPatient(@Valid @RequestBody DiagnosisDTO diagnosisDTO){

         DiagnosisDTO createDiagnosis=diagnosesService.addDiagnosisToPatient( diagnosisDTO);
        return new ResponseEntity<>(createDiagnosis, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DiagnosisDTO>> getAllDiagnosesByPatientId(){

        List<DiagnosisDTO> diagnosisDTO=diagnosesService.getAllDiagnosesByPatientId();
        return new ResponseEntity<>(diagnosisDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiagnosisDTO> updateDiagnosisForPatient(@Valid @RequestBody DiagnosisDTO diagnosisDTO,@PathVariable Long id){

         DiagnosisDTO updateDiagnosis=diagnosesService.updateDiagnosisForPatient( diagnosisDTO,id);
        return new ResponseEntity<>(updateDiagnosis, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiagnosisFromPatient(@PathVariable Long id){

        diagnosesService.deleteDiagnosisFromPatient(id);
        return new ResponseEntity<>("Scessfully deleted", HttpStatus.OK);
    }
}
