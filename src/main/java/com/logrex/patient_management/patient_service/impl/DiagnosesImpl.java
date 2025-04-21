package com.logrex.patient_management.patient_service.impl;

import com.logrex.patient_management.patient_DTO.DiagnosisDTO;
import com.logrex.patient_management.patient_entity.Diagnosis;
import com.logrex.patient_management.patient_entity.Patient;
import com.logrex.patient_management.exception.ResourceNotFoundException;
import com.logrex.patient_management.patient_repository.DiagnosesRepo;
import com.logrex.patient_management.patient_repository.PatientRepo;
import com.logrex.patient_management.patient_service.DiagnosesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiagnosesImpl implements DiagnosesService {

    private final DiagnosesRepo diagnosesRepo;
    private final ModelMapper modelMapper;
   private final PatientRepo patientRepo;
    public DiagnosesImpl(DiagnosesRepo diagnosesRepo, ModelMapper modelMapper, PatientRepo patientRepo) {
        this.diagnosesRepo = diagnosesRepo;
        this.modelMapper = modelMapper;
        this.patientRepo = patientRepo;
    }

    @Transactional
    @Override
    public DiagnosisDTO addDiagnosisToPatient(DiagnosisDTO diagnosisDTO) {

        Long id =1L;
        Patient patient =patientRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("save patient","this user are not exist",id));
        Diagnosis diagnosis =modelMapper.map(diagnosisDTO, Diagnosis.class);
        diagnosis.setDiagnosisDate(new Date());
        diagnosis.setPatient(patient);
        diagnosesRepo.save(diagnosis);
        return modelMapper.map(diagnosis, DiagnosisDTO.class);
    }

    @Transactional
    @Override
    public List<DiagnosisDTO> getAllDiagnosesByPatientId() {
        Long id =1L;
        Patient patient =patientRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("save patient","this user are not exist",id));
        List<Diagnosis> diagnoses= diagnosesRepo.findByPatientId( patient.getId());
        return  diagnoses.stream().map(diagnosis -> modelMapper.map(diagnosis,DiagnosisDTO.class)).collect(Collectors.toList());
    }



    @Transactional
    @Override
    public DiagnosisDTO updateDiagnosisForPatient(DiagnosisDTO diagnosisDTO, Long id) {

        Diagnosis diagnosis=diagnosesRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("save patient","this user are not exist",id));

        diagnosis.setDiagnosisName(diagnosisDTO.getDiagnosisName());
        diagnosis.setNotes(diagnosisDTO.getNotes());
        diagnosis.setSeverityStage(diagnosisDTO.getSeverityStage());
        diagnosesRepo.save(diagnosis);
        return modelMapper.map(diagnosis, DiagnosisDTO.class);
    }
    @Transactional
    @Override
    public void deleteDiagnosisFromPatient(Long id) {

        Diagnosis diagnosis= diagnosesRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("save patient","this user are not exist",id));
        diagnosesRepo.delete(diagnosis);

    }


}
