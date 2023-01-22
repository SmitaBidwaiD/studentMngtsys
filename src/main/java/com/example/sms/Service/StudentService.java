package com.example.sms.Service;

import com.example.sms.Entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudent();
    ResponseEntity<String> saveStudent(Student student);

    Optional<Student> getStudentById(int id);

    Student updateStudent(Student student);

    String deleteStudentById(int id);
}
