package com.geoplace.techinal_test.employee_management.service;

import com.geoplace.techinal_test.employee_management.exception.EmployeeNotFoundException;
import com.geoplace.techinal_test.employee_management.model.Employee;
import com.geoplace.techinal_test.employee_management.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void deleteEmployee_shouldThrowException_whenEmployeeDoesNotExist() {
        Long employeeId = 1L;
        when(employeeRepository.existsById(employeeId)).thenReturn(false);

        EmployeeNotFoundException exception = assertThrows(EmployeeNotFoundException.class, () -> employeeService.deleteEmployee(employeeId));

        assertEquals("Employee not found with id: " + employeeId, exception.getMessage());
        verify(employeeRepository, times(1)).existsById(employeeId);
        verify(employeeRepository, never()).deleteById(employeeId);
    }

    @Test
    void deleteEmployee_shouldDelete_whenEmployeeExists() {
        Long employeeId = 1L;
        when(employeeRepository.existsById(employeeId)).thenReturn(true);
        doNothing().when(employeeRepository).deleteById(employeeId);

        boolean result = employeeService.deleteEmployee(employeeId);

        assertTrue(result);
        verify(employeeRepository, times(1)).existsById(employeeId);
        verify(employeeRepository, times(1)).deleteById(employeeId);
    }

    @Test
    void getEmployeeById_shouldReturnEmployee_whenEmployeeExists() {
        Long employeeId = 1L;
        Employee employee = new Employee();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        Employee result = employeeService.getEmployeeById(employeeId);

        assertEquals(employee, result);
    }

    @Test
    void getEmployeeById_shouldThrowException_whenEmployeeDoesNotExist() {
        Long employeeId = 1L;
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> employeeService.getEmployeeById(employeeId));
    }

}