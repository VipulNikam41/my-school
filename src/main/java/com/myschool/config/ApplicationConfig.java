package com.myschool.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Value("${flyway.schemas}")
    private String flywaySchema;
    @Value("${flyway.locations}")
    private String flywayLocation;
    @Value("${flyway.cleanDisabled}")
    private boolean flywayClean;
    @Value("${flyway.enabled}")
    private boolean flywayEnabled;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

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
