package com.geoplace.techinal_test.employee_management.service;

import com.geoplace.techinal_test.employee_management.dto.CreateDepartmentDTO;
import com.geoplace.techinal_test.employee_management.exception.EmployeeNotFoundException;
import com.geoplace.techinal_test.employee_management.model.Department;
import com.geoplace.techinal_test.employee_management.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(CreateDepartmentDTO createDepartmentDTO) {
        Department department = new Department();
        department.setName(createDepartmentDTO.getName());

        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Department not found with id: " + id));
    }
}
