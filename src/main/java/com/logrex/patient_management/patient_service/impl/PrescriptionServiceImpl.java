package com.logrex.patient_management.patient_service.impl;

import com.logrex.patient_management.doctor_entity.Doctor;
import com.logrex.patient_management.doctor_repo.DoctorRepository;
import com.logrex.patient_management.exception.ResourceNotFoundException;
import com.logrex.patient_management.patient_DTO.PrescriptionDTO;
import com.logrex.patient_management.patient_entity.Patient;
import com.logrex.patient_management.patient_entity.Prescription;
import com.logrex.patient_management.patient_enums.PrescriptionStatus;
import com.logrex.patient_management.patient_repository.PatientRepo;
import com.logrex.patient_management.patient_repository.PrescriptionRepo;
import com.logrex.patient_management.patient_service.PrescriptionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private  final PatientRepo  patientRepo;
    private  final ModelMapper modelMapper;
    private  final PrescriptionRepo prescriptionRepo;
    private  final DoctorRepository doctorRepo;

    public PrescriptionServiceImpl(PatientRepo patientRepo, ModelMapper modelMapper, PrescriptionRepo prescriptionRepo, DoctorRepository doctorRepo) {
        this.patientRepo = patientRepo;
        this.modelMapper = modelMapper;
        this.prescriptionRepo = prescriptionRepo;
        this.doctorRepo = doctorRepo;
    }


    @Transactional
    @Override
    public void cancelPrescription(Long patientId, Long prescriptionId) {

        Prescription prescription = prescriptionRepo.findById(prescriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription", "id", prescriptionId));

        Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", patientId));
        prescription.setStatus(PrescriptionStatus.CANCELED);

    }


    @Transactional
    @Override
    public PrescriptionDTO updatePrescription(Long patientId, Long prescriptionId, PrescriptionDTO prescriptionDTO) {
        Patient patient = patientRepo.findById(patientId).orElseThrow(()-> new ResourceNotFoundException("get","Patient",patientId));
        Doctor doctor= doctorRepo.findById(1L).orElseThrow(()-> new ResourceNotFoundException("get","Doctor",1L));
        Prescription prescription = prescriptionRepo.findById(patientId).orElseThrow(()-> new ResourceNotFoundException("get","Prescription",1L));
        prescription.setPatient(patient);
        prescription.setDoctor(doctor);
        prescription.setDosage(prescriptionDTO.getDosage());
        prescription.setDuration(prescriptionDTO.getDuration());
        prescription.setGenericAllowed(prescriptionDTO.getGenericAllowed());
        prescription.setDuration(prescriptionDTO.getDuration());
        prescription.setFrequency(prescriptionDTO.getFrequency());
        prescription.setInstructions(prescriptionDTO.getInstructions());
        prescription.setInteractionWarnings(prescriptionDTO.getInteractionWarnings());
        prescription.setMedicationName(prescriptionDTO.getMedicationName());
        prescriptionRepo.save(prescription);
        return modelMapper.map(prescription, PrescriptionDTO.class);
    }

    @Transactional
    @Override
    public List<PrescriptionDTO> getActivePrescriptions(Long patientId) {

        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("get","Patient",patientId));
        List<Prescription> activePrescriptions = prescriptionRepo.findByPatientIdAndStatus(patientId, PrescriptionStatus.ACTIVE);
        return activePrescriptions.stream().map((active)-> modelMapper.map(active,PrescriptionDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public PrescriptionDTO createPrescription(Long patientId, PrescriptionDTO prescriptionDTO) {
        Patient patient = patientRepo.findById(patientId).orElseThrow(()-> new ResourceNotFoundException("get","Patient",patientId));
        Doctor doctor= doctorRepo.findById(1L).orElseThrow(()-> new ResourceNotFoundException("get","Doctor",1L));
        Prescription prescription = modelMapper.map(prescriptionDTO, Prescription.class);
          prescription.setPatient(patient);
          prescription.setDoctor(doctor);
          prescriptionRepo.save(prescription);
        return modelMapper.map(prescription, PrescriptionDTO.class);
 }
}
