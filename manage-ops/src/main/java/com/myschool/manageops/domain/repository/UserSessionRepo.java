package com.myschool.manageops.domain.repository;

import com.myschool.manageops.domain.entities.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserSessionRepo extends JpaRepository<UserSession, UUID> {
    @Query("SELECT us FROM UserSession us " +
            "WHERE us.userId = :userId " +
            "AND us.endsOn > CURRENT_TIMESTAMP")
    List<UserSession> getActiveSessionForUser(UUID userId);

    UserSession findByIdAndUserId(UUID id, UUID userId);
}
