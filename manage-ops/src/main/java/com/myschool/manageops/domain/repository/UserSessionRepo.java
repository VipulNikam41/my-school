package com.myschool.manageops.domain.repository;

import com.myschool.manageops.domain.entities.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public interface UserSessionRepo extends JpaRepository<UserSession, UUID> {
    int countByUserIdAndEndsOnAfter(UUID userId, Date endsOn);

    UserSession findByIdAndUserId(UUID id, UUID userId);
}
