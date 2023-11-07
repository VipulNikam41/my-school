package com.myscool.constants;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESSFUL_100("Operation successful"),
    FAILURE_200("Operation Failed"),
    LOGIN_100("Login successful"),
    LOGIN_200("Login failed");

    private final String message;

    ResponseCode(String message) {
        this.message = message;
    }

}
