package com.example.studentapp.service;

import com.example.studentapp.model.Registration;
import com.example.studentapp.model.Student;
import com.example.studentapp.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public List<Registration> getRegistrationsByStudent(Student student) {
        return registrationRepository.findByStudent(student);
    }

    public void save(Registration registration) {
        registrationRepository.save(registration);
    }

    public void delete(Long id) {
        registrationRepository.deleteById(id);
    }
}