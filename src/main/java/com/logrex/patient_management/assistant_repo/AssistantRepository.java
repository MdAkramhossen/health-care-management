package com.logrex.patient_management.assistant_repo;

import com.logrex.patient_management.assistant_entity.Assistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssistantRepository extends JpaRepository<Assistant, Long> {
    List<Assistant> findByLinkedDoctorId(Long doctorId);
}
