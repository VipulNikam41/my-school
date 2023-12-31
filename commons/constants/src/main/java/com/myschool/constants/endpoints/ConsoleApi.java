package com.myschool.constants.endpoints;

public class ConsoleApi {
    private ConsoleApi() {}

    public static final String REGISTER_OWNER = "/console/register/owner";
    public static final String ADD_INSTITUTE = "/console/add";
    public static final String ADD_SUB_INSTITUTE = "/console/{instituteId}/add";
    public static final String GET_INSTITUTES_BY_OWNER = "/console/owner/{ownerId}";
    public static final String ADD_STAFF = "/console/{instituteId}/staff/add";
    public static final String UPDATE_STAFF = "/console/{instituteId}/staff/update";

    public static final String ADD_BATCH = "/staff/{instituteId}/batch/add";
    public static final String GET_BATCHES = "/staff/{instituteId}/batch/get";
    public static final String UPDATE_BATCH = "/staff/{instituteId}/batch/update";

    public static final String ADD_COURSE = "/staff/{instituteId}/course/add";
    public static final String GET_COURSE = "/staff/{instituteId}/course/get";
    public static final String UPDATE_COURSE = "/staff/{instituteId}/course/update";

    public static final String ADD_STUDENT = "/staff/{instituteId}/batch/student/add";
    public static final String GET_STUDENT = "/staff/{instituteId}/batch/{batchId}/student/get";
    public static final String GET_STUDENT_BY_COURSE = "/staff/{instituteId}/course/{courseId}/student/get";
    public static final String UPDATE_STUDENT = "/staff/{instituteId}/batch/{batchId}/student/update";

    public static final String MARK_STAFF_ATTENDANCE = "/staff/{instituteId}/{staffId}";

}
