package com.myschool.commons.event;

import lombok.Data;

import java.util.UUID;

@Data
public class NewInstituteEvent {
    private UUID instituteId;
}
