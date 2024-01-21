package com.myschool.manageops.config;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final Environment environment;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.flyway.schemas}")
    private String flywaySchema;
    @Value("${spring.flyway.locations}")
    private String flywayLocation;
    @Value("${spring.flyway.cleanDisabled}")
    private boolean flywayClean;
    @Value("${spring.flyway.enabled}")
    private boolean flywayEnabled;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public Flyway flyway() {
        return Flyway.configure().dataSource(dataSource())
                .locations(flywayLocation)
                .schemas(flywaySchema)
                .cleanDisabled(flywayClean)
                .baselineOnMigrate(flywayEnabled)
                .load();
    }
}
