package com.myschool.manageops.controller;

import com.myschool.commons.dto.StatefulRequest;
import com.myschool.commons.dto.syllabushub.*;
import com.myschool.constants.endpoints.DashboardApi;
import com.myschool.constants.endpoints.SyllabusHubApi;
import com.myschool.manageops.auth.Authorizer;
import com.myschool.manageops.client.SyllabusHubClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SyllabusHubController {
    private final Authorizer authorizer;
    private final SyllabusHubClient syllabusHubClient;

    @PostMapping(DashboardApi.APP_ROUTE + SyllabusHubApi.MARK_STUDENT_ATTENDANCE)
    public Mono<Boolean> markStudentAttendance(ServerHttpRequest request, @RequestBody MarkAttendance markAttendance) {
        if(!authorizer.setLoggedInUser(markAttendance, request)) {
            return Mono.just(false);
        }
        return syllabusHubClient.markStudentAttendance(markAttendance);
    }

    @PostMapping(DashboardApi.APP_ROUTE + SyllabusHubApi.GET_STUDENT_ATTENDANCE)
    public Mono<List<LectureResponse>> getStudentAttendance(ServerHttpRequest request, @RequestBody GetAttendanceRequest getAttendanceRequest) {
        if(!authorizer.setLoggedInUser(getAttendanceRequest, request)) {
            return null;
        }
        return syllabusHubClient.getStudentAttendance(getAttendanceRequest);
    }

    @PostMapping(DashboardApi.APP_ROUTE + SyllabusHubApi.GET_ATTENDANCE_BY_LECTURE)
    public Mono<List<AttendanceResponse>> getStudentAttendanceForLecture(ServerHttpRequest request, @RequestParam UUID lectureId) {
        StatefulRequest statefulRequest = new StatefulRequest();
        if(!authorizer.setLoggedInUser(statefulRequest, request)) {
            return null;
        }
        return syllabusHubClient.getStudentAttendanceForLecture(lectureId);
    }

    @PostMapping(DashboardApi.APP_ROUTE + SyllabusHubApi.ADD_BACOIN)
    public Mono<UUID> addBaCoIn(ServerHttpRequest request, @RequestBody AddBaCoIn addBaCoIn) {
        if(!authorizer.setLoggedInUser(addBaCoIn, request)) {
            return Mono.just(null);
        }
        return syllabusHubClient.addBaCoIn(addBaCoIn);
    }

    @PostMapping(DashboardApi.APP_ROUTE + SyllabusHubApi.GET_LECTURE_DETAILS)
    public Mono<LectureResponse> getLectureDetails(ServerHttpRequest request, @RequestParam(required = false) UUID lectureId, @RequestParam(required = false) UUID baCoInId) {
        StatefulRequest statefulRequest = new StatefulRequest();
        if(!authorizer.setLoggedInUser(statefulRequest, request)) {
            return null;
        }
        return syllabusHubClient.getLectureDetails(lectureId, baCoInId);
    }

    @PostMapping(DashboardApi.APP_ROUTE + SyllabusHubApi.ADD_LECTURE)
    public Mono<LectureResponse> addLecture(ServerHttpRequest request, @RequestBody LectureRequest lectureRequest) {
        if(!authorizer.setLoggedInUser(lectureRequest, request)) {
            return null;
        }
        return syllabusHubClient.addLecture(lectureRequest);
    }
}
