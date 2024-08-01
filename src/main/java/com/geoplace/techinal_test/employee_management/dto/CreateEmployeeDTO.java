package com.geoplace.techinal_test.employee_management.dto;

import jakarta.persistence.ElementCollection;

import java.util.Set;

public class CreateEmployeeDTO {

    private String name;

    @ElementCollection
    private Set<String> skills;

    private Long departmentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
