package com.myschool.manageops.events;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class NewInstituteEvent {
    private UUID instituteId;
}
