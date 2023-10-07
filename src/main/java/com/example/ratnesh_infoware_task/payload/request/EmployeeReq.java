package com.example.ratnesh_infoware_task.payload.request;

import com.example.ratnesh_infoware_task.enums.JobTitle;
import lombok.Data;

@Data
public class EmployeeReq {
    private String name;
    private JobTitle jobTitle;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String state;
}
