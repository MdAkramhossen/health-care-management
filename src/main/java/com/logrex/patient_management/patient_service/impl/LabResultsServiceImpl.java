package com.logrex.patient_management.patient_service.impl;
import com.logrex.patient_management.exception.ResourceNotFoundException;
import com.logrex.patient_management.patient_DTO.LabResultDTO;
import com.logrex.patient_management.patient_entity.LabResult;
import com.logrex.patient_management.patient_entity.Patient;
import com.logrex.patient_management.patient_repository.LabResultsRepo;
import com.logrex.patient_management.patient_repository.PatientRepo;
import com.logrex.patient_management.patient_service.LabResultsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabResultsServiceImpl implements LabResultsService {

    private final ModelMapper modelMapper;
    private final LabResultsRepo labResultsRepo;
    private  final PatientRepo patientRepo;

    public LabResultsServiceImpl(ModelMapper modelMapper, LabResultsRepo labResultsRepo, PatientRepo patientRepo) {
        this.modelMapper = modelMapper;
        this.labResultsRepo = labResultsRepo;
        this.patientRepo = patientRepo;
    }
     @Transactional
    @Override
    public LabResultDTO addLabResultToPatient(Long patientId, LabResultDTO labResultDTO) {

        Patient patient = patientRepo.findById(patientId).orElseThrow(()->new ResourceNotFoundException("get","patient does not exist by the id",patientId));
        LabResult labResult = modelMapper.map(labResultDTO, LabResult.class);
        labResult.setPatient(patient);
        labResultsRepo.save(labResult);
        return modelMapper.map(labResult, LabResultDTO.class);
    }
     @Transactional
    @Override
    public List<LabResultDTO> getLabResultsByPatientId(Long patientId) {

        return labResultsRepo.findLabResultsByPatientId(patientId).stream().map((mapResult)-> modelMapper.map(mapResult,LabResultDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public LabResultDTO updateLabResultForPatient(Long labResultId, LabResultDTO labResultDTO) {

       // ********* i will get patient id that from security context*************
        Patient patient= patientRepo.findById(2L).orElseThrow( ()-> new ResourceNotFoundException("get","patient does not exist by the id",2L));
        LabResult labResult = labResultsRepo.findById(labResultId).orElseThrow(()-> new ResourceNotFoundException("get","lab result does not exist by the id",labResultId));
        labResult.setPatient(patient);
        labResult.setTestName(labResultDTO.getTestName());
        labResult.setOrderingProvider(labResultDTO.getOrderingProvider());
        labResult.setPerformingLaboratory(labResultDTO.getPerformingLaboratory());
        labResult.setReferenceRange(labResultDTO.getReferenceRange());
        labResult.setResultValues(labResultDTO.getResultValues());

        labResultsRepo.save(labResult);
        return modelMapper.map(labResult, LabResultDTO.class);

    }
  @Transactional
    @Override
    public void deleteLabResultFromPatient(Long labResultId) {

        // ********* i will get patient id that from security context*************
        Patient patient= patientRepo.findById(2L).orElseThrow( ()-> new ResourceNotFoundException("get","patient does not exist by the id",2L));
        LabResult labResult = labResultsRepo.findById(labResultId).orElseThrow(()-> new ResourceNotFoundException("get","lab result does not exist by the id",labResultId));
       labResultsRepo.delete(labResult);
    }
}
