package com.myschool.payments.domain.repository;

import com.myschool.payments.domain.entities.FeesRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FeesRecordRepo extends JpaRepository<FeesRecords, UUID> {

}
