package com.example.ratnesh_infoware_task.service.employee;

import com.example.ratnesh_infoware_task.dto.EmployeeDTO;
import com.example.ratnesh_infoware_task.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface EmployeeService {
    void addEmployee(EmployeeDTO employeeDTO);
    Page<Employee> getAllEmployees(int page, int size, String sortBy, Sort.Direction direction);
    void updateEmployee(Long id, EmployeeDTO employeeDTO);
    Employee getEmployeeById(Long id);
    void deleteEmployee(Long id);
}
