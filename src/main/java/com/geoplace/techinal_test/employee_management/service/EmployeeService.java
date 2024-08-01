package com.geoplace.techinal_test.employee_management.service;

import com.geoplace.techinal_test.employee_management.dto.CreateEmployeeDTO;
import com.geoplace.techinal_test.employee_management.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long id);

    public List<Employee> getEmployeesByDepartment(Long departmentId);

    public Employee createEmployee(CreateEmployeeDTO createEmployeeDTO);

    public Employee updateEmployee(Long id, CreateEmployeeDTO createEmployeeDTO);

    public Employee saveEmployee(Employee employee);

    public boolean deleteEmployee(Long id);

}
