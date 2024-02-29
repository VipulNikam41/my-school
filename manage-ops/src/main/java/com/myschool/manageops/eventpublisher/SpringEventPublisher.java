package com.myschool.manageops.eventpublisher;

import com.myschool.manageops.events.NewInstituteEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service(value = "publish")
@RequiredArgsConstructor
public class SpringEventPublisher implements EventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void newInstituteEvent(UUID instituteId) {
        applicationEventPublisher.publishEvent(
                NewInstituteEvent.builder().instituteId(instituteId).build()
        );
    }
}
