package com.logrex.patient_management.patient_controller;


import com.logrex.patient_management.patient_DTO.ChronicConditionsDTO;
import com.logrex.patient_management.patient_service.ChronicConditionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChronicConditionsRest {

     private ChronicConditionsService chronicConditionsService;

     public ChronicConditionsRest(ChronicConditionsService chronicConditionsService) {
          this.chronicConditionsService = chronicConditionsService;
     }

     @PostMapping("/api/patients/{patientId}/chronic-conditions")
     public ResponseEntity<ChronicConditionsDTO> addChronicConditionToPatient (@RequestBody ChronicConditionsDTO chronicConditionsDTO, @PathVariable Long patientId){

          return new ResponseEntity<>(chronicConditionsService.addChronicConditionToPatient(chronicConditionsDTO,patientId), HttpStatus.CREATED);
     }

     @GetMapping("/api/patients/{patientId}/chronic-conditions")
     public ResponseEntity<List<ChronicConditionsDTO>> getChronicConditionsByPatientId(@PathVariable Long patientId){
             List<ChronicConditionsDTO> chronicCondition= chronicConditionsService.getChronicConditionsByPatientId(patientId);
          return new ResponseEntity<>(chronicCondition,HttpStatus.OK);
     }

     @PutMapping("/api/patients/chronic-conditions/{conditionId}")
     public ResponseEntity<ChronicConditionsDTO> updateChronicConditionForPatient(@PathVariable Long conditionId, @RequestBody ChronicConditionsDTO chronicConditionsDTO){
          return new ResponseEntity<>(chronicConditionsService.updateChronicConditionForPatient(conditionId,chronicConditionsDTO),HttpStatus.OK);
     }


}
