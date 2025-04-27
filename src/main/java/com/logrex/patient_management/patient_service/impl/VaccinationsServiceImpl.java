package com.logrex.patient_management.patient_service.impl;

import com.logrex.patient_management.exception.ResourceNotFoundException;
import com.logrex.patient_management.patient_DTO.PatientDTO;
import com.logrex.patient_management.patient_DTO.VaccinationRecordDTO;
import com.logrex.patient_management.patient_entity.Patient;
import com.logrex.patient_management.patient_entity.VaccinationRecord;
import com.logrex.patient_management.patient_repository.PatientRepo;
import com.logrex.patient_management.patient_repository.VaccinationRepo;
import com.logrex.patient_management.patient_service.VaccinationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VaccinationsServiceImpl implements VaccinationService {

    private  final VaccinationRepo vaccinationRepo;
    private  final PatientRepo patientRepo;
    private  final ModelMapper modelMapper;

    public VaccinationsServiceImpl(VaccinationRepo vaccinationRepo, PatientRepo patientRepo, ModelMapper modelMapper) {
        this.vaccinationRepo = vaccinationRepo;
        this.patientRepo = patientRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public VaccinationRecordDTO createVaccination(VaccinationRecordDTO vaccinationDTO) {

        VaccinationRecord record = modelMapper.map(vaccinationDTO, VaccinationRecord.class);
        VaccinationRecord savedRecord = vaccinationRepo.save(record);
        return modelMapper.map(savedRecord, VaccinationRecordDTO.class);
    }

    @Override
    public List<VaccinationRecordDTO> getAllVaccinations() {
        List<VaccinationRecord> records = vaccinationRepo.findAll();

        return records.stream().map((record)-> modelMapper.map(record, VaccinationRecordDTO.class)).collect(Collectors.toList());
    }

    @Override
    public VaccinationRecordDTO getVaccinationById(Long vaccinationId) {
        return modelMapper.map(vaccinationRepo.findById(vaccinationId), VaccinationRecordDTO.class);
    }

    @Override
    public VaccinationRecordDTO updateVaccination(Long vaccinationId, VaccinationRecordDTO vaccinationDTO) {
        VaccinationRecord record = vaccinationRepo.findById(vaccinationId).orElseThrow(()-> new ResourceNotFoundException("getVaccinationById", "id", vaccinationId));
        record.setVaccineName(vaccinationDTO.getVaccineName());
        record.setAdministeringProvider(vaccinationDTO.getAdministeringProvider());
        record.setDosageFormulation(vaccinationDTO.getDosageFormulation());
        record.setLotNumber(vaccinationDTO.getLotNumber());
        vaccinationRepo.save(record);
        return modelMapper.map(record, VaccinationRecordDTO.class);
    }

    @Override
    public void deleteVaccination(Long vaccinationId) {
        VaccinationRecord record = vaccinationRepo.findById(vaccinationId).orElseThrow(()-> new ResourceNotFoundException("getVaccinationById", "id", vaccinationId));
        vaccinationRepo.delete(record);

    }
    @Transactional(readOnly = true)
    @Override
    public List<PatientDTO> getPatientsByVaccinationId(Long vaccinationId) {
        VaccinationRecord record = vaccinationRepo.findById(vaccinationId)
                .orElseThrow(() -> new ResourceNotFoundException("getVaccinationById", "id", vaccinationId));
        List<Patient> patients = record.getPatients();
        return patients.stream()
                .map(patient -> modelMapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void addPatientToVaccination(Long vaccinationId, Long patientId) {
        VaccinationRecord record = vaccinationRepo.findById(vaccinationId).orElseThrow(()-> new ResourceNotFoundException("getVaccinationById", "id", vaccinationId));
        Patient patient= patientRepo.findById(patientId).orElseThrow(()-> new ResourceNotFoundException("getPatientById", "id", patientId));

       record.getPatients().add(patient);
      patient.getVaccinationRecords().add(record);
        vaccinationRepo.save(record);
        patientRepo.save(patient);
    }
    @Transactional
    @Override
    public void removePatientFromVaccination(Long vaccinationId, Long patientId) {

        VaccinationRecord record = vaccinationRepo.findById(vaccinationId).orElseThrow(()-> new ResourceNotFoundException("getVaccinationById", "id", vaccinationId));
        Patient patient= patientRepo.findById(patientId).orElseThrow(()-> new ResourceNotFoundException("getPatientById", "id", patientId));
        record.getPatients().remove(patient);
        patient.getVaccinationRecords().remove(record);
        vaccinationRepo.save(record);
        patientRepo.save(patient);
    }
}
