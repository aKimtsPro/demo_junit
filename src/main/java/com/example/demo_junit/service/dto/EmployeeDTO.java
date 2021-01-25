package com.example.demo_junit.service.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class EmployeeDTO {

    @NonNull
    private Long id;
    @NonNull
    private String nom;
    @NonNull
    private Integer salary;

}
