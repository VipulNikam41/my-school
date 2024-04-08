package com.myschool.constants;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESSFUL_100("Operation successful"),
    FAILURE_200("Operation Failed"),
    LOGIN_100("Login successful"),
    LOGIN_200("Login failed"),
    DATA_200("Data Invalid"),
    REGISTRATION_100("registration success"),
    REGISTRATION_200("registration failed"),
    REGISTRATION_201("user already exists with the given email"),
    NOTIFY_100("Student already exist, do you want to invite him."),
    LECTURE_201("Faulty Lecture, endTime is before startTime"),
    LECTURE_202("Faulty Lecture, overlapping lecture found, delete or edit it before adding lecture in same time frame."),;

    private final String message;

    ResponseCode(String message) {
        this.message = message;
    }

}
