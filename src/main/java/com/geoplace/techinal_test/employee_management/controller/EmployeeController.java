package com.geoplace.techinal_test.employee_management.controller;

import com.geoplace.techinal_test.employee_management.dto.CreateEmployeeDTO;
import com.geoplace.techinal_test.employee_management.model.Employee;
import com.geoplace.techinal_test.employee_management.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            return ResponseEntity.ok(employee);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeesByDepartment(@PathVariable Long departmentId) {
        return employeeService.getEmployeesByDepartment(departmentId);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody CreateEmployeeDTO createEmployeeDTO) {
        return employeeService.createEmployee(createEmployeeDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody CreateEmployeeDTO createEmployeeDTO) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, createEmployeeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }
}