package com.myschool.payments.controller;

import com.myschool.commons.dto.InstituteResponse;
import com.myschool.commons.dto.LocationCords;
import com.myschool.constants.endpoints.PaymentApi;
import com.myschool.payments.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserLandingPage {
    private final PaymentService paymentService;

    @GetMapping(PaymentApi.ADD_EXPENSE)
    public List<InstituteResponse> addExpense(@RequestBody LocationCords cords) {
        return paymentService.addExpense(cords);
    }
}
