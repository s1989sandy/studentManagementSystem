package com.javahomecloud.studentmanagement.service.impl;

import com.javahomecloud.studentmanagement.model.Student;
import com.javahomecloud.studentmanagement.repository.StudentManagementRepository;
import com.javahomecloud.studentmanagement.service.StudentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentManagementServiceImpl implements StudentManagementService {

    @Autowired
    StudentManagementRepository studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }
    public Optional<Student> getStudentById(int id) {
        return studentRepo.findById(id);
    }
    @Override
    public Student updateStudent(Student studentDetails, int studentId) {
        Student student=studentRepo.findById(studentId).get();
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmail(studentDetails.getEmail());
        student.setPhoneNumber(studentDetails.getPhoneNumber());
        return studentRepo.save(student);
    }
    @Override
    public String deleteStudentById(int id) {
        String msg;
        try {
            if (studentRepo.findById(id).isPresent()) {
                studentRepo.deleteById(id);
                msg = "Deleted Succesfully";
            }else {
                msg="No Record Found in Database";
            }

        }catch (Exception e){
            msg="Exception Occured While Deleting Student:: "+id+" :: Exception Details:: "+e.getMessage();
        }
        return msg;
    }
}
