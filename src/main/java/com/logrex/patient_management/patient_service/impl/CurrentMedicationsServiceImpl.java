package com.logrex.patient_management.patient_service.impl;

import com.logrex.patient_management.patient_DTO.CurrentMedicationsDTO;
import com.logrex.patient_management.patient_entity.CurrentMedications;
import com.logrex.patient_management.exception.ResourceNotFoundException;
import com.logrex.patient_management.patient_repository.MedicationRepo;
import com.logrex.patient_management.patient_service.CurrentMedicationsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrentMedicationsServiceImpl implements CurrentMedicationsService {

   private  final   MedicationRepo medicationRepo;
   private  final ModelMapper modelMapper;


    public CurrentMedicationsServiceImpl(MedicationRepo medicationRepo, ModelMapper modelMapper) {
        this.medicationRepo = medicationRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CurrentMedicationsDTO addMedicationToPatient(CurrentMedicationsDTO currentMedicationsDTO) {

        CurrentMedications medications = modelMapper.map(currentMedicationsDTO, CurrentMedications.class);
        medicationRepo.save(medications);
        return modelMapper.map(medications, CurrentMedicationsDTO.class);
    }

    @Override
    public CurrentMedicationsDTO getCurrentMedicationsByPatientId() {
//        Long patientId = 1l;
//
//        CurrentMedications currentMedications = medicationRepo.findMedicationsByPatientId(patientId);
        return null;
    }

    @Override
    public List<CurrentMedicationsDTO> getAllCurrentMedicationsByPatientId() {
        Long patientId = 1l;
        List<CurrentMedications> getAllMedications= medicationRepo.findMedicationsByPatientId(patientId);

        return   getAllMedications.stream().map(currentMedications -> modelMapper.map(currentMedications,CurrentMedicationsDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CurrentMedicationsDTO updateMedicationForPatient(CurrentMedicationsDTO currentMedicationsDTO, Long id) {

        CurrentMedications currentMedications= medicationRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("get","medication not exist on this id",id));
        return modelMapper.map(currentMedicationsDTO, CurrentMedicationsDTO.class);
    }

    @Override
    public void deleteMedicationFromPatient(Long id) {

        CurrentMedications currentMedications= medicationRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("get","medication not exist on this id",id));
        medicationRepo.delete(currentMedications);
    }
}
