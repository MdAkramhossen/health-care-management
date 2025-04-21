package com.logrex.patient_management.assistantDTO;


public class AssistantDTO {

    private Long assistantId;
    private String fullName;
    private String role;
    private String certifications;
    private String profilePicture;
    private Long linkedDoctorId;

    public AssistantDTO() {
    }

    public AssistantDTO(Long assistantId, String fullName, String role, String certifications, String profilePicture, Long linkedDoctorId) {
        this.assistantId = assistantId;
        this.fullName = fullName;
        this.role = role;
        this.certifications = certifications;
        this.profilePicture = profilePicture;
        this.linkedDoctorId = linkedDoctorId;
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

    public Long getLinkedDoctorId() {
        return linkedDoctorId;
    }

    public void setLinkedDoctorId(Long linkedDoctorId) {
        this.linkedDoctorId = linkedDoctorId;
    }
}