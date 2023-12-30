package com.myschool.constants.endpoints;

public class DashboardApi {
    private DashboardApi() {}

    public static final String GET_PROFILE = "/profile/get";
    public static final String REGISTER_PROFILE = "/profile/register";
    public static final String UPDATE_PROFILE = "/profile/update/{userId}";

    public static final String GET_INSTITUTES = "/academics/getInstitutes/{userId}";
}
