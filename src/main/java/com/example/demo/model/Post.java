package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //Getter, Setter, toString, ... 포함
//@AllArgsConstructor
public class Post {
    private int postid;
    private String title;
    private String body;
    private int likes;
}
