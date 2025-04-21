package com.logrex.patient_management.patient_entity;

import com.logrex.patient_management.appointment_entity.Appointment;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "patietns")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name" , nullable = false)
    private String fullName;


    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    private String gender;

    @Column(nullable = false)
    private int age;


    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Allergy> allergies;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, orphanRemoval = true)
  private  List<Diagnosis> diagnoses ;

  @OneToOne(mappedBy = "patient",cascade = CascadeType.ALL, orphanRemoval = true)
  private  LifeStyleHistory lifeStyleHistory;

  @ManyToMany
  @JoinTable(name = "patient_vaccine"
  ,joinColumns = @JoinColumn(name = "patient_id"),
  inverseJoinColumns = @JoinColumn(name = "vaccine_id"))
  private List<VaccinationRecord> vaccinationRecords;

  @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, orphanRemoval = true)
  private  List<ChronicConditions> chronicConditions;

  @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, orphanRemoval = true)
  private  List<CurrentMedications> currentMedications;

  @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, orphanRemoval = true)
  private  List<Hospitalizations> hospitalizations;

  @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, orphanRemoval = true )
    private  List<LabResult> labResults;

//  @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, orphanRemoval = true)
//  private List<Prescription> prescription;

  @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, orphanRemoval = true)
  private  List<Surgeries> surgeries;

  @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, orphanRemoval = true)
  private List<TreatmentPlans> treatmentPlans;
  @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, orphanRemoval = true)

  private  List<Appointment> appointments;


    public Patient() {
    }

    public Patient(Long id, String fullName, String phoneNumber, String email, String address, String gender, int age, List<Allergy> allergies, List<Diagnosis> diagnoses, LifeStyleHistory lifeStyleHistory, List<VaccinationRecord> vaccinationRecords, List<ChronicConditions> chronicConditions, List<CurrentMedications> currentMedications, List<Hospitalizations> hospitalizations, List<LabResult> labResults, List<Surgeries> surgeries, List<TreatmentPlans> treatmentPlans, List<Appointment> appointments) {
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

    public List<Allergy> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Allergy> allergies) {
        this.allergies = allergies;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public LifeStyleHistory getLifeStyleHistory() {
        return lifeStyleHistory;
    }

    public void setLifeStyleHistory(LifeStyleHistory lifeStyleHistory) {
        this.lifeStyleHistory = lifeStyleHistory;
    }

    public List<VaccinationRecord> getVaccinationRecords() {
        return vaccinationRecords;
    }

    public void setVaccinationRecords(List<VaccinationRecord> vaccinationRecords) {
        this.vaccinationRecords = vaccinationRecords;
    }

    public List<ChronicConditions> getChronicConditions() {
        return chronicConditions;
    }

    public void setChronicConditions(List<ChronicConditions> chronicConditions) {
        this.chronicConditions = chronicConditions;
    }

    public List<CurrentMedications> getCurrentMedications() {
        return currentMedications;
    }

    public void setCurrentMedications(List<CurrentMedications> currentMedications) {
        this.currentMedications = currentMedications;
    }

    public List<Hospitalizations> getHospitalizations() {
        return hospitalizations;
    }

    public void setHospitalizations(List<Hospitalizations> hospitalizations) {
        this.hospitalizations = hospitalizations;
    }

    public List<LabResult> getLabResults() {
        return labResults;
    }

    public void setLabResults(List<LabResult> labResults) {
        this.labResults = labResults;
    }

    public List<Surgeries> getSurgeries() {
        return surgeries;
    }

    public void setSurgeries(List<Surgeries> surgeries) {
        this.surgeries = surgeries;
    }

    public List<TreatmentPlans> getTreatmentPlans() {
        return treatmentPlans;
    }

    public void setTreatmentPlans(List<TreatmentPlans> treatmentPlans) {
        this.treatmentPlans = treatmentPlans;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
