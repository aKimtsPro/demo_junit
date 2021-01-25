package com.example.demo_junit.service.mapper;

import com.example.demo_junit.entity.Employee;
import com.example.demo_junit.service.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class EmployeMapperTest {

    @Autowired
    private BaseMapper<EmployeeDTO, Employee> mapper;

    @TestConfiguration
    static class EmployeMapperTestConfig{
        @Bean
        public EmployeMapper employeMapper(){
            return new EmployeMapper();
        }
    }


    @Test
    void toDto(){
        Employee employee = Employee.builder()
                                .id(1L)
                                .name("test")
                                .salary(2000)
                                .build();

        EmployeeDTO expected = new EmployeeDTO(1L, "test", 2000);

        assertEquals(expected, mapper.toDto(employee));
    }
}
