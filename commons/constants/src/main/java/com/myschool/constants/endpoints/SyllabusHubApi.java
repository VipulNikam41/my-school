package com.myschool.constants.endpoints;

public class SyllabusHubApi {
    private SyllabusHubApi() {
    }

    private static final String ROUTE_ATTENDANCE = "/attendance";
    private static final String ROUTE_LECTURE = "/lecture";
    private static final String ROUTE_BACOIN = "/bacoin";

    public static final String ADD_BACOIN = ROUTE_BACOIN + "/add";
    public static final String GET_BACOIN = ROUTE_BACOIN + "/{id}";
    public static final String UPDATE_BACOIN = ROUTE_BACOIN + "/{id}/update";

    public static final String ADD_LECTURE = ROUTE_LECTURE + "/add";
    public static final String GET_LECTURE_DETAILS = ROUTE_LECTURE + "/get";
    public static final String UPDATE_LECTURE_DETAILS = ROUTE_LECTURE + "/{lectureId}/update";

    public static final String MARK_STUDENT_ATTENDANCE = ROUTE_ATTENDANCE + "/lecture/mark";
    public static final String GET_STUDENT_ATTENDANCE = ROUTE_ATTENDANCE + "/lecture/get-lectures";
    public static final String GET_ATTENDANCE_BY_LECTURE = ROUTE_ATTENDANCE +"/lecture/get-students";
    public static final String UPDATE_STUDENT_ATTENDANCE = ROUTE_ATTENDANCE +"/lecture/{lectureId}/update";
    public static final String DELETE_STUDENT_ATTENDANCE = ROUTE_ATTENDANCE +"/lecture/{lectureId}/delete";

    public static final String ADD_EXAM = ROUTE_LECTURE + "/exam/add";
    public static final String GET_EXAM = ROUTE_LECTURE + "/exam/{examId}/get";
    public static final String UPDATE_EXAM = ROUTE_LECTURE + "/exam/{examId}/update";

    public static final String ADD_EXAM_RESULT = ROUTE_LECTURE + "/exam/result/{examId}/add";
    public static final String GET_EXAM_RESULT = ROUTE_LECTURE + "/exam/result/";
    public static final String UPDATE_EXAM_RESULT = ROUTE_LECTURE + "/exam/result/{examId}/update";

}
