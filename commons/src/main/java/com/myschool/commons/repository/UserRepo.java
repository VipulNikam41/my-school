package com.myschool.commons.repository;

import com.myschool.commons.entities.User;
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
            "WHERE u.contact.email = :email AND u.contact.emailVerified = true")
    User getStudentByEmail(@Param("email") String email);

    @Query("Select u FROM User u " +
            "WHERE u.contact.phoneNumber = :phoneNumber AND u.contact.phoneNumberVerified = true")
    User getStudentByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
