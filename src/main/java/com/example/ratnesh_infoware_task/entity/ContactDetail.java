package com.example.ratnesh_infoware_task.entity;

import com.example.ratnesh_infoware_task.dto.ContactDetailDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ContactDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String emergencyContact;
    private String phone;

    public ContactDetail (ContactDetailDTO contactDetailDTO) {
        this.emergencyContact = contactDetailDTO.getEmergencyContact();
        this.phone = contactDetailDTO.getPhone();
    }
}
