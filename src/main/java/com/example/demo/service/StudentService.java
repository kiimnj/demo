package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDto;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getAllStudent() { //서비스니까 비지니스스러운 네이밍 .. ..
        return studentRepository.findAll();
    }
    public Student getStudentInfo(int studentId) {
        return studentRepository.findById(studentId);
    }
    public String removeStudent(int studentId) {
        Student removedStudent = studentRepository.removeById(studentId);
        String result = "";
        if (removedStudent != null) {
            result = "정상 삭제됨";
        } else {
            result = "삭제 과정에 오류 발생";
        }
        return result;
    }
    public String addStudent(Student student) {
        String result = "";
        Student addedStudent = studentRepository.add(student);
        System.out.println(addedStudent);
        if (addedStudent != null) {
            result = "정상 추가 됨";
        } else {
            result = "정상 추가 안됨";
        }
        return result;
    }
    public String updateStudent(int studentId, StudentDto studentDto) {
        Student foundStudent = studentRepository.findById(studentId);
        foundStudent.setPoint(studentDto.getPoint());
        studentRepository.update(studentId, foundStudent);
        return "수정 완료";
    }
}
