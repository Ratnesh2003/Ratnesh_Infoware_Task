package com.example.ratnesh_infoware_task.entity;

import com.example.ratnesh_infoware_task.enums.JobTitle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
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
}
