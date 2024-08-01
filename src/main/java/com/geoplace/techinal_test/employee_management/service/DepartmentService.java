package com.geoplace.techinal_test.employee_management.service;

import com.geoplace.techinal_test.employee_management.dto.CreateDepartmentDTO;
import com.geoplace.techinal_test.employee_management.model.Department;

import java.util.List;

public interface DepartmentService {

    public List<Department> getAllDepartments();

    public Department saveDepartment(CreateDepartmentDTO createDepartmentDTO);

    public Department getDepartmentById(Long id);
}
