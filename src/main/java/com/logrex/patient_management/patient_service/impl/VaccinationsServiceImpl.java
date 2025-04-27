package com.logrex.patient_management.patient_service.impl;

import com.logrex.patient_management.exception.ResourceNotFoundException;
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

    @Transactional
    @Override
    public List<VaccinationRecordDTO> createcreateVaccination(List<VaccinationRecordDTO> vaccinationRecordDTO) {

        List<VaccinationRecord> vaccinationRecords= vaccinationRecordDTO.stream().map(s->modelMapper.map(s, VaccinationRecord.class)).collect(Collectors.toList());
        System.out.println(vaccinationRecords.get(0).getVaccineName());
        vaccinationRepo.saveAll(vaccinationRecords);

        return vaccinationRecords.stream().map(s->modelMapper.map(s,VaccinationRecordDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public VaccinationRecordDTO addVaccinationRecordToPatient(VaccinationRecordDTO vaccinationRecordDTO) {
        VaccinationRecord vaccinationRecord= modelMapper.map(vaccinationRecordDTO, VaccinationRecord.class);
       // vaccinationRepo.save(vaccinationRecord);
        return modelMapper.map(vaccinationRecord, VaccinationRecordDTO.class);
    }

    @Transactional
    @Override
    public List<VaccinationRecordDTO> getAllVaccinationRecordsByPatientId() {

          Long id=1L;
          Patient patient=patientRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("get","this user are not exist with id",id));
            List<VaccinationRecord> vaccinationRecords= vaccinationRepo.findAllByPatientId(patient.getId());
        return vaccinationRecords.stream().map(vaccin->modelMapper.map(vaccin,VaccinationRecordDTO.class)).collect(Collectors.toList());
    }
     @Transactional
    @Override
    public VaccinationRecordDTO updateVaccinationRecordForPatient(VaccinationRecordDTO vaccinationRecord, Long id) {

        VaccinationRecord updateVaccinationRecord=vaccinationRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("get","this user are not exist with id",id));

        return modelMapper.map(updateVaccinationRecord, VaccinationRecordDTO.class);
    }

    @Transactional
    @Override
    public void deleteVaccinationRecordFromPatient(Long id) {
        VaccinationRecord updateVaccinationRecord=vaccinationRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("get","this user are not exist with id",id));
        vaccinationRepo.delete(updateVaccinationRecord);

    }


}
