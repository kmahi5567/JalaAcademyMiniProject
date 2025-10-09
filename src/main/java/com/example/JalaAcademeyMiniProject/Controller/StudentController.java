package com.example.JalaAcademeyMiniProject.Controller;

import com.example.JalaAcademeyMiniProject.Model.Student;
import com.example.JalaAcademeyMiniProject.Service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public String listStudents(Model model, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) return "redirect:/login";
        model.addAttribute("students", studentService.getAllStudents());
        return "student-list"; // student-list.html
    }

    @GetMapping("/form")
    public String studentForm(Model model, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) return "redirect:/login";
        model.addAttribute("student", new Student());
        return "student-form"; // student-form.html
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/student/list";
    }

   /* @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) return "redirect:/login";
        studentService.saveStudent(student);
        return "redirect:/student/list";
    }*/

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) return "redirect:/login";
        model.addAttribute("student", studentService.getStudentById(id));
        return "student-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) return "redirect:/login";
        studentService.deleteStudent(id);
        return "redirect:/student/list";
    }
}
