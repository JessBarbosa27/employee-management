package com.geoplace.techinal_test.employee_management.repository;


import com.geoplace.techinal_test.employee_management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentId(Long departmentId);
}
