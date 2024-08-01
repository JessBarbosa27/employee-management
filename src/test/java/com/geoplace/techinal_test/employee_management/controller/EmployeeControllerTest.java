package com.geoplace.techinal_test.employee_management.controller;

import com.geoplace.techinal_test.employee_management.model.Employee;
import com.geoplace.techinal_test.employee_management.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void getAllEmployees_shouldReturnEmployees() throws Exception {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Jess Barbosa");

        when(employeeService.getAllEmployees()).thenReturn(Collections.singletonList(employee));

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("Jess Barbosa"));

        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    void getEmployeeById_shouldReturnEmployee_whenEmployeeExists() throws Exception {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Jess Barbosa");

        when(employeeService.getEmployeeById(1L)).thenReturn(employee);

        mockMvc.perform(get("/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jess Barbosa"));

        verify(employeeService, times(1)).getEmployeeById(1L);
    }

    @Test
    void getEmployeeById_shouldReturnNotFound_whenEmployeeDoesNotExist() throws Exception {
        Long employeeId = 1L;
        when(employeeService.getEmployeeById(employeeId)).thenThrow(new RuntimeException("Employee not found with id: " + employeeId));

        mockMvc.perform(get("/employees/{id}", employeeId))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteEmployee_shouldReturnOk_whenEmployeeExists() throws Exception {
        Long employeeId = 1L;
        when(employeeService.deleteEmployee(employeeId)).thenReturn(true);

        mockMvc.perform(delete("/employees/{id}", employeeId))
                .andExpect(status().isOk());

        verify(employeeService, times(1)).deleteEmployee(employeeId);
    }
}
