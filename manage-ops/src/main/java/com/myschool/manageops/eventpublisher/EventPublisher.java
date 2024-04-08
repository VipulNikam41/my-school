package com.myschool.manageops.eventpublisher;

import java.util.UUID;

public interface EventPublisher {
    void newInstituteEvent(UUID instituteId);
}
