package com.myschool.domain.repository;

import com.myschool.domain.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, UUID> {
}
