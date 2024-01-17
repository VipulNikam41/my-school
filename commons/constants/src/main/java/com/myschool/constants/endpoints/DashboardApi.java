package com.myschool.constants.endpoints;

public class DashboardApi {
    private DashboardApi() {}

    private static final String ROUTE = "/dashboard";

    public static final String REGISTER_PROFILE = ROUTE + "/profile/register";
    public static final String GET_PROFILE = ROUTE + "/profile/{userId}/get";
    public static final String UPDATE_PROFILE = ROUTE + "/profile/update/{userId}";

    public static final String ADD_GUARDIAN = ROUTE + "/profile/register";
    public static final String GET_GUARDIAN = ROUTE + "/profile/getGuardian/{userId}";
    public static final String UPDATE_GUARDIAN = ROUTE + "/profile/updateGuardian/{userId}";
    public static final String REMOVE_GUARDIAN = ROUTE + "/profile/removeGuardian/{userId}";

    public static final String GET_INSTITUTES = ROUTE + "/academics/getInstitute/{userId}";
    public static final String GET_BATCHES = ROUTE + "/academics/getBatches/{userId}";
    public static final String GET_COURSES = ROUTE + "/academics/getCourse/{userId}";

    public static final String GET_LECTURES = ROUTE + "/academics/lectures/{userId}";
    public static final String GET_ATTENDANCE = ROUTE + "/academics/exams/{userId}";
    public static final String GET_EXAMS = ROUTE + "/academics/exams/{userId}";
}
