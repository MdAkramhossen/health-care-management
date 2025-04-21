package com.logrex.patient_management.patient_service.impl;
import com.logrex.patient_management.patient_DTO.AllergyDTO;
import com.logrex.patient_management.patient_entity.Allergy;
import com.logrex.patient_management.patient_entity.Patient;
import com.logrex.patient_management.patient_enums.Severity;
import com.logrex.patient_management.exception.ResourceNotFoundException;
import com.logrex.patient_management.patient_repository.AllergyRepo;
import com.logrex.patient_management.patient_repository.PatientRepo;
import com.logrex.patient_management.patient_service.AllergyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AllergyServiceImpl implements AllergyService {


    private final AllergyRepo allergyRepo;
    private  final ModelMapper modelMapper;
    private final PatientRepo patientRepo;
    private static final Logger logger = LoggerFactory.getLogger(AllergyService.class);

    public AllergyServiceImpl(AllergyRepo allergyRepo, ModelMapper modelMapper, PatientRepo patientRepo) {
        this.allergyRepo = allergyRepo;
        this.modelMapper = modelMapper;
        this.patientRepo = patientRepo;
    }

    @Transactional
    @Override
    public AllergyDTO addAllergyToPatient(AllergyDTO allergyDTO) {

        //// here is currect user id that will fetch by id///

        Long patientId= 1L;
        Allergy allergy = modelMapper.map(allergyDTO, Allergy.class);
        Patient patient= patientRepo.findById(patientId).orElseThrow(()-> new ResourceNotFoundException("get","patient does not exist by the id",patientId));
        allergy.setPatient(patient);
        allergy.setOnsetDate(new Date());
        allergy.setSeverity(Severity.SEVERE);
        allergyRepo.save(allergy);

        return modelMapper.map(allergy, AllergyDTO.class);
    }

  @Transactional
    @Override
    public List<AllergyDTO> getAllergiesByPatientId() {

      //// here is currect user id that will fetch by id///

      Long patientId= 1L;
      Patient patient=patientRepo.findById(patientId).orElseThrow(()-> new ResourceNotFoundException("get","patient does not exist by the id",patientId));
      List <Allergy> allergies= allergyRepo.findAllByPatientId(patient.getId());

      return allergies.stream()
              .map(allergy -> modelMapper.map(allergy, AllergyDTO.class))
              .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public AllergyDTO updateAllergyForPatient(AllergyDTO allergyDTO, Long id) {


        Allergy allergy= allergyRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("get","allergy does not exist by the id",id));
        allergy.setAllergenName(allergyDTO.getAllergenName());
        allergy.setReactionType(allergyDTO.getReactionType());
        allergy.setNotes(allergyDTO.getNotes());
        allergy.setSeverity(Severity.MILD);
        allergy.setOnsetDate(new Date());
        allergyRepo.save(allergy);
        return  modelMapper.map(allergy, AllergyDTO.class);
    }

    @Transactional
    @Override
    public void deleteAllergyFromPatient(Long id) {

        Allergy allergy= allergyRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("get","allergy does not exist by the id",id));

        allergyRepo.delete(allergy);

    }
}
