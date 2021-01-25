package com.example.demo_junit.service;

import com.example.demo_junit.entity.Employee;
import com.example.demo_junit.service.dto.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO getEmployeeByName(String name);

}
