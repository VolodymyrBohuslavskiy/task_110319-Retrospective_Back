package com.example.retrospective.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int empID;
    String empName;
    boolean empActive;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    Department department;

    public Employee(String empName, boolean empActive, Department department) {
        this.empName = empName;
        this.empActive = empActive;
        this.department = department;
    }

    public Employee() {
    }
}
