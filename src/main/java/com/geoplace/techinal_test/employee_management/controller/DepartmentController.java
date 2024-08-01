package com.geoplace.techinal_test.employee_management.controller;

import com.geoplace.techinal_test.employee_management.dto.CreateDepartmentDTO;
import com.geoplace.techinal_test.employee_management.model.Department;
import com.geoplace.techinal_test.employee_management.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping
    public Department createDepartment(@RequestBody CreateDepartmentDTO createDepartmentDTO) {
        return departmentService.saveDepartment(createDepartmentDTO);
    }

}
