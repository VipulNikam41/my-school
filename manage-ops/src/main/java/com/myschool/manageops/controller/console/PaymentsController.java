package com.myschool.manageops.controller.console;

import com.myschool.commons.dto.payments.AddExpense;
import com.myschool.commons.dto.payments.AddFees;
import com.myschool.commons.dto.payments.AddSalary;
import com.myschool.constants.endpoints.PaymentApi;
import com.myschool.manageops.auth.Authorizer;
import com.myschool.manageops.client.PaymentsClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class PaymentsController {
    private final Authorizer authorizer;
    private final PaymentsClient paymentsClient;

    @PostMapping(PaymentApi.ADD_EXPENSE)
    public Mono<Boolean> addExpense(ServerHttpRequest request, @RequestBody AddExpense expense) {
        if(!authorizer.setLoggedInUser(expense, request) ||
                !expense.getProcessorStaffId().equals(expense.getCurrentLoggedInUser())) {
            return Mono.just(false);
        }
        return paymentsClient.addExpense(expense);
    }

    @PostMapping(PaymentApi.ADD_FEES_PAYMENT)
    public Mono<Boolean> addFees(ServerHttpRequest request, @RequestBody AddFees addFees) {
        if(!authorizer.setLoggedInUser(addFees, request) ||
                !addFees.getCashierId().equals(addFees.getCurrentLoggedInUser())) {
            return Mono.just(false);
        }
        return paymentsClient.addFees(addFees);
    }

    @PostMapping(PaymentApi.ADD_SALARY_PAID)
    public Mono<Boolean> addSalary(ServerHttpRequest request, @RequestBody AddSalary addSalary) {
        if(!authorizer.setLoggedInUser(addSalary, request) ||
                !addSalary.getProcessorStaffId().equals(addSalary.getCurrentLoggedInUser())) {
            return Mono.just(false);
        }
        return paymentsClient.addSalary(addSalary);
    }
}
