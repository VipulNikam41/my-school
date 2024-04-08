package com.myschool.payments.controller;

import com.myschool.commons.dto.payments.AddSalary;
import com.myschool.constants.endpoints.PaymentApi;
import com.myschool.payments.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SalaryController {
    private final SalaryService salaryService;

    @PostMapping(PaymentApi.ADD_SALARY_PAID)
    public Boolean addExpense(ServerHttpRequest request, @RequestBody AddSalary addSalary) {
        return salaryService.saveSalary(addSalary);
    }
}
