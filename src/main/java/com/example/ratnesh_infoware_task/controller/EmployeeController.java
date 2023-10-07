package com.example.ratnesh_infoware_task.controller;

import com.example.ratnesh_infoware_task.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee) {
        try {
            return ResponseEntity.ok(employeeService.addEmployee());
        } catch (Exception e) {
            log.error("Error while adding employee", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEmployees() {
        try {
            return ResponseEntity.ok(employeeService.getAllEmployees());
        } catch (Exception e) {
            log.error("Error while getting all employees", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(employeeService.updateEmployee(id));
        } catch (Exception e) {
            log.error("Error while updating employee", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(employeeService.getEmployeeById(id));
        } catch (Exception e) {
            log.error("Error while getting employee by id", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
