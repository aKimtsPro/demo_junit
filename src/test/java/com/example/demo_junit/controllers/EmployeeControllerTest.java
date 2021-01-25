package com.example.demo_junit.controllers;

import com.example.demo_junit.service.EmployeeService;
import com.example.demo_junit.service.dto.EmployeeDTO;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService service;

    @Test
    public void whenGivenValidName_thenReturnEmployeJson()
            throws Exception {

        EmployeeDTO expected = new EmployeeDTO(0L, "pol", 0);
        Mockito.when(service.getEmployeeByName("pol")).thenReturn(expected);

        // localhost:8080/employe/pol => ce qui depasse : /employe/pol
        mvc.perform(get("/employe/pol"))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(content().json(
                        """
                                {
                                    "id"=0,
                                    "nom"="pol",
                                    "salary"=0
                                }
                                """
                ));
    }
}
