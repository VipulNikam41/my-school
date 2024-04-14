package com.myschool.commons.event;

import com.myschool.constants.event.Situation;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class SystemMonitorEvent {
    private String threadId;
    private Date time;
    private String klassName;
    private String methodName;
    private Situation situation;
    private String eventId;
    private String description;
    private String requestId;
}
