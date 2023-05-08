package com.javahomecloud.studentmanagement.controller;

import com.javahomecloud.studentmanagement.model.Student;
import com.javahomecloud.studentmanagement.service.StudentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student-management")
public class StudentManagementController {

    @Autowired
    StudentManagementService studentManagementService;

    // Save operation
    @PostMapping("/registration")
    public Student saveStudent(@Validated @RequestBody Student student)
    {
        return studentManagementService.saveStudent(student);
    }

    // Read operation
    @GetMapping("/students")
    public List<Student> fetchStudentList()
    {
        return studentManagementService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudent(@PathVariable("id") int studentId)
    {
        return studentManagementService.getStudentById(studentId);
    }

    // Update operation
    @PutMapping("/student-update/{id}")
    public Student updateStudent(@RequestBody Student student,
                     @PathVariable("id") int studentId)
    {
        return studentManagementService.updateStudent(student,studentId);
    }

    // Delete operation
    @DeleteMapping("/student-delete/{id}")
    public String deleteStudentById(@PathVariable("id")
                                       int studentId)
    {
        return studentManagementService.deleteStudentById(studentId);
    }

}
