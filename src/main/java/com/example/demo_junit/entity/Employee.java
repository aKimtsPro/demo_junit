package com.example.demo_junit.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employee")
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer salary;

    public Employee() {
    }
}
