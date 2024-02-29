package com.myschool.apigateway.config;

import com.myschool.apigateway.auth.HeaderFilter;
import com.myschool.constants.endpoints.DashboardApi;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final HeaderFilter headerFilter;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
        serverHttpSecurity
                .csrf().disable()
                .authorizeExchange()
                    .pathMatchers("/eureka/**").permitAll()
                    .pathMatchers(DashboardApi.USER_LOGIN).permitAll()
                    .anyExchange().authenticated().and()
                .addFilterBefore(headerFilter, SecurityWebFiltersOrder.FIRST)
                .formLogin().disable()
                .httpBasic().disable();

        return serverHttpSecurity.build();
    }
}
