package com.logrex.patient_management.patient_service.impl;

import com.logrex.patient_management.exception.ResourceNotFoundException;
import com.logrex.patient_management.patient_DTO.ChronicConditionsDTO;
import com.logrex.patient_management.patient_DTO.PatientDTO;
import com.logrex.patient_management.patient_entity.ChronicConditions;
import com.logrex.patient_management.patient_entity.Patient;
import com.logrex.patient_management.patient_repository.ChoronicRepo;
import com.logrex.patient_management.patient_repository.PatientRepo;
import com.logrex.patient_management.patient_service.ChronicConditionsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChronicConditionsImpl implements ChronicConditionsService {

  private   PatientRepo patientRepo;
  private ModelMapper modelMapper;
  private ChoronicRepo choronicRepo;

    public ChronicConditionsImpl(PatientRepo patientRepo, ModelMapper modelMapper, ChoronicRepo choronicRepo) {
        this.patientRepo = patientRepo;
        this.modelMapper = modelMapper;
        this.choronicRepo = choronicRepo;
    }

    @Transactional
    @Override
    public ChronicConditionsDTO addChronicConditionToPatient(ChronicConditionsDTO chronicConditionsDTO, Long patientId) {
        Patient existingPatient= patientRepo.findById(patientId).orElseThrow(()->new ResourceNotFoundException("update","Patient not found with id: ",patientId));
        ChronicConditions chronicConditions= modelMapper.map(chronicConditionsDTO, ChronicConditions.class);
        chronicConditions.setPatient(existingPatient);
        choronicRepo.save(chronicConditions);
      return modelMapper.map(chronicConditions, ChronicConditionsDTO.class);
    }
    @Transactional
    @Override
    public List<ChronicConditionsDTO> getChronicConditionsByPatientId(Long patientId) {

        return choronicRepo.findByPatientId(patientId).stream().map(chronicConditions -> modelMapper.map(chronicConditions,ChronicConditionsDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ChronicConditionsDTO updateChronicConditionForPatient(Long conditionId, ChronicConditionsDTO chronicConditionsDTO) {
        ChronicConditions chronicConditions=choronicRepo.findById(conditionId).orElseThrow(()->new ResourceNotFoundException("update","Chronic condition not found with id: ",conditionId));
         chronicConditions.setConditionName(chronicConditionsDTO.getConditionName());
         chronicConditions.setCurrentStatus(chronicConditionsDTO.getCurrentStatus());
         chronicConditions.setDiagnosisDate(chronicConditionsDTO.getDiagnosisDate());
         chronicConditions.setSeverityStage(chronicConditionsDTO.getSeverityStage());
         chronicConditions.setTreatmentPlan(chronicConditionsDTO.getTreatmentPlan());
         choronicRepo.save(chronicConditions);
        return modelMapper.map(chronicConditions, ChronicConditionsDTO.class);
    }
}
