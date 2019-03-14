package com.example.retrospective.services;

import com.example.retrospective.DAO.DepartmentDAO;
import com.example.retrospective.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentDAO departmentDAO;

    public List<Department> findAll() {
        return departmentDAO.findAll();
    }

    public void save(Department department) {
        departmentDAO.save(department);
    }
}
