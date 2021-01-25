package com.example.demo_junit.repository;

import com.example.demo_junit.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private EmployeeRepository repo;

    @Test
    void findByName(){
        Employee expected = Employee.builder()
                            .name("test")
                            .salary(2000)
                            .build();

        em.persist(expected);
        em.flush();

        Employee actual = repo.findByName("test");

        assertEquals(expected, actual);
    }
}
