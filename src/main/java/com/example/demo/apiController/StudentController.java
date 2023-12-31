package com.example.demo.apiController;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }
    @GetMapping("/{studentId}")
    public Student getStudentInfo(@PathVariable int studentId) {//바인딩 변수와 같아서  int studentId 생략 가능
        return studentService.getStudentInfo(studentId);
    }
    @DeleteMapping("/{studentId}")
    public String removeStudentInfo(@PathVariable int studentId) {
        String res = studentService.removeStudent(studentId);
        return res;
    }
    @PostMapping
    public String addStudent(@RequestBody Student student) {
        String res = studentService.addStudent(student);
        return res;
    }
    @PutMapping("/{studentId}")
    public String updateStudent(@PathVariable int studentId,
                                @RequestBody StudentDto studentDto) {
        String res = studentService.updateStudent(studentId, studentDto);
        return res;
    }
}
