package com.logrex.patient_management.patient_controller;

import com.logrex.patient_management.patient_DTO.PatientDTO;
import com.logrex.patient_management.patient_DTO.PatientResponse;
import com.logrex.patient_management.patient_service.PatientService;

import com.logrex.patient_management.utils.AppConstance;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PatientRest {

    private final PatientService patientService;


    public PatientRest(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("patients")
     public ResponseEntity<PatientDTO> createPatients(@Valid @RequestBody PatientDTO patientDTO){

        PatientDTO savePatient= patientService.createPatient(patientDTO);
         return new ResponseEntity<>(savePatient, HttpStatus.CREATED);
     }

     @PutMapping("patients/{id}")
     public  ResponseEntity<PatientDTO> updatePatient(@PathVariable Long id, @Valid @RequestBody PatientDTO patientDTO){

        PatientDTO updateDTO=patientService.updatePatient(id,patientDTO);
        return new ResponseEntity<>(updateDTO, HttpStatus.OK);

     }

     @DeleteMapping("patients/{id}")
     public ResponseEntity<String> deletePatient(@PathVariable Long id){

         patientService.deletePatient(id);

         return new ResponseEntity<>("Sucessfully deleted",HttpStatus.NO_CONTENT);
     }


     @GetMapping("patients/{id}")
     public  ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id){
       PatientDTO patientDTO=  patientService.getPatientById(id);

       return new ResponseEntity<>(patientDTO, HttpStatus.OK);
     }

     @GetMapping("/patient")
     public ResponseEntity<PatientDTO> checkPatientExists(
             @RequestParam(required = false) String email,
             @RequestParam(required = false) String phone){

             PatientDTO patientDTO= patientService.checkPatientExists(email,phone);
         return new ResponseEntity<>(patientDTO, HttpStatus.OK);
     }
    @GetMapping("/patients")
     public ResponseEntity <PatientResponse> getAllPatients(

             @RequestParam(value = "pageNo",defaultValue = AppConstance.DEAFULT_PAGE_NUMBER,required = false) int pageNo,
             @RequestParam(value = "size",defaultValue = AppConstance.DEAFULT_PAGE_SIZE,required = false) int size,
             @RequestParam (value = "sortBy",defaultValue = AppConstance.DEAFULT_SORT_BY,required = false) String sortBy,
             @RequestParam(value = "sortDir", defaultValue = AppConstance.DEAFULT_SORT_DIRECTION,required = false) String sortDir
    ){

       PatientResponse patientResponse=  patientService.getAllPatients(pageNo,size,sortBy,sortDir);

        return new ResponseEntity<>(patientResponse, HttpStatus.OK);

     }

}
