package com.myschool.manageops.client;

import com.myschool.commons.dto.payments.AddExpense;
import com.myschool.commons.dto.payments.AddFees;
import com.myschool.commons.dto.payments.AddSalary;
import com.myschool.commons.dto.syllabushub.*;
import com.myschool.constants.Param;
import com.myschool.constants.endpoints.PaymentApi;
import com.myschool.constants.endpoints.SyllabusHubApi;
import com.myschool.manageops.service.IdValidator;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

import static com.myschool.constants.MicroService.PAYMENTS;
import static com.myschool.constants.MicroService.SYLLABUS_HUB;

@Service
@Slf4j
@RequiredArgsConstructor
public class SyllabusHubClient {
    private final WebClient.Builder webClientBuilder;

    public Mono<Boolean> markStudentAttendance(MarkAttendance markAttendance) {
        return webClientBuilder.build().post()
                .uri(SYLLABUS_HUB.getService() + SyllabusHubApi.MARK_STUDENT_ATTENDANCE)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(markAttendance))
                .retrieve()
                .bodyToMono(Boolean.class);
    }

    public Mono<List<LectureResponse>> getStudentAttendance(GetAttendanceRequest getAttendanceRequest) {
        if (!isStudentSelfChecking(getAttendanceRequest) && !isInstituteStaff(getAttendanceRequest) && !isGuardian(getAttendanceRequest)) {
            log.error(this.getClass().getName(), " :: getStudentAttendance :: access denied");
            return null;
        }

        return webClientBuilder.build().method(HttpMethod.GET)
                .uri(SYLLABUS_HUB.getService() + SyllabusHubApi.GET_STUDENT_ATTENDANCE)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(getAttendanceRequest))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
    }

    private boolean isGuardian(GetAttendanceRequest getAttendanceRequest) {
        return getAttendanceRequest.getCurrentLoggedInUser() != null;
    }

    private boolean isInstituteStaff(GetAttendanceRequest getAttendanceRequest) {
        return getAttendanceRequest.getCurrentLoggedInUser() != null;
    }

    private boolean isStudentSelfChecking(GetAttendanceRequest getAttendanceRequest) {
        return getAttendanceRequest.getStudentId().equals(getAttendanceRequest.getCurrentLoggedInUser());
    }

    public Mono<List<AttendanceResponse>> getStudentAttendanceForLecture(UUID lectureId) {
        return webClientBuilder.build().get()
                .uri(UriComponentsBuilder.fromUriString(SYLLABUS_HUB.getService())
                        .path(SyllabusHubApi.GET_ATTENDANCE_BY_LECTURE)
                        .queryParam(Param.LECTURE_ID, lectureId)
                        .build().toUri()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
    }

    public Mono<UUID> addBaCoIn(AddBaCoIn addBaCoIn) {
        return webClientBuilder.build().post()
                .uri(SYLLABUS_HUB.getService() + SyllabusHubApi.ADD_BACOIN)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(addBaCoIn))
                .retrieve()
                .bodyToMono(UUID.class);
    }

    public Mono<LectureResponse> getLectureDetails(UUID lectureId, UUID baCoInId) {
        return webClientBuilder.build().get()
                .uri(UriComponentsBuilder.fromUriString(SYLLABUS_HUB.getService())
                        .path(SyllabusHubApi.GET_LECTURE_DETAILS)
                        .queryParam(Param.LECTURE_ID, lectureId)
                        .queryParam(Param.BACOIN_ID, baCoInId)
                        .build().toUri()
                )
                .retrieve()
                .bodyToMono(LectureResponse.class);
    }

    public Mono<LectureResponse> addLecture(LectureRequest lectureRequest) {
        return webClientBuilder.build().post()
                .uri(SYLLABUS_HUB.getService() + SyllabusHubApi.ADD_LECTURE)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(lectureRequest))
                .retrieve()
                .bodyToMono(LectureResponse.class);
    }
}
