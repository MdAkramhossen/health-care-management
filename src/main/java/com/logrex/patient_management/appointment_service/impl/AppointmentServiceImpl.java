package com.logrex.patient_management.appointment_service.impl;

import com.logrex.patient_management.appointment_DTO.AppointmentDTO;
import com.logrex.patient_management.appointment_entity.Appointment;
import com.logrex.patient_management.appointment_enums.AppointmentStatus;
import com.logrex.patient_management.appointment_jpa.AppointmentRepository;
import com.logrex.patient_management.appointment_service.AppointmentService;
import com.logrex.patient_management.appoinment_email_service.EmailService;
import com.logrex.patient_management.doctor_entity.Doctor;
import com.logrex.patient_management.doctor_repo.DoctorRepository;
import com.logrex.patient_management.exception.ResourceNotFoundException;
import com.logrex.patient_management.patient_DTO.PatientDTO;
import com.logrex.patient_management.patient_entity.Patient;
import com.logrex.patient_management.patient_repository.PatientRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    private ModelMapper modelMapper;

    private EmailService emailService;
 private PatientRepo patientRepo;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, ModelMapper modelMapper, EmailService emailService, PatientRepo patientRepo, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.modelMapper = modelMapper;
        this.emailService = emailService;
        this.patientRepo = patientRepo;
        this.doctorRepository = doctorRepository;
    }
/////////************** here i have to change exception of all not found resources*********************
    @Override
    @Transactional
    public AppointmentDTO createAppointment(AppointmentDTO dto) {

        Appointment appointment = new Appointment();
        Long patientID = 2L;
      Patient patient = patientRepo.findById(patientID).orElseThrow(()->new ResourceNotFoundException("create","Patient not found with id: ",patientID));

        Doctor doctor= doctorRepository.findById(dto.getDoctorId()).orElseThrow(()->new ResourceNotFoundException("create","Doctor not found with id: ", dto.getDoctorId()));

        if (appointment.getStatus() == AppointmentStatus.SCHEDULED) {

            emailService.sendAppointmentScheduledEmail(
                    patient.getEmail(),
                    patient.getFullName(),
                   dto.getEndTime()
            );
        }
     appointment.setLocation(dto.getLocation());
     appointment.setNotes(dto.getNotes());
     appointment.setAppointmentType(dto.getAppointmentType());
     appointment.setEndTime(dto.getEndTime());
     appointment.setEndTime(dto.getEndTime());
     appointment.setLocation(dto.getLocation());
     appointment.setCancellationReason(dto.getCancellationReason());
     appointment.setStatus(dto.getStatus());
      appointment.setPatient(patient);
      appointment.setDoctor(doctor);
      appointmentRepository.save(appointment);

        return  modelMapper.map(appointment, AppointmentDTO.class);
    }

    @Override
    public AppointmentDTO updateAppointment(Long appointmentId, AppointmentDTO dto) {
        Appointment existing = appointmentRepository.findById(appointmentId)
                //blog exception will attach
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        Appointment appointment = modelMapper.map(dto, Appointment.class);
       appointment.setAppointmentId(appointmentId);
       appointmentRepository.save(appointment);
       return modelMapper.map(appointment, AppointmentDTO.class);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public AppointmentDTO getAppointmentById(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        return modelMapper.map(appointment, AppointmentDTO.class);
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
     List<Appointment> appointments = appointmentRepository.findAll();
     return appointments.stream().map(appointment -> modelMapper.map(appointment, AppointmentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByStatus(AppointmentStatus status) {
        List<Appointment> appointments= appointmentRepository.findByStatus(status);
      return appointments.stream().map(appointment -> modelMapper.map(appointment, AppointmentDTO.class)).collect(Collectors.toList());
    }


    @Override
    public List<AppointmentDTO> getAppointmentsByDateRange(ZonedDateTime start, ZonedDateTime end) {
        List<Appointment> appointments= appointmentRepository.findByStartTimeBetween(start, end);
       return appointments.stream().map(appointment -> modelMapper.map(appointment, AppointmentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void cancelAppointment(Long appointmentId, String reason) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setCancellationReason(reason);
        appointment.setStatus(AppointmentStatus.CANCELED);
       appointmentRepository.save(appointment);
    }
///////// Bug fixing ///////////

    @Override
    public boolean isDoctorAvailable(Long doctorId, ZonedDateTime startTime, ZonedDateTime endTime) {

         return false;
    }

    @Override
    public List<PatientDTO> getPatientsByDoctorId(Long doctorId) {
        return appointmentRepository.findDistinctByDoctorId(doctorId).stream().map(appointment -> modelMapper.map(appointment, PatientDTO.class)).collect(Collectors.toList());
    }


}
