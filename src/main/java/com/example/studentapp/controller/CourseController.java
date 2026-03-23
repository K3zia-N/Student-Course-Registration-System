package com.example.studentapp.controller;

import com.example.studentapp.model.Course;
import com.example.studentapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("course", new Course());
        return "add-course";
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        return "add-course";
    }

    @PostMapping("/edit/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute Course course) {
        course.setId(id);
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }
}