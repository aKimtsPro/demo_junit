package com.example.demo_junit.service.mapper;

import com.example.demo_junit.service.dto.EmployeeDTO;
import com.example.demo_junit.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeMapper implements BaseMapper<EmployeeDTO, Employee> {

    @Override
    public EmployeeDTO toDto(Employee entity) {
        if(entity == null)
            return null;

        return new EmployeeDTO(
                entity.getId(),
                entity.getName(),
                entity.getSalary()
        );
    }

    @Override
    public Employee toEntity(EmployeeDTO dto) {
        if(dto == null)
            return null;

        return Employee.builder()
                .id(dto.getId())
                .name(dto.getNom())
                .salary(dto.getSalary())
                .build();
    }
}
