package com.example.spring5securityapp.model;

import java.util.*;

public class StudentUtil {

    private static Map<Integer, Student> studentsMap = new HashMap<>();

    static{
        Student student1 = Student.builder()
                .StudentId(1).studentName("James Bond").build();

        Student student2 = Student.builder()
                .StudentId(2).studentName("Maria Jones").build();

        Student student3 = Student.builder()
                .StudentId(3).studentName("Elenor Shellstrop").build();

        Student student4 = Student.builder()
                .StudentId(4).studentName("Erin Naird").build();


        studentsMap.put(student1.getStudentId(), student1);
        studentsMap.put(student2.getStudentId(), student2);
        studentsMap.put(student3.getStudentId(), student3);
        studentsMap.put(student4.getStudentId(), student4);
    }

    public static List<Student> getAllStudents(){
        return new ArrayList<>(studentsMap.values());
    }

    public static Optional<Student> getStudentById(int studentId){
        return Optional.ofNullable(studentsMap.get(studentId));
    }


}
