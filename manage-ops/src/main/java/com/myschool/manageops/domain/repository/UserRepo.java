package com.myschool.manageops.domain.repository;

import com.myschool.manageops.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    @Query("Select u FROM User u " +
            "WHERE (u.contact.email = :email AND u.contact.emailVerified = true) " +
            "OR (u.contact.phoneNumber = :phoneNumber AND u.contact.phoneNumberVerified = true)")
    List<User> getStudentByContact(@Param("email") String email, @Param("phoneNumber") String phoneNumber);

    @Query("Select u FROM User u " +
            "WHERE u.contact.email = :email " +
            "OR u.contact.phoneNumber = :phoneNumber")
    List<User> getUserByContact(@Param("email") String email, @Param("phoneNumber") String phoneNumber);

    @Query("Select u FROM User u " +
            "WHERE u.contact.email = :email AND u.contact.emailVerified = true")
    User getUserByVerifiedEmail(@Param("email") String email);

    List<User> findByContactEmail(String email);

    @Query("Select u FROM User u " +
            "WHERE u.contact.phoneNumber = :phoneNumber AND u.contact.phoneNumberVerified = true")
    User getUserByVerifiedPhone(String phoneNumber);

    List<User> findByContactPhoneNumber(String phoneNumber);

    @Query("SELECT u FROM User u " +
            "INNER JOIN BatchStudents bs ON u.id = bs.studentId " +
            "INNER JOIN Batch b ON b.id = bs.batchId " +
            "WHERE b.instituteId = :instituteId " +
            "AND u.contact.email = :email " +
            "OR u.contact.phoneNumber = :phoneNumber")
    List<User> getStudentByContactForInstitute(String email, String phoneNumber, UUID instituteId);
}
