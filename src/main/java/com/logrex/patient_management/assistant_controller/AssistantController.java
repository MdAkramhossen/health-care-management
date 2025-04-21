package com.logrex.patient_management.assistant_controller;

import com.logrex.patient_management.assistantDTO.AssistantDTO;
import com.logrex.patient_management.assistant_service.AssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assistants")
public class AssistantController {

    @Autowired
    private AssistantService assistantService;

    @PostMapping
    public ResponseEntity<AssistantDTO> createAssistant(@RequestBody AssistantDTO dto) {
        return new ResponseEntity<>(assistantService.createAssistant(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssistantDTO> updateAssistant(@PathVariable Long id, @RequestBody AssistantDTO dto) {
        return  new ResponseEntity<>(assistantService.updateAssistant(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAssistant(@PathVariable Long id) {
        assistantService.deleteAssistant(id);
        return new ResponseEntity<>("Sucessfully deleted ! ",HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssistantDTO> getAssistant(@PathVariable Long id) {
        return new ResponseEntity<>(assistantService.getAssistantById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AssistantDTO>> getAllAssistants() {
        return  new ResponseEntity<>(assistantService.getAllAssistants(), HttpStatus.OK);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AssistantDTO>> getAssistantsByDoctor(@PathVariable Long doctorId) {
        return new ResponseEntity<>(assistantService.getAssistantsByDoctorId(doctorId), HttpStatus.OK);
    }
}