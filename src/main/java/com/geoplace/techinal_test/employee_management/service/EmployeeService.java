package com.geoplace.techinal_test.employee_management.service;

import com.geoplace.techinal_test.employee_management.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long id);

    public List<Employee> getEmployeesByDepartment(Long departmentId);

    public Employee saveEmployee(Employee employee);

    public void deleteEmployee(Long id);

}
