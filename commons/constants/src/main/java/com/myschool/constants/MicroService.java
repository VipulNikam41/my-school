package com.myschool.constants;

import lombok.Getter;


@Getter
public enum MicroService {
    EXPLORER("explorer", "student landing page to get filtered institutes according to users needs"),
    MANAGE_OPS("management-ops", "staff/owner registration, student admission, institute/batch/course onboarding, staff attendance"),
    PAYMENTS("payments", "fee records, salary, expense manager"),
    SCHEDULER("scheduler", "all the schedulers"),
    SYLLABUS_HUB("syllabus-hub", "lecture/ exam/ student attendance"),
    USER_DASHBOARD("user-dashboard", "user registration to managing all his institutes, batches, exams, results user has rolled");

    private final String serviceName;
    private final String description;

    MicroService(String serviceName, String description) {
        this.serviceName = serviceName;
        this.description = description;
    }

    public String getService() {
        return Defaults.HTTP + this.serviceName;
    }
}
