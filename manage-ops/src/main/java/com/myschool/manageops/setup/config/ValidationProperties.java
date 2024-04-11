package com.myschool.manageops.setup.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
@ConfigurationProperties("validation")
public class ValidationProperties {
    private List<String> excludedPaths;

    public List<String> getExcludedPaths() {
        return excludedPaths;
    }

    public void setExcludedPaths(List<String> excludedPaths) {
        this.excludedPaths = excludedPaths;
    }

    public boolean exclude(ServerWebExchange exchange) {
        for (String regex : excludedPaths) {
            if (exchange.getRequest().getURI().getPath().matches(regex)) {
                return true;
            }
        }
        return false;
    }
}
