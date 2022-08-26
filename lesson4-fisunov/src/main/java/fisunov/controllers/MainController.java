package fisunov.controllers;

import fisunov.data.Student;
import fisunov.repositiries.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private StudentRepository studentRepository;

    public MainController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/add")
    @ResponseBody
    public int add(@RequestParam (name = "a") int aa, @RequestParam int b) {
        return aa + b;
    }

    @GetMapping("/product/{id}/info")
    @ResponseBody
    public String showProductInfo(@PathVariable Long id) {
        return "product #" + id;
    }

    @GetMapping("/student_Bob")
    public String showStudentsPage(Model model) {
        Student student = new Student(1L, "Bob");
        model.addAttribute("studentBob", student);
        return "student_Bob";
    }

    @GetMapping("/students_list")
    public String showListOfStudentsPage(Model model) {
        model.addAttribute("students", studentRepository.getAllStudents());
        return "students_page";
    }

    @GetMapping("/student/{id}")
    public String showStudentById(Model model, @PathVariable Long id) {
        Student student = studentRepository.findById(id);
        model.addAttribute("student", student);
        return "student_by_id";
    }

    @PostMapping("/getStudent")
    @ResponseBody
    public Student getStudent(@RequestBody Student student) {
        student.setId(100L);
        return student;
    }

    @GetMapping("/show_form")
    public String showFormPage() {
        return "simple_form";
    }

    @GetMapping("/stud_add")
    public String addStudent(@RequestParam Long id, @RequestParam String name) {
        Student student = new Student(id, name);
        studentRepository.add(student);
        return "redirect:/students_list";
    }
}
