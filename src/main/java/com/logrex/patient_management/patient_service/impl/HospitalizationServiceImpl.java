package com.logrex.patient_management.patient_service.impl;

import com.logrex.patient_management.exception.ResourceNotFoundException;
import com.logrex.patient_management.patient_DTO.HospitalizationDTO;
import com.logrex.patient_management.patient_DTO.PatientDTO;
import com.logrex.patient_management.patient_entity.Hospitalizations;
import com.logrex.patient_management.patient_entity.Patient;
import com.logrex.patient_management.patient_repository.HospitalizationRepo;
import com.logrex.patient_management.patient_repository.PatientRepo;
import com.logrex.patient_management.patient_service.HospitalizationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospitalizationServiceImpl implements HospitalizationService {

    private ModelMapper modelMapper;
    private HospitalizationRepo hospitalizationRepo;
    private PatientRepo patientRepo;

    public HospitalizationServiceImpl(ModelMapper modelMapper, HospitalizationRepo hospitalizationRepo, PatientRepo patientRepo) {
        this.modelMapper = modelMapper;
        this.hospitalizationRepo = hospitalizationRepo;
        this.patientRepo = patientRepo;
    }

    @Transactional
    @Override
    public HospitalizationDTO addHospitalizationToPatient(Long patientId, HospitalizationDTO hospitalizationDTO) {

        Patient patient = patientRepo.findById(patientId).orElseThrow(()-> new ResourceNotFoundException("get","patient did not found",patientId));
       Hospitalizations hospitalizations = modelMapper.map(hospitalizationDTO, Hospitalizations.class);
        hospitalizations.setPatient(patient);

       hospitalizationRepo.save(hospitalizations);
       return modelMapper.map(hospitalizations, HospitalizationDTO.class);


    }

    @Override
    public List<HospitalizationDTO> getHospitalizationsByPatientId(Long patientId) {

        return hospitalizationRepo.findByPatientId(patientId)
                .stream()
                .map(hospitalization -> modelMapper.map(hospitalization, HospitalizationDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public HospitalizationDTO updateHospitalizationForPatient(Long hospitalizationId, HospitalizationDTO hospitalizationDTO) {
        Hospitalizations hospitalizations= hospitalizationRepo.findById(hospitalizationId).orElseThrow(()-> new ResourceNotFoundException("get","hospitalization did not found",hospitalizationId));
        hospitalizations.setReasonForHospitalization(hospitalizationDTO.getReasonForHospitalization());
        hospitalizations.setAdmissionDate(hospitalizationDTO.getAdmissionDate());
        hospitalizations.setObservations(hospitalizationDTO.getObservations());
        hospitalizations.setDischargeDate(hospitalizationDTO.getDischargeDate());
        hospitalizations.setReasonForReferral(hospitalizationDTO.getReasonForReferral());
        hospitalizations.setReferredTo(hospitalizationDTO.getReferredTo());
         hospitalizations.setOutcomeOrComplications(hospitalizationDTO.getOutcomeOrComplications());
         hospitalizations.setReferredBy(hospitalizationDTO.getReferredBy());
         hospitalizationRepo.save(hospitalizations);
        return  modelMapper.map(hospitalizations, HospitalizationDTO.class);
    }
}
