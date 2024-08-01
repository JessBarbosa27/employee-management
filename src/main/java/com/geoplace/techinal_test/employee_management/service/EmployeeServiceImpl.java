package com.geoplace.techinal_test.employee_management.service;

import com.geoplace.techinal_test.employee_management.dto.CreateEmployeeDTO;
import com.geoplace.techinal_test.employee_management.exception.EmployeeNotFoundException;
import com.geoplace.techinal_test.employee_management.model.Employee;
import com.geoplace.techinal_test.employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentService departmentService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentService departmentService) {
        this.employeeRepository = employeeRepository;
        this.departmentService = departmentService;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee createEmployee(CreateEmployeeDTO createEmployeeDTO) {

        Employee employee = new Employee();

        employee.setName(createEmployeeDTO.getName());
        employee.setDepartment(departmentService.getDepartmentById(createEmployeeDTO.getDepartmentId()));
        employee.setSkills(createEmployeeDTO.getSkills());

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, CreateEmployeeDTO createEmployeeDTO) {
        Employee employee = getEmployeeById(id);

        employee.setName(createEmployeeDTO.getName());
        employee.setDepartment(departmentService.getDepartmentById(createEmployeeDTO.getDepartmentId()));
        employee.setSkills(createEmployeeDTO.getSkills());

        return employeeRepository.save(employee);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
        return true;
    }
}
