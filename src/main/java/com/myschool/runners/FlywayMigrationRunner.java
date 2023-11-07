package com.myschool.runners;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FlywayMigrationRunner implements ApplicationRunner {
    @Autowired
    private Flyway flyway;

    @Override
    public void run(ApplicationArguments args) {
        log.info(this.getClass().getSimpleName()+ ", Running flyway migration");
        flyway.migrate();
        log.info(this.getClass().getSimpleName() + ", Flyway migration completed");
    }
}
