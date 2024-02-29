package com.myschool.manageops.client;

import com.myschool.commons.dto.UserResponse;
import com.myschool.constants.endpoints.PaymentApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

import static com.myschool.constants.MicroService.PAYMENTS;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentsClient {
    private final WebClient.Builder webClientBuilder;

    public UserResponse addExpense(UUID id) {
        return webClientBuilder.build().get()
                .uri(PAYMENTS.getService() + PaymentApi.ADD_EXPENSE.replace("{userId}", id.toString()))
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();
    }
}
