package com.logrex.patient_management.doctorDTO;

import com.logrex.patient_management.appointment_entity.Appointment;

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
  private List<Appointment> appointments;
    public DoctorDTO() {
    }

    public DoctorDTO(Long doctorId, String fullName, String degrees, String certifications, String licenseNumber, String specialization, String hospitalAffiliation, String availabilityStatus, String profilePicture) {
        this.doctorId = doctorId;
        this.fullName = fullName;
        this.degrees = degrees;
        this.certifications = certifications;
        this.licenseNumber = licenseNumber;
        this.specialization = specialization;
        this.hospitalAffiliation = hospitalAffiliation;
        this.availabilityStatus = availabilityStatus;
        this.profilePicture = profilePicture;
    }

    public DoctorDTO(Long doctorId, String fullName, String degrees, String certifications, String licenseNumber, String specialization, String hospitalAffiliation, String availabilityStatus, String profilePicture, List<Appointment> appointments) {
        this.doctorId = doctorId;
        this.fullName = fullName;
        this.degrees = degrees;
        this.certifications = certifications;
        this.licenseNumber = licenseNumber;
        this.specialization = specialization;
        this.hospitalAffiliation = hospitalAffiliation;
        this.availabilityStatus = availabilityStatus;
        this.profilePicture = profilePicture;
        this.appointments = appointments;
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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}