package com.myschool.commons.domain.repository;

import com.myschool.commons.domain.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StaffRepo extends JpaRepository<Staff, UUID> {
}
