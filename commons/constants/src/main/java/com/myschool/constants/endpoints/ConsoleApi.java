package com.myschool.constants.endpoints;

public class ConsoleApi {
    private ConsoleApi() {}

    private static final String ROUTE = "/console";

    public static final String REGISTER_OWNER = ROUTE + "/register/owner";
    public static final String ADD_INSTITUTE = ROUTE + "/add";
    public static final String ADD_SUB_INSTITUTE = ROUTE + "/{instituteId}/add";
    public static final String GET_INSTITUTES_BY_OWNER = ROUTE + "/owner/{ownerId}";

    public static final String ADD_STAFF = ROUTE + "/{instituteId}/staff/add";
    public static final String GET_STAFF = ROUTE + "/{instituteId}/staff/get";
    public static final String UPDATE_STAFF = ROUTE + "/{instituteId}/staff/update";

    public static final String ADD_BATCH = ROUTE + "/staff/{instituteId}/batch/add";
    public static final String GET_BATCHES = ROUTE + "/staff/{instituteId}/batch/get";
    public static final String UPDATE_BATCH = ROUTE + "/staff/{instituteId}/batch/update";

    public static final String ADD_COURSE = ROUTE + "/staff/{instituteId}/course/add";
    public static final String GET_COURSE = ROUTE + "/staff/{instituteId}/course/get";
    public static final String UPDATE_COURSE = ROUTE + "/staff/{instituteId}/course/update";

    public static final String ADD_STUDENT = ROUTE + "/staff/{instituteId}/student/add";
    public static final String GET_STUDENT = ROUTE + "/staff/{instituteId}/student/get";
    public static final String UPDATE_STUDENT = ROUTE + "/staff/{instituteId}/student/update";

    public static final String MARK_STAFF_ATTENDANCE = ROUTE + "/staff/{instituteId}/{staffId}";

}
