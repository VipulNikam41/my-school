package com.myschool.constants.endpoints;

public class DashboardApi {
    private DashboardApi() {}

    public static final String REGISTER_PROFILE = "/profile/register";
    public static final String GET_PROFILE = "/profile/{userId}/get";
    public static final String UPDATE_PROFILE = "/profile/update/{userId}";

    public static final String ADD_GUARDIAN = "/profile/register";
    public static final String GET_GUARDIAN = "/profile/getGuardian/{userId}";
    public static final String UPDATE_GUARDIAN = "/profile/updateGuardian/{userId}";
    public static final String REMOVE_GUARDIAN = "/profile/removeGuardian/{userId}";

    public static final String GET_INSTITUTES = "/academics/getInstitute/{userId}";
    public static final String GET_BATCHES = "/academics/getBatches/{userId}";
    public static final String GET_COURSES = "/academics/getCourse/{userId}";

    public static final String GET_LECTURES = "/academics/lectures/{userId}";
    public static final String GET_ATTENDANCE = "/academics/exams/{userId}";
    public static final String GET_EXAMS = "/academics/exams/{userId}";
}
