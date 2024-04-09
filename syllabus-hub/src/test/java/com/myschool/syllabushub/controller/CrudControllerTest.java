package com.myschool.syllabushub.controller;

import com.myschool.commons.dto.syllabushub.GetAttendanceRequest;
import com.myschool.commons.dto.syllabushub.LectureResponse;
import com.myschool.commons.dto.syllabushub.MarkAttendance;
import com.myschool.constants.endpoints.SyllabusHubApi;
import com.myschool.syllabushub.SyllabusHub;
import com.myschool.syllabushub.controller.crud.AttendanceApisTest;
import com.myschool.syllabushub.controller.crud.BaCoInApisTest;
import com.myschool.syllabushub.controller.crud.LectureApisTest;
import com.myschool.syllabushub.domain.repository.StudentAttendanceRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SpringBootTest(classes = {SyllabusHub.class})
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@ContextConfiguration(classes = {TestClient.class, LectureApisTest.class, BaCoInApisTest.class, AttendanceApisTest.class})
public class CrudControllerTest {
    @Autowired
    private LectureApisTest lectureApisTest;
    @Autowired
    private BaCoInApisTest baCoInApisTest;
    @Autowired
    private AttendanceApisTest attendanceApisTest;

    @Test
    public void testCrudOnLecture() {
        UUID baCoInId = baCoInApisTest.createBaCoInEntry();
        assertNotNull(baCoInId);
        lectureApisTest.createLectureWithFaultyData(baCoInId);
        lectureApisTest.createCorrectLecture(baCoInId);
        lectureApisTest.createOverlappingLectureToCorrectLecture(baCoInId);
        attendanceApisTest.markStudentAttendance(baCoInId);
    }
}
