package com.logrex.patient_management.patient_entity;

import com.logrex.patient_management.patient_enums.Severity;
import jakarta.persistence.*;



import java.util.Date;

@Entity
@Table(name = "allergies")

public class Allergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "allergen_name", nullable = false)

    private String allergenName;

    @Column(name = "reaction_type", nullable = false)

    private String reactionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "severity", nullable = false)

    private Severity severity;

    @Column(name = "onset_date", nullable = false)

    private Date onsetDate;
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="patient_id" )
    private  Patient patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAllergenName() {
        return allergenName;
    }

    public void setAllergenName(String allergenName) {
        this.allergenName = allergenName;
    }

    public String getReactionType() {
        return reactionType;
    }

    public void setReactionType(String reactionType) {
        this.reactionType = reactionType;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Date getOnsetDate() {
        return onsetDate;
    }

    public void setOnsetDate(Date onsetDate) {
        this.onsetDate = onsetDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
