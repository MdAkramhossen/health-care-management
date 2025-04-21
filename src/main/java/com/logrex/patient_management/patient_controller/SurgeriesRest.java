package com.logrex.patient_management.patient_controller;

import com.logrex.patient_management.patient_DTO.SurgeriesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients/{patientId}/surgeries")
public class SurgeriesRest {

    @PostMapping
    public ResponseEntity<SurgeriesDTO> recordSurgery(@PathVariable Long patientId,
                                                      @RequestBody SurgeriesDTO surgeryDTO) {
       return  null;
    }

    @GetMapping
    public ResponseEntity<List<SurgeriesDTO>> getSurgicalHistory(@PathVariable Long patientId) {

        return  null;
    }

    @PutMapping("/{surgeryId}")
    public ResponseEntity<SurgeriesDTO> updateSurgeryDetails(@PathVariable Long patientId,
                                                           @PathVariable Long surgeryId,
                                                           @RequestBody SurgeriesDTO surgeryDTO) {
       return  null;
    }

//    @PostMapping("/{surgeryId}/followup")
//    public ResponseEntity<SurgeriesDTO> addFollowUp(@PathVariable Long patientId,
//                                                  @PathVariable Long surgeryId,
//                                                  @RequestBody FollowUpDTO followUpDTO) {
//
//        return  null;
//    }
}
