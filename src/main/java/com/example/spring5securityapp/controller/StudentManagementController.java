package com.example.spring5securityapp.controller;

import com.example.spring5securityapp.model.Student;
import com.example.spring5securityapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private final StudentService studentService;

    @GetMapping
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @PostMapping
//    @PreAuthorize("hasAuthority('student:write')")
    public void registerStudent(@RequestBody Student student){
        System.out.println("StudentManagementController.registerStudent : " + student);
    }

    @DeleteMapping("{id}")
//    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("id") Integer studentId){
        System.out.println("studentId = " + studentId);
    }

    @PutMapping("{id}")
//    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("id") Integer studentId, @RequestBody Student student){
        System.out.printf("%s - %s%n", studentId, student);
    }

}
