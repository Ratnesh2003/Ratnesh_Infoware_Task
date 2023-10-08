package com.example.ratnesh_infoware_task.repository;

import com.example.ratnesh_infoware_task.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
