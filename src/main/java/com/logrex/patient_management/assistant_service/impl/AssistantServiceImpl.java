package com.logrex.patient_management.assistant_service.impl;

import com.logrex.patient_management.assistantDTO.AssistantDTO;
import com.logrex.patient_management.assistant_entity.Assistant;
import com.logrex.patient_management.assistant_repo.AssistantRepository;
import com.logrex.patient_management.assistant_service.AssistantService;
import com.logrex.patient_management.doctor_entity.Doctor;
import com.logrex.patient_management.doctor_repo.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssistantServiceImpl implements AssistantService {


    private AssistantRepository assistantRepo;

    private DoctorRepository doctorRepo;
    private ModelMapper modelMapper;

    public AssistantServiceImpl(AssistantRepository assistantRepo, DoctorRepository doctorRepo, ModelMapper modelMapper) {
        this.assistantRepo = assistantRepo;
        this.doctorRepo = doctorRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public AssistantDTO createAssistant(AssistantDTO dto) {
        Doctor doctor = doctorRepo.findById(dto.getLinkedDoctorId()).orElseThrow(() -> new RuntimeException("Doctor not found"));

        Assistant assistant = modelMapper.map(dto, Assistant.class);
        assistant.setLinkedDoctor(doctor);

        return modelMapper.map(assistantRepo.save(assistant), AssistantDTO.class);
    }

    @Override
    public AssistantDTO updateAssistant(Long id, AssistantDTO dto) {
        Assistant assistant = assistantRepo.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));

        assistant.setFullName(dto.getFullName());
        assistant.setRole(dto.getRole());
        assistant.setCertifications(dto.getCertifications());
        assistant.setProfilePicture(dto.getProfilePicture());

        if (dto.getLinkedDoctorId() != null) {
            Doctor doctor = doctorRepo.findById(dto.getLinkedDoctorId()).orElseThrow(() -> new RuntimeException("Doctor not found"));
            assistant.setLinkedDoctor(doctor);
        }

        return modelMapper.map(assistantRepo.save(assistant), AssistantDTO.class);
    }

    @Override
    public void deleteAssistant(Long id) {
        assistantRepo.deleteById(id);
    }

    @Override
    public AssistantDTO getAssistantById(Long id) {
        Assistant assistant = assistantRepo.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        return modelMapper.map(assistant, AssistantDTO.class);
    }

    @Override
    public List<AssistantDTO> getAllAssistants() {



        return assistantRepo.findAll().stream()
                .map(a -> modelMapper.map(a, AssistantDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AssistantDTO> getAssistantsByDoctorId(Long doctorId) {
        return assistantRepo.findByLinkedDoctorId(doctorId).stream()
                .map(a -> modelMapper.map(a, AssistantDTO.class))
                .collect(Collectors.toList());
    }
}
