package com.javahomecloud.studentmanagement.service;

import com.javahomecloud.studentmanagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface StudentManagementService {

	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Optional<Student> getStudentById(int id);
	Student updateStudent(Student student, int studentId);
	String deleteStudentById(int id);

}
