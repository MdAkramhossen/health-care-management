package com.logrex.patient_management.patient_controller;

import com.logrex.patient_management.patient_DTO.AllergyDTO;
import com.logrex.patient_management.patient_service.AllergyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allergies")
public class AllergiesRest {


    private   final AllergyService allergyService;

    public AllergiesRest(AllergyService allergyService) {

        this.allergyService = allergyService;
    }



    @PostMapping
    public ResponseEntity<AllergyDTO> addAllergyToPatient(@Valid @RequestBody AllergyDTO allergyDTO){
         AllergyDTO allergyDTOS= allergyService.addAllergyToPatient(allergyDTO);
        return new ResponseEntity<>(allergyDTOS, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<AllergyDTO>> getAllergiesByPatientId(){

        List<AllergyDTO> allergyDTO= allergyService.getAllergiesByPatientId();

        return new ResponseEntity<>(allergyDTO,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AllergyDTO> updateAllergyForPatient(@Valid @RequestBody AllergyDTO allergyDTO, @PathVariable Long id){

        AllergyDTO updateAllergy= allergyService.updateAllergyForPatient(allergyDTO, id);
        return new ResponseEntity<>(allergyDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteAllergyFromPatient(@PathVariable Long id){

        allergyService.deleteAllergyFromPatient(id);

        return new ResponseEntity<>("Allergy deleted successfully",HttpStatus.OK);
    }

}
