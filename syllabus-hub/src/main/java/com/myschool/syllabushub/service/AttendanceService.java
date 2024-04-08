package com.myschool.syllabushub.service;

import com.myschool.commons.dto.syllabushub.AttendanceResponse;
import com.myschool.commons.dto.syllabushub.GetAttendanceRequest;
import com.myschool.commons.dto.syllabushub.LectureResponse;
import com.myschool.commons.dto.syllabushub.MarkAttendance;
import com.myschool.syllabushub.domain.entities.Lecture;
import com.myschool.syllabushub.domain.entities.StudentAttendance;
import com.myschool.syllabushub.domain.mapper.AttendanceMapper;
import com.myschool.syllabushub.domain.mapper.LectureMapper;
import com.myschool.syllabushub.domain.repository.StudentAttendanceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final StudentAttendanceRepo studentAttendanceRepo;

    private final AttendanceMapper attendanceMapper;
    private final LectureMapper lectureMapper;

    public Boolean markStudentAttendance(MarkAttendance markAttendance) {
        List<StudentAttendance> studentAttendanceList = attendanceMapper.markAttendanceToStudentAttendance(markAttendance);
        studentAttendanceRepo.saveAll(studentAttendanceList);
        return true;
    }

    public List<LectureResponse> getStudentAttendance(GetAttendanceRequest getAttendanceRequest) {
        if (getAttendanceRequest.getTill() == null) {
            getAttendanceRequest.setTill(new Date());
        }
        List<Lecture> lectures = studentAttendanceRepo.getByStudentWithinTimeFrom(getAttendanceRequest.getStudentId(), getAttendanceRequest.getFrom(), getAttendanceRequest.getTill());
        return lectures.stream().map(lectureMapper::entityToDto).toList();
    }

    public List<AttendanceResponse> getStudentAttendanceForLecture(UUID lectureId) {
        List<StudentAttendance> studentAttendanceList = studentAttendanceRepo.getStudentsForLecture(lectureId);
        return studentAttendanceList.stream().map(attendanceMapper::entityToDto).toList();
    }
}
