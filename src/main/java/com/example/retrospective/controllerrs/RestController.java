package com.example.retrospective.controllerrs;

import com.example.retrospective.models.Department;
import com.example.retrospective.models.Employee;
import com.example.retrospective.services.DepartmentService;
import com.example.retrospective.services.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin("*")
public class RestController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/get_all_employees")
    public String get_all_employees() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(employeeService.findAll());
    }

    @GetMapping("/get_all_departments")
    public String get_all_departments() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(departmentService.findAll());
    }

    @GetMapping("/get_employees_by_name-{empName}")
    public String get_employees_by_name(@PathVariable String empName) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(employeeService.findByEmpNameStartingWith(empName));
    }

    @PostMapping("/set_magic_departments")
    public void set_magic_departments(@RequestBody String magic_departments) throws IOException {
        for (Department department : new ObjectMapper().readValue(magic_departments, Department[].class)) {
            departmentService.save(department);
        }
    }

    @PostMapping("/save_employee")
    public void save_employee(@RequestBody String employee) throws IOException {
        employeeService.save(new ObjectMapper().readValue(employee, Employee.class));
    }

    @DeleteMapping("/delete_employee_id={empID}")
    public void delete_employee(@PathVariable int empID) {
        employeeService.deleteById(empID);
    }
}
