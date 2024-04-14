package com.myschool.manageops.client;

import com.myschool.commons.dto.payments.AddExpense;
import com.myschool.commons.dto.payments.AddFees;
import com.myschool.commons.dto.payments.AddSalary;
import com.myschool.constants.endpoints.PaymentApi;
import com.myschool.manageops.service.IdValidator;
import com.myschool.manageops.setup.config.ServiceEndpoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentsClient {
    private final IdValidator idValidator;
    private final WebClient.Builder webClientBuilder;
    private final ServiceEndpoint serviceEndpoint;

    public Mono<Boolean> addExpense(AddExpense addExpense) {
        if (!idValidator.staffBelongsToInstitute(addExpense.getInstituteId(), addExpense.getStaffId(), addExpense.getProcessorStaffId())) {
            log.error(this.getClass().getName(), " :: addExpense :: Data manipulation detected");
            return Mono.just(false);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return webClientBuilder.build().post()
                .uri(serviceEndpoint.getPayments() + PaymentApi.ADD_EXPENSE)
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .body(BodyInserters.fromValue(addExpense))
                .retrieve()
                .bodyToMono(Boolean.class);
    }

    public Mono<Boolean> addFees(AddFees addFees) {
        if (!idValidator.staffBelongsToInstitute(addFees.getInstituteId(), addFees.getCashierId())) {
            log.error(this.getClass().getName(), " :: addFees :: Data manipulation detected");
            return Mono.just(false);
        }
        if (!idValidator.studentBelongsToInstitute(addFees.getInstituteId(), addFees.getStudentId())) {
            log.error(this.getClass().getName(), " :: addFees :: Data manipulation detected");
            return Mono.just(false);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return webClientBuilder.build().post()
                .uri(serviceEndpoint.getPayments() + PaymentApi.ADD_FEES_PAYMENT)
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .body(BodyInserters.fromValue(addFees))
                .retrieve()
                .bodyToMono(Boolean.class);
    }

    public Mono<Boolean> addSalary(AddSalary addSalary) {
        if (!idValidator.staffBelongsToInstitute(addSalary.getInstituteId(), addSalary.getProcessorStaffId(), addSalary.getStaffId())) {
            log.error(this.getClass().getName(), " :: addSalary :: Data manipulation detected");
            return Mono.just(false);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return webClientBuilder.build().post()
                .uri(serviceEndpoint.getPayments() + PaymentApi.ADD_SALARY_PAID)
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .body(BodyInserters.fromValue(addSalary))
                .retrieve()
                .bodyToMono(Boolean.class);
    }
}
