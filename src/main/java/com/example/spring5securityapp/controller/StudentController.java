package com.example.spring5securityapp.controller;

import com.example.spring5securityapp.model.Student;
import com.example.spring5securityapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer studentId){


        Optional<Student> studentById = studentService.getStudentById(studentId);
        Student student = studentById.orElseThrow();
//        return studentById.orElseThrow();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "http://localhost:8080/api/v1/students");

        return new ResponseEntity<>(student, headers, HttpStatus.OK);
    }

}
