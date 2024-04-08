package com.myschool.syllabushub.controller.crud;

import com.myschool.commons.dto.syllabushub.LectureRequest;
import com.myschool.commons.dto.syllabushub.LectureResponse;
import com.myschool.constants.ResponseCode;
import com.myschool.constants.endpoints.SyllabusHubApi;
import com.myschool.syllabushub.controller.TestClient;
import com.myschool.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class LectureApisTest {
    @Autowired
    private TestClient testClient;

    public void createLectureWithFaultyData(UUID baCoInId) {
        LectureRequest lectureRequest = new LectureRequest();
        lectureRequest.setName("Science lecture for chapter 2");
        lectureRequest.setDescription("2nd lecture, with detailed example will be taught");
        lectureRequest.setBaCoInId(baCoInId);
        lectureRequest.setStartTime(DateUtils.getDate(2023, Calendar.AUGUST, 1,3,3,4));
        lectureRequest.setEndTime(DateUtils.getDate(2023, Calendar.AUGUST, 1,2,3,4));
        LectureResponse lectureResponse = testClient.callApi(SyllabusHubApi.ADD_LECTURE, lectureRequest, LectureResponse.class);
        assertEquals(ResponseCode.LECTURE_201, lectureResponse.getApiResponseStatus().getCode());
    }

    public void createCorrectLecture(UUID baCoInId) {
        LectureRequest lectureRequest = new LectureRequest();
        lectureRequest.setName("Science lecture for chapter 2");
        lectureRequest.setDescription("2nd lecture, with detailed example will be taught");
        lectureRequest.setBaCoInId(baCoInId);
        lectureRequest.setStartTime(DateUtils.getDate(2023, Calendar.AUGUST, 1,2,3,4));
        lectureRequest.setEndTime(DateUtils.getDate(2023, Calendar.AUGUST, 1,3,3,4));
        LectureResponse lectureResponse = testClient.callApi(SyllabusHubApi.ADD_LECTURE, lectureRequest, LectureResponse.class);
        assertEquals(ResponseCode.SUCCESSFUL_100, lectureResponse.getApiResponseStatus().getCode());
    }

    public void createOverlappingLectureToCorrectLecture(UUID baCoInId) {
        LectureRequest lectureRequest = new LectureRequest();
        lectureRequest.setName("Science lecture for chapter 2");
        lectureRequest.setDescription("2nd lecture, with detailed example will be taught");
        lectureRequest.setBaCoInId(baCoInId);
        lectureRequest.setStartTime(DateUtils.getDate(2023, Calendar.AUGUST, 1,2,3,5));
        lectureRequest.setEndTime(DateUtils.getDate(2023, Calendar.AUGUST, 1,3,3,5));
        LectureResponse lectureResponse = testClient.callApi(SyllabusHubApi.ADD_LECTURE, lectureRequest, LectureResponse.class);
        assertEquals(ResponseCode.LECTURE_202, lectureResponse.getApiResponseStatus().getCode());
    }
}
