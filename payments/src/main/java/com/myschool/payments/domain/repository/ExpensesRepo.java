package com.myschool.payments.domain.repository;

import com.myschool.payments.domain.entities.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExpensesRepo extends JpaRepository<Expenses, UUID> {

}
