package com.myschool.manageops.domain.repository;

import com.myschool.manageops.domain.entities.StaffCredentials;
import com.myschool.manageops.domain.entities.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface StaffCredentialsRepo extends JpaRepository<StaffCredentials, UUID> {
}
