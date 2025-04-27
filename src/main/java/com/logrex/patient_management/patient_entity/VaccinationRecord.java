package com.logrex.patient_management.patient_entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vaccination_records")

public class VaccinationRecord {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "vaccine_name", nullable = false)
        private String vaccineName;

//        @Column(name = "date_administered", nullable = false)
//        private Date dateAdministered;

        @Column(name = "dosage_formulation", nullable = false)
        private String dosageFormulation;

        @Column(name = "lot_number", nullable = false)
        private String lotNumber;

        @Column(name = "administering_provider", nullable = false)
        private String administeringProvider;

        @ManyToMany(mappedBy = "vaccinationRecords")
        private List<Patient> patients;

        public VaccinationRecord() {
        }

        public VaccinationRecord(Long id, String vaccineName, String dosageFormulation, String lotNumber, String administeringProvider, List<Patient> patients) {
                this.id = id;
                this.vaccineName = vaccineName;
                this.dosageFormulation = dosageFormulation;
                this.lotNumber = lotNumber;
                this.administeringProvider = administeringProvider;
                this.patients = patients;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getVaccineName() {
                return vaccineName;
        }

        public void setVaccineName(String vaccineName) {
                this.vaccineName = vaccineName;
        }

        public String getDosageFormulation() {
                return dosageFormulation;
        }

        public void setDosageFormulation(String dosageFormulation) {
                this.dosageFormulation = dosageFormulation;
        }

        public String getLotNumber() {
                return lotNumber;
        }

        public void setLotNumber(String lotNumber) {
                this.lotNumber = lotNumber;
        }

        public String getAdministeringProvider() {
                return administeringProvider;
        }

        public void setAdministeringProvider(String administeringProvider) {
                this.administeringProvider = administeringProvider;
        }

        public List<Patient> getPatients() {
                return patients;
        }

        public void setPatients(List<Patient> patients) {
                this.patients = patients;
        }
}
