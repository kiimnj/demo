package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static Map<Integer, Student> studentMap = new HashMap<>();
    private static int seq = 0;

    public StudentRepositoryImpl() {
        Student student = new Student();
        student.setName("홍길동");
        student.setMajor("컴공");
        student.setPoint(3);
        add(student);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Student findById(int studentId) {
        Student student = studentMap.get(studentId);
        return student;
    }

    @Override
    public Student removeById(int studentId) {
        Student removeStudent = studentMap.remove(studentId);
        return removeStudent;
    }

    @Override
    public Integer add(Student student) { //put기능 외에는 서비스로 뺴는 게 더 좋음
        Integer result = null;
        student.setStudentId(++seq);
        Student addedStudent = studentMap.put(seq, student);
        if (addedStudent != null) {
            result = student.getStudentId();
        } else {
        }
        return result;
    }

    @Override
    public Student update(int studentId, Student student) {
        if (findById(studentId) != null) {
            studentMap.put(studentId, student);
        } else {
            System.out.println("업데이트 실패");
        }
        return student;
    }
}
