package com.example.spring5securityapp.controller;

import com.example.spring5securityapp.model.Student;
import com.example.spring5securityapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private StudentService studentService;

    @GetMapping(path = "/{id}")
    public Student getStudent(@PathVariable(value = "id") Integer studentId){

        return studentService.getStudent(studentId);

    }

}
