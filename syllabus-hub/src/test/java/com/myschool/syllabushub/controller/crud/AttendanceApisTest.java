package com.myschool.syllabushub.controller.crud;

import com.myschool.commons.dto.syllabushub.GetAttendanceRequest;
import com.myschool.commons.dto.syllabushub.LectureResponse;
import com.myschool.commons.dto.syllabushub.MarkAttendance;
import com.myschool.constants.endpoints.SyllabusHubApi;
import com.myschool.syllabushub.controller.TestClient;
import com.myschool.syllabushub.domain.repository.StudentAttendanceRepo;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class AttendanceApisTest {
    @Autowired
    private TestClient testClient;
    @Autowired
    private StudentAttendanceRepo studentAttendanceRepo;

    @Test
    public void markStudentAttendance(UUID baCoInId) {
        LectureResponse lecture = testClient.getApi(SyllabusHubApi.GET_LECTURE_DETAILS, "baCoInId", baCoInId, LectureResponse.class);
        assertNotNull(lecture);
        MarkAttendance markAttendance = new MarkAttendance();
        markAttendance.setLectureId(lecture.getId());
        markAttendance.setStaffId(UUID.randomUUID());
        List<UUID> studentIds = List.of(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID());
        markAttendance.setStudentIds(studentIds);
        Boolean response = testClient.callApi(SyllabusHubApi.MARK_STUDENT_ATTENDANCE, markAttendance, Boolean.class);
        assertTrue(response);
        GetAttendanceRequest getAttendanceRequest = new GetAttendanceRequest();
        getAttendanceRequest.setStudentId(studentIds.get(0));
        getAttendanceRequest.setFrom(DateUtils.addMinutes(lecture.getStartTime(), -20));
        getAttendanceRequest.setTill(null);
        List<LectureResponse> lectureResponseList = testClient.getApi(SyllabusHubApi.GET_STUDENT_ATTENDANCE, getAttendanceRequest, List.class);
        assertEquals(1, lectureResponseList.size());
        getAttendanceRequest.setFrom(DateUtils.addMinutes(lecture.getStartTime(), 1));
        lectureResponseList = testClient.getApi(SyllabusHubApi.GET_STUDENT_ATTENDANCE, getAttendanceRequest, List.class);
        assertEquals(0, lectureResponseList.size());
    }
}
