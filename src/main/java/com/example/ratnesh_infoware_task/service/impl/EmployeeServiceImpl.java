package com.example.ratnesh_infoware_task.service.impl;

import com.example.ratnesh_infoware_task.payload.request.EmployeeReq;
import com.example.ratnesh_infoware_task.payload.response.EmployeeRes;
import com.example.ratnesh_infoware_task.service.employee.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void addEmployee(EmployeeReq request) {

    }

    @Override
    public Page<EmployeeRes> getAllEmployees() {
        return null;
    }

    @Override
    public void updateEmployee(Long id, EmployeeReq request) {

    }

    @Override
    public EmployeeRes getEmployeeById(Long id) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }
}
