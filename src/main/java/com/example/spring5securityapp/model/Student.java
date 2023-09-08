package com.example.spring5securityapp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

    private Integer StudentId;
    private String studentName;

}
