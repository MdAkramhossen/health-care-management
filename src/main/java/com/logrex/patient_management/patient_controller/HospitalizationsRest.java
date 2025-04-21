package com.logrex.patient_management.patient_controller;

import com.logrex.patient_management.patient_DTO.HospitalizationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HospitalizationsRest {



    public ResponseEntity<HospitalizationDTO> addHospitalizationToPatient(@RequestBody HospitalizationDTO hospitalizationDTO) {

        return null;
    }

    public ResponseEntity<List<HospitalizationDTO>> getHospitalizationsByPatientId(){
        return null;
    }

    public ResponseEntity<HospitalizationDTO> updateHospitalizationForPatient(@RequestBody HospitalizationDTO hospitalizationDTO) {

        return null;
    }


}
