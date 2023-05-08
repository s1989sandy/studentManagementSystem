package com.javahomecloud.studentmanagement.repository;

import com.javahomecloud.studentmanagement.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentManagementRepository extends MongoRepository<Student,Integer> {
}
