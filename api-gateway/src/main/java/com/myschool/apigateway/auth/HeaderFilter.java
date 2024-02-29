package com.myschool.apigateway.auth;

import com.myschool.constants.endpoints.DashboardApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HeaderFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst(HttpHeaders.AUTHORIZATION);

        if (exchange.getRequest().getPath().pathWithinApplication().value().equals(DashboardApi.USER_LOGIN)) {
            return chain.filter(exchange).doOnSuccess(unused -> {
                        System.out.println("Redirect URL: " + exchange.getResponse().getHeaders().getLocation());
                    })
                    .doOnError(throwable -> {
                        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
                        System.out.println("Error occurred: " + throwable.getCause() + exchange.getResponse().getHeaders().getLocation());
                    });
        }
        if (exchange.getRequest().getPath().pathWithinApplication().value().contains("eureka")) {
            return chain.filter(exchange);
        }

        if (token != null) {
            return chain.filter(exchange);
        }

        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();

    }
}
