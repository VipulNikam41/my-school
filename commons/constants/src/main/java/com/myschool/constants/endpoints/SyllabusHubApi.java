package com.myschool.constants.endpoints;

public class SyllabusHubApi {
    private SyllabusHubApi() {
    }

    public static final String ADD_BACOIN = "bacoin/add";
    public static final String GET_BACOIN = "bacoin/{id}";
    public static final String UPDATE_BACOIN = "bacoin/{id}/update";

    public static final String ADD_LECTURE = "lecture/add";
    public static final String GET_LECTURE_DETAILS = "lecture/{lectureId}";
    public static final String UPDATE_LECTURE_DETAILS = "lecture/{lectureId}/update";

    public static final String MARK_STUDENT_ATTENDANCE = "lecture/{lectureId}/mark";
    public static final String GET_STUDENT_ATTENDANCE = "lecture/{lectureId}/get";
    public static final String UPDATE_STUDENT_ATTENDANCE = "lecture/{lectureId}/update";
    public static final String DELETE_STUDENT_ATTENDANCE = "lecture/{lectureId}/delete";

    public static final String ADD_EXAM = "exam/add";
    public static final String GET_EXAM = "exam/{examId}/get";
    public static final String UPDATE_EXAM = "exam/{examId}/update";

    public static final String ADD_EXAM_RESULT = "exam/result/{examId}/add";
    public static final String GET_EXAM_RESULT = "exam/result/{examId}";
    public static final String UPDATE_EXAM_RESULT = "exam/result/{examId}/update";

}
