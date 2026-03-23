package com.example.studentapp.repository;

import com.example.studentapp.model.Registration;
import com.example.studentapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByStudent(Student student);
}