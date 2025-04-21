package com.logrex.patient_management.patient_controller;

import com.logrex.patient_management.patient_DTO.HospitalizationDTO;
import com.logrex.patient_management.patient_service.HospitalizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitalizations")
public class HospitalizationsRest {

    @Autowired
    private HospitalizationService hospitalizationService;


    @PostMapping("/patient/{patientId}")
    public ResponseEntity<HospitalizationDTO> addHospitalizationToPatient(@Valid
            @PathVariable Long patientId,@RequestBody HospitalizationDTO hospitalizationDTO) {
        HospitalizationDTO savedHospitalization = hospitalizationService.addHospitalizationToPatient(patientId, hospitalizationDTO);
        return new ResponseEntity<>(savedHospitalization, HttpStatus.CREATED);
    }

    @Transactional
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<HospitalizationDTO>> getHospitalizationsByPatientId(@PathVariable Long patientId) {
        List<HospitalizationDTO> hospitalizations = hospitalizationService.getHospitalizationsByPatientId(patientId);
        return new ResponseEntity<>(hospitalizations, HttpStatus.OK);
    }


    @PutMapping("/{hospitalizationId}")
    public ResponseEntity<HospitalizationDTO> updateHospitalizationForPatient(@PathVariable Long hospitalizationId,@RequestBody HospitalizationDTO hospitalizationDTO) {
        HospitalizationDTO updated = hospitalizationService.updateHospitalizationForPatient(hospitalizationId, hospitalizationDTO);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }
}
