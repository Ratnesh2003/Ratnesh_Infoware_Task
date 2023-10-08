package com.example.ratnesh_infoware_task.repository;

import com.example.ratnesh_infoware_task.entity.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDetailRepo extends JpaRepository<ContactDetail, Long> {
    void deleteByPhone(String phone);
}
