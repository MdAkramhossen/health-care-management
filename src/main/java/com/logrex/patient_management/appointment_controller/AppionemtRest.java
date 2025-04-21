package com.logrex.patient_management.appointment_controller;

import com.logrex.patient_management.appointment_DTO.AppointmentDTO;
import com.logrex.patient_management.appointment_enums.AppointmentStatus;
import com.logrex.patient_management.appointment_service.AppointmentService;

import com.logrex.patient_management.patient_DTO.PatientDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/appointments")

public class AppionemtRest {


    private final AppointmentService appointmentService;

    public AppionemtRest(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentDTO dto) {
        AppointmentDTO saved = appointmentService.createAppointment(dto);
        return  new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> update(@PathVariable Long id, @RequestBody AppointmentDTO dto) {
        AppointmentDTO updated = appointmentService.updateAppointment(id, dto);
        return  new ResponseEntity<>(updated, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>("Appointment deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getById(@PathVariable Long id) {
        AppointmentDTO dto = appointmentService.getAppointmentById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAll() {
        List<AppointmentDTO> list = appointmentService.getAllAppointments();
       return new ResponseEntity<>(list, HttpStatus.OK);
    }



    @GetMapping("/status/{status}")
    public ResponseEntity<List<AppointmentDTO>> getByStatus(@PathVariable AppointmentStatus status){
        List<AppointmentDTO> list = appointmentService.getAppointmentsByStatus(status);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/range")
    public ResponseEntity<List<AppointmentDTO>> getByDateRange(
            @RequestParam ZonedDateTime start,
            @RequestParam ZonedDateTime end) {
        List<AppointmentDTO> list = appointmentService.getAppointmentsByDateRange(start, end);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<String> cancel(@PathVariable Long id, @RequestBody AppointmentDTO cancellationReason) {
        appointmentService.cancelAppointment(id, cancellationReason.getCancellationReason());
        return new ResponseEntity<>("Appointment cancelled successfully", HttpStatus.OK);
    }

    @GetMapping("/availability")
    public ResponseEntity<Boolean> checkAvailability(
            @RequestParam Long doctorId,
            @RequestParam ZonedDateTime start,
            @RequestParam ZonedDateTime end) {
        boolean available = appointmentService.isDoctorAvailable(doctorId, start, end);
        return new ResponseEntity<>(available, HttpStatus.OK);
    }

    @GetMapping("/doctor/{doctorId}/patients")
    public ResponseEntity<List<PatientDTO>> getPatientsByDoctorId(@PathVariable Long doctorId) {
        List<PatientDTO> patientList = appointmentService.getPatientsByDoctorId(doctorId);
        return ResponseEntity.ok(patientList);
    }


}
