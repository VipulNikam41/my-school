package com.myschool.syllabushub.domain.mapper;

import com.myschool.commons.dto.syllabushub.AttendanceResponse;
import com.myschool.commons.dto.syllabushub.MarkAttendance;
import com.myschool.syllabushub.domain.entities.StudentAttendance;
import com.myschool.syllabushub.domain.entities.StudentLectureKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AttendanceMapperImpl.class})
public class AttendanceMapperTest {
    @Autowired
    private AttendanceMapper attendanceMapper;

    @Test
    public void entityToDto() {
        StudentAttendance studentAttendance = new StudentAttendance();
        studentAttendance.setId(
                new StudentLectureKey(UUID.randomUUID(), UUID.randomUUID())
        );
        studentAttendance.setStaffId(UUID.randomUUID());
        studentAttendance.setCreatedOn(new Date());
        studentAttendance.setUpdatedOn(new Date());
        AttendanceResponse attendanceResponse = attendanceMapper.entityToDto(studentAttendance);
        assertEquals(studentAttendance.getId().getStudentId(), attendanceResponse.getStudentId());
        assertEquals(studentAttendance.getId().getLectureId(), attendanceResponse.getLectureId());
        assertEquals(studentAttendance.getStaffId(), attendanceResponse.getStaffId());
        assertEquals(studentAttendance.getCreatedOn(), attendanceResponse.getCreatedOn());
        assertEquals(studentAttendance.getUpdatedOn(), attendanceResponse.getUpdatedOn());
    }

    @Test
    public void markAttendanceToStudentAttendance() {
        MarkAttendance markAttendance = new MarkAttendance();
        markAttendance.setLectureId(UUID.randomUUID());
        markAttendance.setStaffId(UUID.randomUUID());
        List<UUID> studentIds = List.of(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID());
        markAttendance.setStudentIds(studentIds);
        List<StudentAttendance> studentAttendanceList = attendanceMapper.markAttendanceToStudentAttendance(markAttendance);
        for (StudentAttendance attendance : studentAttendanceList) {
            assertEquals(markAttendance.getStaffId(), attendance.getStaffId());
            assertEquals(markAttendance.getLectureId(), attendance.getId().getLectureId());
            assertTrue(studentIds.contains(attendance.getId().getStudentId()));
        }
    }
}