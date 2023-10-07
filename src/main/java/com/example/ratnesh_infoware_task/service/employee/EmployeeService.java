package com.example.ratnesh_infoware_task.service.employee;

import com.example.ratnesh_infoware_task.payload.request.EmployeeReq;
import com.example.ratnesh_infoware_task.payload.response.EmployeeRes;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    void addEmployee(EmployeeReq request);
    Page<EmployeeRes> getAllEmployees();
    void updateEmployee(Long id, EmployeeReq request);
    EmployeeRes getEmployeeById(Long id);
    void deleteEmployee(Long id);
}
