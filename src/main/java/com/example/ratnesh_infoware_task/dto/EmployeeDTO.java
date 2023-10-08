package com.example.ratnesh_infoware_task.dto;

import com.example.ratnesh_infoware_task.enums.JobTitle;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class EmployeeDTO {
    private String id;
    private String name;
    private JobTitle jobTitle;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String state;
    private List<ContactDetailDTO> contactDetails = new ArrayList<>();
}
