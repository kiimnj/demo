package com.example.demo.model;

import lombok.Data;

@Data
public class Student {
    private int studentId;
    private String name;
    private String major;
    private float point; //null처리 할 수 있도록
}
