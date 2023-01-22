package com.example.sms.Controller;


import com.example.sms.Entity.Student;
import com.example.sms.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Studentcontroller {

    private StudentService studentService;

    public Studentcontroller(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudent(Model model){
        model.addAttribute("students",studentService.getAllStudent());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        //create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student",student);
        return "Create_Student";
    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/student/edit/{id}")
   public String editStudentform(@PathVariable int id, Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "Edit_student";
   }

   @PostMapping("/students/{id}")
   public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student,
            Model model){

        //get student details from db by id
       Student existingStudent = studentService.getStudentById(id).get();
       existingStudent.setId(id);
       existingStudent.setFirstName(student.getFirstName());
       existingStudent.setLastName(student.getLastName());
       existingStudent.setEmail(student.getEmail());

       //save updated student to db
       studentService.updateStudent(existingStudent);
       return "redirect:/students";

   }

   @GetMapping("/student/{id}")
   public String deleteStudent(@PathVariable int id){
         studentService.deleteStudentById(id);
         return "redirect:/students";
//         return ResponseEntity.status(HttpStatus.FOUND).body("student is deleted: "+id);

   }
}
