package com.logrex.patient_management.doctor_service.impl;

import com.logrex.patient_management.doctorDTO.DoctorDTO;
import com.logrex.patient_management.doctor_entity.Doctor;
import com.logrex.patient_management.doctor_repo.DoctorRepository;
import com.logrex.patient_management.doctor_service.DoctorService;
import com.logrex.patient_management.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    @Override
    public DoctorDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor not found", "id", id));
        return modelMapper.map(doctor, DoctorDTO.class);
    }
    @Transactional
    @Override
    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor not found", "id", id));

        doctor.setFullName(doctorDTO.getFullName());
        doctor.setDegrees(doctorDTO.getDegrees());
        doctor.setCertifications(doctorDTO.getCertifications());
        doctor.setLicenseNumber(doctorDTO.getLicenseNumber());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setHospitalAffiliation(doctorDTO.getHospitalAffiliation());

        Doctor updated = doctorRepository.save(doctor);
        return modelMapper.map(updated, DoctorDTO.class);
    }

    @Override
    public String updateAvailability(Long id, String status) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor not found", "id", id));
        doctor.setAvailabilityStatus(status);
        doctorRepository.save(doctor);
        return "Doctor availability updated to " + status;
    }
    @Transactional
    @Override
    public String uploadProfilePicture(Long id, MultipartFile file) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found", "id", id));

        // Define upload directory
        String uploadDir = "uploads/doctors/";
        String originalFilename = file.getOriginalFilename();
        String filePath = uploadDir + UUID.randomUUID() + "_" + originalFilename;

        try {
            // Create directories if they don't exist
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Save file
            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }

        // Update doctor's profile picture path
        doctor.setProfilePicture(filePath);
        doctorRepository.save(doctor);

        return filePath;
    }
 @Transactional
    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDTO.class))
                .collect(Collectors.toList());
    }
}