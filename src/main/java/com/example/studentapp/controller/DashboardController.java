package com.example.studentapp.controller;

import com.example.studentapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired private StudentService studentService;
    @Autowired private CourseService courseService;
    @Autowired private RegistrationService registrationService;

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("totalStudents", studentService.getAllStudents().size());
        model.addAttribute("totalCourses", courseService.getAllCourses().size());
        model.addAttribute("totalRegistrations", registrationService.getAllRegistrations().size());
        return "dashboard";
    }
}