package com.logrex.patient_management.patient_controller;

import com.logrex.patient_management.patient_DTO.CurrentMedicationsDTO;
import com.logrex.patient_management.patient_service.CurrentMedicationsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationsRest {

    private  final CurrentMedicationsService currentMedicationsService;

    public MedicationsRest(CurrentMedicationsService currentMedicationsService) {
        this.currentMedicationsService = currentMedicationsService;
    }

    public  ResponseEntity<CurrentMedicationsDTO> addMedicationToPatient(@Valid @RequestBody CurrentMedicationsDTO currentMedicationsDTO) {

        CurrentMedicationsDTO createCurrentMedication=currentMedicationsService.addMedicationToPatient(currentMedicationsDTO);
        return new ResponseEntity<>(createCurrentMedication, HttpStatus.CREATED);
    }
    public ResponseEntity<CurrentMedicationsDTO> getCurrentMedicationsByPatientId() {
        CurrentMedicationsDTO getMedication=currentMedicationsService.getCurrentMedicationsByPatientId();
        return new ResponseEntity<>(getMedication, HttpStatus.OK);
    }
    public ResponseEntity<List<CurrentMedicationsDTO>> getAllCurrentMedicationsByPatientId() {
        List<CurrentMedicationsDTO> getAllMedication=currentMedicationsService.getAllCurrentMedicationsByPatientId();
        return new ResponseEntity<>(getAllMedication,HttpStatus.OK);
    }

    public ResponseEntity<CurrentMedicationsDTO> updateMedicationForPatient(@Valid @RequestBody CurrentMedicationsDTO currentMedicationsDTO,Long id) {
        CurrentMedicationsDTO updateMedication=currentMedicationsService.updateMedicationForPatient(currentMedicationsDTO,id);
        return new ResponseEntity<>(updateMedication, HttpStatus.OK);
    }
    public ResponseEntity<String> deleteMedicationFromPatient(@PathVariable Long id) {
        currentMedicationsService.deleteMedicationFromPatient(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
