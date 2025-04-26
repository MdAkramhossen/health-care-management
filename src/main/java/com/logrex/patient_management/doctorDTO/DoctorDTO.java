package com.logrex.patient_management.doctorDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.logrex.patient_management.appointment_DTO.AppointmentDTO;
import com.logrex.patient_management.appointment_entity.Appointment;
import com.logrex.patient_management.patient_DTO.PatientDTO;
import com.logrex.patient_management.patient_DTO.PrescriptionDTO;

import java.util.List;

public class DoctorDTO {

    private Long doctorId;
    private String fullName;
    private String degrees;
    private String certifications;
    private String licenseNumber;
    private String specialization;
    private String hospitalAffiliation;
    private String availabilityStatus;
    private String profilePicture;
    @JsonIgnore
    private List<AppointmentDTO> appointmentDTOs;
    @JsonIgnore
    private List<PrescriptionDTO> prescriptions;
    public DoctorDTO() {
    }

    public DoctorDTO(Long doctorId, String fullName, String degrees, String certifications, String licenseNumber, String specialization, String hospitalAffiliation, String availabilityStatus, String profilePicture, List<AppointmentDTO> appointmentDTOs, List<PrescriptionDTO> prescriptions) {
        this.doctorId = doctorId;
        this.fullName = fullName;
        this.degrees = degrees;
        this.certifications = certifications;
        this.licenseNumber = licenseNumber;
        this.specialization = specialization;
        this.hospitalAffiliation = hospitalAffiliation;
        this.availabilityStatus = availabilityStatus;
        this.profilePicture = profilePicture;
        this.appointmentDTOs = appointmentDTOs;
        this.prescriptions = prescriptions;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getHospitalAffiliation() {
        return hospitalAffiliation;
    }

    public void setHospitalAffiliation(String hospitalAffiliation) {
        this.hospitalAffiliation = hospitalAffiliation;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<AppointmentDTO> getAppointmentDTOs() {
        return appointmentDTOs;
    }

    public void setAppointmentDTOs(List<AppointmentDTO> appointmentDTOs) {
        this.appointmentDTOs = appointmentDTOs;
    }

    public List<PrescriptionDTO> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<PrescriptionDTO> prescriptions) {
        this.prescriptions = prescriptions;
    }
}