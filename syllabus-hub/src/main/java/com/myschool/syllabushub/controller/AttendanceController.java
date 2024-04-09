package com.myschool.syllabushub.controller;

import com.myschool.commons.dto.syllabushub.AttendanceResponse;
import com.myschool.commons.dto.syllabushub.GetAttendanceRequest;
import com.myschool.commons.dto.syllabushub.LectureResponse;
import com.myschool.commons.dto.syllabushub.MarkAttendance;
import com.myschool.constants.endpoints.SyllabusHubApi;
import com.myschool.syllabushub.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping(SyllabusHubApi.MARK_STUDENT_ATTENDANCE)
    public Boolean markStudentAttendance(@RequestBody MarkAttendance markAttendance) {
        return attendanceService.markStudentAttendance(markAttendance);
    }

    @GetMapping(SyllabusHubApi.GET_STUDENT_ATTENDANCE)
    public List<LectureResponse> getStudentAttendance(@RequestBody GetAttendanceRequest getAttendanceRequest) {
        return attendanceService.getStudentAttendance(getAttendanceRequest);
    }

    @GetMapping(SyllabusHubApi.GET_ATTENDANCE_BY_LECTURE)
    public List<AttendanceResponse> getStudentAttendanceForLecture(@RequestParam UUID lectureId) {
        return attendanceService.getStudentAttendanceForLecture(lectureId);
    }

}
