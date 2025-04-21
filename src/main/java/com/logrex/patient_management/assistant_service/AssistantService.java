package com.logrex.patient_management.assistant_service;


import com.logrex.patient_management.assistantDTO.AssistantDTO;

import java.util.List;

public interface AssistantService {

    AssistantDTO createAssistant(AssistantDTO assistantDTO);

    AssistantDTO updateAssistant(Long id, AssistantDTO assistantDTO);

    void deleteAssistant(Long id);

    AssistantDTO getAssistantById(Long id);

    List<AssistantDTO> getAllAssistants();

    List<AssistantDTO> getAssistantsByDoctorId(Long doctorId);
}