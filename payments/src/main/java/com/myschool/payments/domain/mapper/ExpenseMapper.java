package com.myschool.payments.domain.mapper;

import com.myschool.commons.dto.payments.AddExpense;
import com.myschool.payments.domain.entities.Expenses;
import org.mapstruct.Mapper;

@Mapper
public interface ExpenseMapper {
    Expenses dtoToEntity(AddExpense expense);
}
