package com.logrex.patient_management.patient_service.impl;

import com.logrex.patient_management.patient_DTO.PatientDTO;
import com.logrex.patient_management.patient_DTO.PatientResponse;
import com.logrex.patient_management.patient_entity.Patient;
import com.logrex.patient_management.exception.ResourceNotFoundException;
import com.logrex.patient_management.patient_repository.PatientRepo;
import com.logrex.patient_management.patient_service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatinetServiceImpl implements PatientService {


    private final PatientRepo patientRepo;
    private  final ModelMapper modelMapper;

    public PatinetServiceImpl(PatientRepo patientRepo, ModelMapper modelMapper) {
        this.patientRepo = patientRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient =modelMapper.map(patientDTO, Patient.class);

        patientRepo.save(patient);
        return modelMapper.map(patient, PatientDTO.class);
    }

    @Transactional
    @Override
    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {

        Patient existingPatient= patientRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("update","Patient not found with id: ",id));


         existingPatient.setFullName(patientDTO.getFullName());
         existingPatient.setGender(patientDTO.getGender());
         existingPatient.setAddress(patientDTO.getAddress());
         existingPatient.setAge(patientDTO.getAge());

        existingPatient.setPhoneNumber(patientDTO.getPhoneNumber());
        patientRepo.save(existingPatient);

        return modelMapper.map(existingPatient, PatientDTO.class);
    }

    @Transactional
    @Override
    public void deletePatient(Long id) {

        Patient patient = patientRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("delete","Patient not found with id: ",id));
        patientRepo.delete(patient);
    }
    @Transactional
    @Override
    public PatientDTO getPatientById(Long id) {
        Patient patient=patientRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("getPatient","Patient not found with id: ",id));

        return modelMapper.map(patient, PatientDTO.class);
    }

    @Transactional
    @Override
    public PatientDTO checkPatientExists(String email, String phone) {
        if ((email == null || email.isEmpty()) && (phone == null || phone.isEmpty())) {
            throw new IllegalArgumentException("Either email or phone number must be provided.");
        }

        Patient patient = patientRepo.findByEmailOrPhone(email, phone)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "email/phone", email + " / " + phone));

        return modelMapper.map(patient, PatientDTO.class);
    }

    @Transactional
    @Override
    public PatientResponse getAllPatients(int pageNo, int size, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

        Pageable pageable= PageRequest.of(pageNo,size,sort);
        Page<Patient> patients = patientRepo.findAll(pageable);

        List<PatientDTO> content=patients.stream().map((patient -> {
            return modelMapper.map(patient, PatientDTO.class);
        })).collect(Collectors.toList());
        PatientResponse patientResponse= new PatientResponse();
        patientResponse.setPatients(content);
        patientResponse.setPageNo(patients.getTotalPages());
        patientResponse.setPageSize(patients.getSize());
        patientResponse.setTotalElements(patients.getTotalElements());
        patientResponse.setTotalPages(patients.getTotalPages());
        patientResponse.setLast(patients.isLast());
        return patientResponse;
    }

}
