package com.example.demo_junit.service;

import com.example.demo_junit.entity.Employee;
import com.example.demo_junit.repository.EmployeeRepository;
import com.example.demo_junit.service.dto.EmployeeDTO;
import com.example.demo_junit.service.mapper.BaseMapper;
import com.example.demo_junit.service.mapper.EmployeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Autowired
    private BaseMapper<EmployeeDTO, Employee> mapper;

    @Override
    public EmployeeDTO getEmployeeByName(String name) {
        return mapper.toDto(repo.findByName(name));
    }
}
