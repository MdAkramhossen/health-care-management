package com.logrex.patient_management.assistant_entity;

import com.logrex.patient_management.doctor_entity.Doctor;
import jakarta.persistence.*;

@Entity
@Table(name = "assistant")
public class Assistant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assistantId;

    private String fullName;
    private String role;
    private String certifications;
    private String profilePicture;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor linkedDoctor;

    public Assistant() {
    }

    public Assistant(Long assistantId, String fullName, String role, String certifications, String profilePicture, Doctor linkedDoctor) {
        this.assistantId = assistantId;
        this.fullName = fullName;
        this.role = role;
        this.certifications = certifications;
        this.profilePicture = profilePicture;
        this.linkedDoctor = linkedDoctor;
    }

    public Long getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(Long assistantId) {
        this.assistantId = assistantId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Doctor getLinkedDoctor() {
        return linkedDoctor;
    }

    public void setLinkedDoctor(Doctor linkedDoctor) {
        this.linkedDoctor = linkedDoctor;
    }
}