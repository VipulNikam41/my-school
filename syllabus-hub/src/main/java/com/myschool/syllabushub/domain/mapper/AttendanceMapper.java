package com.myschool.syllabushub.domain.mapper;

import com.myschool.commons.dto.syllabushub.AttendanceResponse;
import com.myschool.commons.dto.syllabushub.MarkAttendance;
import com.myschool.syllabushub.domain.entities.StudentAttendance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper
public interface AttendanceMapper {
    @Mapping(source = "id.lectureId", target = "lectureId")
    @Mapping(source = "id.studentId", target = "studentId")
    AttendanceResponse entityToDto(StudentAttendance studentAttendance);

    @Mapping(source = "markAttendance.lectureId", target = "id.lectureId")
    @Mapping(source = "studentId", target = "id.studentId")
    StudentAttendance mapToStudentAttendance(UUID studentId, MarkAttendance markAttendance);

    default List<StudentAttendance> markAttendanceToStudentAttendance(MarkAttendance markAttendance) {
        return markAttendance.getStudentIds().stream()
                .map(studentId ->
                        mapToStudentAttendance(studentId, markAttendance)
                ).toList();
    }
}
