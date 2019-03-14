package com.example.retrospective.services;

import com.example.retrospective.DAO.EmployeeDAO;
import com.example.retrospective.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;

    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    public List<Employee> findByEmpNameStartingWith(String empName) {
        return employeeDAO.findByEmpNameStartingWith(empName);
    }

    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    public void deleteById(int empID) {
        employeeDAO.deleteById(empID);
    }
}
