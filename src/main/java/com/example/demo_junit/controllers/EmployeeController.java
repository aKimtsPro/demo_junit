package com.example.demo_junit.controllers;

import com.example.demo_junit.service.EmployeeService;
import com.example.demo_junit.service.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employe")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/{name}")
    public ResponseEntity<EmployeeDTO> getByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getEmployeeByName(name));
    }
}
