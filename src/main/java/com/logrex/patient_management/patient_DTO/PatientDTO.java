package com.logrex.patient_management.patient_DTO;

import com.logrex.patient_management.appointment_entity.Appointment;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


import java.util.List;



public class PatientDTO {

    private Long id;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    private String address;
    private String gender;

    @Min(value = 0, message = "Age must be non-negative")
    private int age;

    private List<AllergyDTO> allergies;
    private List<DiagnosisDTO> diagnoses;
    private LifeStyleHistoryDTO lifeStyleHistory;
    private List<VaccinationRecordDTO> vaccinationRecords;
    private List<ChronicConditionsDTO> chronicConditions;
    private List<CurrentMedicationsDTO> currentMedications;
    private List<HospitalizationDTO> hospitalizations;
    private List<LabResultDTO> labResults;
    private List<PrescriptionDTO> prescriptions;
    private List<SurgeriesDTO> surgeries;
    private List<TreatmentPlansDTO> treatmentPlans;
    private  List<Appointment> appointments;
    ///////////here my setter and getter annotation are not working


    public PatientDTO() {
    }

    public PatientDTO(Long id, String fullName, String phoneNumber, String email, String address, String gender, int age, List<AllergyDTO> allergies, List<DiagnosisDTO> diagnoses, LifeStyleHistoryDTO lifeStyleHistory, List<VaccinationRecordDTO> vaccinationRecords, List<ChronicConditionsDTO> chronicConditions, List<CurrentMedicationsDTO> currentMedications, List<HospitalizationDTO> hospitalizations, List<LabResultDTO> labResults, List<PrescriptionDTO> prescriptions, List<SurgeriesDTO> surgeries, List<TreatmentPlansDTO> treatmentPlans, List<Appointment> appointments) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.allergies = allergies;
        this.diagnoses = diagnoses;
        this.lifeStyleHistory = lifeStyleHistory;
        this.vaccinationRecords = vaccinationRecords;
        this.chronicConditions = chronicConditions;
        this.currentMedications = currentMedications;
        this.hospitalizations = hospitalizations;
        this.labResults = labResults;
        this.prescriptions = prescriptions;
        this.surgeries = surgeries;
        this.treatmentPlans = treatmentPlans;
        this.appointments = appointments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<AllergyDTO> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<AllergyDTO> allergies) {
        this.allergies = allergies;
    }

    public List<DiagnosisDTO> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<DiagnosisDTO> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public LifeStyleHistoryDTO getLifeStyleHistory() {
        return lifeStyleHistory;
    }

    public void setLifeStyleHistory(LifeStyleHistoryDTO lifeStyleHistory) {
        this.lifeStyleHistory = lifeStyleHistory;
    }

    public List<VaccinationRecordDTO> getVaccinationRecords() {
        return vaccinationRecords;
    }

    public void setVaccinationRecords(List<VaccinationRecordDTO> vaccinationRecords) {
        this.vaccinationRecords = vaccinationRecords;
    }

    public List<ChronicConditionsDTO> getChronicConditions() {
        return chronicConditions;
    }

    public void setChronicConditions(List<ChronicConditionsDTO> chronicConditions) {
        this.chronicConditions = chronicConditions;
    }

    public List<CurrentMedicationsDTO> getCurrentMedications() {
        return currentMedications;
    }

    public void setCurrentMedications(List<CurrentMedicationsDTO> currentMedications) {
        this.currentMedications = currentMedications;
    }

    public List<HospitalizationDTO> getHospitalizations() {
        return hospitalizations;
    }

    public void setHospitalizations(List<HospitalizationDTO> hospitalizations) {
        this.hospitalizations = hospitalizations;
    }

    public List<LabResultDTO> getLabResults() {
        return labResults;
    }

    public void setLabResults(List<LabResultDTO> labResults) {
        this.labResults = labResults;
    }

    public List<PrescriptionDTO> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<PrescriptionDTO> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public List<SurgeriesDTO> getSurgeries() {
        return surgeries;
    }

    public void setSurgeries(List<SurgeriesDTO> surgeries) {
        this.surgeries = surgeries;
    }

    public List<TreatmentPlansDTO> getTreatmentPlans() {
        return treatmentPlans;
    }

    public void setTreatmentPlans(List<TreatmentPlansDTO> treatmentPlans) {
        this.treatmentPlans = treatmentPlans;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}