package com.example.spring5securityapp.service;

import com.example.spring5securityapp.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();

    Optional<Student> getStudentById(int studentId);

}
