package com.myschool.payments.controller;

import com.myschool.commons.dto.payments.AddExpense;
import com.myschool.constants.endpoints.PaymentApi;
import com.myschool.payments.service.ExpensesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpensesService expensesService;

    @PostMapping(PaymentApi.ADD_EXPENSE)
    public Boolean addExpense(ServerHttpRequest request, @RequestBody AddExpense expense) {
        return expensesService.saveExpense(expense);
    }
}
