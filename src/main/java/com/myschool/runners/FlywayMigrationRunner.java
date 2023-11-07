package com.myschool.runners;

import org.flywaydb.core.Flyway;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FlywayMigrationRunner implements ApplicationRunner {
    private final Flyway flyway;

    public FlywayMigrationRunner(Flyway flyway) {
        this.flyway = flyway;
    }

    @Override
    public void run(ApplicationArguments args) {
        flyway.migrate();
    }
}
