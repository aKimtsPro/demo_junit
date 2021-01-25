package com.example.demo_junit.service;

import com.example.demo_junit.entity.Employee;
import com.example.demo_junit.repository.EmployeeRepository;
import com.example.demo_junit.service.dto.EmployeeDTO;
import com.example.demo_junit.service.mapper.BaseMapper;
import com.example.demo_junit.service.mapper.EmployeMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceImplTest {

    @TestConfiguration
    static class EmployeeServiceImplConfig{
        @Bean
        public EmployeeServiceImpl service(){
            return new EmployeeServiceImpl();
        }
    }

    @Autowired
    private EmployeeService service;

    @MockBean
    private EmployeeRepository repo;

    @MockBean
    private BaseMapper<EmployeeDTO, Employee> mapper;

    @Test
    void whenValidName_thenEmployeeShouldBeFound(){
        String validName = "test";

        EmployeeDTO dto = new EmployeeDTO(0L, validName, 0);
        Employee entity = Employee.builder()
                                .id(0L)
                                .name(validName)
                                .salary(0)
                                .build();

        Mockito.when(repo.findByName(validName)).thenReturn(entity);
        Mockito.when(mapper.toDto(entity)).thenReturn(dto);

        EmployeeDTO found = service.getEmployeeByName(validName);
        assertEquals(found, dto);
    }
}
