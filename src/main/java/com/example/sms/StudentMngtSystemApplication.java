package com.example.sms;

import com.example.sms.Entity.Student;
import com.example.sms.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentMngtSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMngtSystemApplication.class, args);
	}

}
