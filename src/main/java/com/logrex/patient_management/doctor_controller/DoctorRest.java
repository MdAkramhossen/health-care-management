package com.logrex.patient_management.doctor_controller;
import com.logrex.patient_management.doctorDTO.DoctorDTO;
import com.logrex.patient_management.doctor_service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
public class DoctorRest {


    private final DoctorService doctorService;

    public DoctorRest(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorProfile(@PathVariable Long id) {

        DoctorDTO doctor= doctorService.getDoctorById(id);
        return new ResponseEntity<>(doctor,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        List<DoctorDTO> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors,HttpStatus.OK);
    }

    @PutMapping("/{id}/upload-profile")
    public ResponseEntity<String> updateDoctorProfile(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile multipartFile) {

        String doctor = doctorService.uploadProfilePicture(id, multipartFile);
        return new ResponseEntity<>(doctor,HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateAvailability(@PathVariable Long id, @RequestParam String status) {
         String doctor = doctorService.updateAvailability(id, status);
        return new ResponseEntity<>(doctor,HttpStatus.OK);
    }

    @PostMapping("/{id}/upload-profile-picture")
    public ResponseEntity<Map<String, String>> uploadProfilePicture(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        String path = doctorService.uploadProfilePicture(id, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("profilePicturePath", path));
    }

}
