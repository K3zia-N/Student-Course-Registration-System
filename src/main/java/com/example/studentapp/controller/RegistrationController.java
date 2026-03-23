package com.example.studentapp.controller;

import com.example.studentapp.model.Registration;
import com.example.studentapp.model.Student;
import com.example.studentapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired private RegistrationService registrationService;
    @Autowired private StudentService studentService;
    @Autowired private CourseService courseService;

    @GetMapping
    public String listRegistrations(Model model) {
        model.addAttribute("registrations", registrationService.getAllRegistrations());
        return "registrations";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registration", new Registration());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("courses", courseService.getAllCourses());
        return "register-course";
    }

    @PostMapping("/register")
    public String register(@RequestParam Long studentId,
                           @RequestParam Long courseId,
                           @RequestParam String semester) {
        Registration reg = new Registration();
        reg.setStudent(studentService.getStudentById(studentId));
        reg.setCourse(courseService.getCourseById(courseId));
        reg.setSemester(semester);
        registrationService.save(reg);
        return "redirect:/registrations";
    }

    @GetMapping("/drop/{id}")
    public String drop(@PathVariable Long id) {
        registrationService.delete(id);
        return "redirect:/registrations";
    }

    @GetMapping("/student/{id}")
    public String viewByStudent(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("registrations", registrationService.getRegistrationsByStudent(student));
        return "student-registrations";
    }
}