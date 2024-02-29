package com.myschool.manageops.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter implements WebFilter {
    private final SessionService sessionService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return chain.filter(exchange);
    }

//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        HttpHeaders headers = request.getHeaders();
//        String token = headers.getFirst(HttpHeaders.AUTHORIZATION);
//
//        String userId = String.valueOf(sessionService.authenticateSession(token));
//
//        Flux<DataBuffer> modifiedBody = request.getBody().map(dataBuffer -> {
//            byte[] bytes = new byte[dataBuffer.readableByteCount()];
//            dataBuffer.read(bytes);
//            String payload = new String(bytes);
//            payload = addCurrentLoggedInUserField(payload, userId);
//            bytes = payload.getBytes();
//            return exchange.getResponse().bufferFactory().wrap(bytes);
//        });
//
//        ServerHttpRequest modifiedRequest = new ServerHttpRequestDecorator(exchange.getRequest()) {
//            @Override
//            public Flux<DataBuffer> getBody() {
//                return modifiedBody;
//            }
//        };
//
//        return chain.filter(exchange.mutate().request(modifiedRequest).build());
//    }

    private String addCurrentLoggedInUserField(String payload, String value) {
        return payload.replaceFirst("\\{", "{\"currentLoggedInUser\":\"" + value + "\",");
    }
}
