package com.example.retrospective.DAO;

import com.example.retrospective.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDAO extends JpaRepository<Department, Integer> {
}
