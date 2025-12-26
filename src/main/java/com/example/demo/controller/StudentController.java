package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @PostMapping
    public String addStudent() {
        return "Student added";
    }

    @GetMapping("/{id}")
    public String getStudent(@PathVariable Long id) {
        return "Student details";
    }
}
