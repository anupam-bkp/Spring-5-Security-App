package com.example.spring5securityapp.service;

import com.example.spring5securityapp.model.Student;
import com.example.spring5securityapp.model.StudentUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {


    @Override
    public List<Student> getAllStudents() {
        return StudentUtil.getAllStudents();
    }

    @Override
    public Optional<Student> getStudentById(int studentId) {
        return StudentUtil.getStudentById(studentId);
    }
}
