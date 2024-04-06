package com.myschool.payments.controller;

import com.myschool.commons.dto.payments.AddFees;
import com.myschool.constants.endpoints.PaymentApi;
import com.myschool.payments.service.FeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FeesController {
    private final FeesService feesService;

    @PostMapping(PaymentApi.ADD_FEES_PAYMENT)
    public Boolean addExpense(ServerHttpRequest request, @RequestBody AddFees addFees) {
        return feesService.saveExpense(addFees);
    }
}
