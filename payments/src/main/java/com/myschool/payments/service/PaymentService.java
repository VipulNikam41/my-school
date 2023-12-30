package com.myschool.payments.service;

import com.myschool.commons.dto.InstituteResponse;
import com.myschool.commons.dto.LocationCords;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    public List<InstituteResponse> addExpense(LocationCords cords) {
        return null;
    }
}
