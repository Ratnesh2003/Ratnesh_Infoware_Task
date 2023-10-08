package com.example.ratnesh_infoware_task.entity;

import com.example.ratnesh_infoware_task.enums.JobTitle;
import com.example.ratnesh_infoware_task.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private JobTitle jobTitle;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;
    private String address;
    private String city;
    private String state;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ContactDetail> contactDetails = new ArrayList<>();

    public Employee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.jobTitle = employeeDTO.getJobTitle();
        this.phone = employeeDTO.getPhone();
        this.email = employeeDTO.getEmail();
        this.address = employeeDTO.getAddress();
        this.city = employeeDTO.getCity();
        this.state = employeeDTO.getState();
    }

}
