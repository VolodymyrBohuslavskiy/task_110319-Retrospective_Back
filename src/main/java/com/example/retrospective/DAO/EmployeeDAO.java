package com.example.retrospective.DAO;

import com.example.retrospective.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
    List<Employee> findByEmpNameStartingWith(String empName);

    void deleteByEmpID(int empID);
}
