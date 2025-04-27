package com.logrex.patient_management.patient_controller;

import com.logrex.patient_management.patient_DTO.PatientDTO;
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
    public ResponseEntity<VaccinationRecordDTO> createVaccination(
            @Valid @RequestBody VaccinationRecordDTO vaccinationDTO) {
        VaccinationRecordDTO created = vaccinationService.createVaccination(vaccinationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }


    @GetMapping
    public ResponseEntity<List<VaccinationRecordDTO>> getAllVaccinations() {
        List<VaccinationRecordDTO> list = vaccinationService.getAllVaccinations();
        return ResponseEntity.ok(list);
    }


    @GetMapping("/{vaccinationId}")
    public ResponseEntity<VaccinationRecordDTO> getVaccinationById(
            @PathVariable Long vaccinationId) {
        VaccinationRecordDTO dto = vaccinationService.getVaccinationById(vaccinationId);
        return ResponseEntity.ok(dto);
    }


    @PutMapping("/{vaccinationId}")
    public ResponseEntity<VaccinationRecordDTO> updateVaccination(
            @PathVariable Long vaccinationId,
            @Valid @RequestBody VaccinationRecordDTO vaccinationDTO) {
        VaccinationRecordDTO updated = vaccinationService.updateVaccination(vaccinationId, vaccinationDTO);
        return ResponseEntity.ok(updated);
    }

    /** Delete a vaccination record */
    @DeleteMapping("/{vaccinationId}")
    public ResponseEntity<String> deleteVaccination(@PathVariable Long vaccinationId) {
        vaccinationService.deleteVaccination(vaccinationId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    // ------------------------------------------------------------------
    // Endpoints to manage the many-to-many link between Vaccination and Patient
    // ------------------------------------------------------------------

    /** List all patients who have received a given vaccination */
    @GetMapping("/{vaccinationId}/patients")
    public ResponseEntity<List<PatientDTO>> getPatientsForVaccination(
            @PathVariable Long vaccinationId) {
        List<PatientDTO> patients = vaccinationService.getPatientsByVaccinationId(vaccinationId);
        return ResponseEntity.ok(patients);
    }

    /** Add a patient to a vaccination’s recipients */
    @PostMapping("/{vaccinationId}/patients/{patientId}")
    public ResponseEntity<Void> addPatientToVaccination(
            @PathVariable Long vaccinationId,
            @PathVariable Long patientId) {
        vaccinationService.addPatientToVaccination(vaccinationId, patientId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /** Remove a patient from a vaccination’s recipients */
    @DeleteMapping("/{vaccinationId}/patients/{patientId}")
    public ResponseEntity<Void> removePatientFromVaccination(
            @PathVariable Long vaccinationId,
            @PathVariable Long patientId) {
        vaccinationService.removePatientFromVaccination(vaccinationId, patientId);
        return ResponseEntity.noContent().build();
    }
}
