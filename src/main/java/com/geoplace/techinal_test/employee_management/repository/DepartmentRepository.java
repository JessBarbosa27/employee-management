package com.geoplace.techinal_test.employee_management.repository;

import com.geoplace.techinal_test.employee_management.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}