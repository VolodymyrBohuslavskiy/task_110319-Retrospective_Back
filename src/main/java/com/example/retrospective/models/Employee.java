package com.example.retrospective.models;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int empID;
    String empName;
    boolean empActive;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    Department department;



    public Employee() {
    }
}
