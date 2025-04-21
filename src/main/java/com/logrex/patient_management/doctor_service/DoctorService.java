package com.logrex.patient_management.doctor_service;

import com.logrex.patient_management.doctorDTO.DoctorDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DoctorService {

    DoctorDTO getDoctorById(Long id);

    DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO);

    String updateAvailability(Long id, String status);

    String uploadProfilePicture(Long id, MultipartFile file);

    List<DoctorDTO> getAllDoctors();
}