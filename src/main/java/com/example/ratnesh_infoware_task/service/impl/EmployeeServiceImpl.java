package com.example.ratnesh_infoware_task.service.impl;

import com.example.ratnesh_infoware_task.dto.ContactDetailDTO;
import com.example.ratnesh_infoware_task.dto.EmployeeDTO;
import com.example.ratnesh_infoware_task.entity.ContactDetail;
import com.example.ratnesh_infoware_task.entity.Employee;
import com.example.ratnesh_infoware_task.repository.ContactDetailRepo;
import com.example.ratnesh_infoware_task.repository.EmployeeRepo;
import com.example.ratnesh_infoware_task.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final ContactDetailRepo contactDetailRepo;

    @Override
    public void addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);

        if (employeeRepo.existsByEmail(employee.getEmail()) || employeeRepo.existsByPhone(employee.getPhone())) {
            throw new RuntimeException("Employee with email " + employee.getEmail() + " already exists");
        }

        for (ContactDetailDTO contactDetailDTO : employeeDTO.getContactDetails()) {
            ContactDetail contactDetail = new ContactDetail(contactDetailDTO);
            var savedContactDetail = contactDetailRepo.save(contactDetail);
            employee.getContactDetails().add(savedContactDetail);
        }
        employeeRepo.save(employee);
        log.info("Employee added: {}", employee);
    }

    @Override
    public Page<Employee> getAllEmployees(int page, int size, String sortBy, Sort.Direction direction) {
        var pageRequest = PageRequest.of(page, size, direction, sortBy);
        return employeeRepo.findAll(pageRequest);
    }

    @Override
    @Transactional
    public void updateEmployee(Long id, EmployeeDTO employeeDTO) {
        var employee = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setId(id);
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setJobTitle(employeeDTO.getJobTitle());
        employee.setCity(employeeDTO.getCity());
        employee.setAddress(employeeDTO.getAddress());
        employee.setState(employeeDTO.getState());
        employee.setPhone(employeeDTO.getPhone());

        employee.getContactDetails().clear();

        for (ContactDetailDTO contactDetailDTO : employeeDTO.getContactDetails()) {
            ContactDetail contactDetail = new ContactDetail(contactDetailDTO);
            var savedContactDetail = contactDetailRepo.save(contactDetail);
            employee.getContactDetails().add(savedContactDetail);
        }
        employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}
