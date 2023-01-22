package com.example.sms.serviceimpl;

import com.example.sms.Entity.Student;
import com.example.sms.Repository.StudentRepository;
import com.example.sms.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class StudentserviceImpl implements StudentService {

    private StudentRepository studentRepo;

    public StudentserviceImpl(StudentRepository studentRepo) {
        super();
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public ResponseEntity<String> saveStudent(Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).
                body("Product is added successfully in Database :" + studentRepo.save(student));
    }

    @Override
    public Optional<Student> getStudentById(int id) {
        return studentRepo.findById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public String deleteStudentById(@PathVariable int id) {

        Optional<Student> value = studentRepo.findById(id);
        if (value.isEmpty()){
            return "Id is not present in DB: "+ id;
        }
        else {
            studentRepo.deleteById(id);
            return "student is Deleted Successfully: "+ id;
        }
    }

}
