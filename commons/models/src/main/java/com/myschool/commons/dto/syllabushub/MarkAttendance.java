package com.myschool.commons.dto.syllabushub;

import com.myschool.commons.dto.StatefulRequest;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class MarkAttendance extends StatefulRequest {
    private UUID staffId;
    private UUID lectureId;
    private List<UUID> studentIds;
}
