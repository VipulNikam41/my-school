package com.myschool.manageops.domain.repository;

import com.myschool.manageops.domain.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StaffRepo extends JpaRepository<Staff, UUID> {
    @Query("SELECT COUNT(s) = :numStaffIds FROM Staff s " +
            "WHERE s.instituteId = :instituteId AND s.id IN (:staffIds)")
    boolean checkStaffBelongsToInstitute(UUID instituteId, int numStaffIds, UUID... staffIds);

    Optional<Staff> findByContactEmailAndInstituteId(String email, UUID instituteId);

    Optional<Staff> findByContactPhoneNumberAndInstituteId(String phoneNumber, UUID instituteId);
}
