package com.myschool.payments.service;

import com.myschool.commons.dto.payments.AddExpense;
import com.myschool.payments.domain.entities.Expenses;
import com.myschool.payments.domain.mapper.ExpenseMapper;
import com.myschool.payments.domain.repository.ExpensesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExpensesService {
    private final ExpensesRepo expensesRepo;
    private final ExpenseMapper expenseMapper;

    public Boolean saveExpense(AddExpense addExpense) {
        Expenses expenses = expenseMapper.dtoToEntity(addExpense);
        if (expenses.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }
        expensesRepo.save(expenses);
        return true;
    }
}
