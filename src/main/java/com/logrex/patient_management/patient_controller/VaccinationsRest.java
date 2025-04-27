package com.logrex.patient_management.patient_controller;

import com.logrex.patient_management.patient_DTO.VaccinationRecordDTO;
import com.logrex.patient_management.patient_service.VaccinationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccinations")
public class VaccinationsRest {

    private final VaccinationService vaccinationService;

    public VaccinationsRest(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @PostMapping
    public ResponseEntity<List<VaccinationRecordDTO>> createcreateVaccination(@Valid @RequestBody List<VaccinationRecordDTO> vaccinationRecordDTO) {

        List<VaccinationRecordDTO> createVaccinationRecord= vaccinationService.createcreateVaccination(vaccinationRecordDTO);
        return new ResponseEntity<>(createVaccinationRecord, HttpStatus.CREATED);
    }

 @PostMapping
    public ResponseEntity<VaccinationRecordDTO> addVaccinationRecordToPatient(@Valid @RequestBody VaccinationRecordDTO vaccinationRecordDTO) {

     VaccinationRecordDTO createVaccinationRecord= vaccinationService.addVaccinationRecordToPatient(vaccinationRecordDTO);
     return new ResponseEntity<>(createVaccinationRecord, HttpStatus.CREATED);
    }
    @GetMapping
    public  ResponseEntity<List<VaccinationRecordDTO>> getAllVaccinationRecordsByPatientId() {
        List<VaccinationRecordDTO> getAllRecord= vaccinationService.getAllVaccinationRecordsByPatientId();
        return new ResponseEntity<>(getAllRecord,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<VaccinationRecordDTO> updateVaccinationRecordForPatient(@Valid @RequestBody VaccinationRecordDTO vaccinationRecord, @PathVariable Long id){

        VaccinationRecordDTO updateVaccinationRecord=vaccinationService.updateVaccinationRecordForPatient(vaccinationRecord,id);
        return new ResponseEntity<>(updateVaccinationRecord, HttpStatus.OK);
    }

    @DeleteMapping
    public  ResponseEntity<String> deleteVaccinationRecordFromPatient(@PathVariable Long id){
        vaccinationService.deleteVaccinationRecordFromPatient(id);
        return new ResponseEntity<>("Vaccination record deleted", HttpStatus.OK);
    }

}
