package com.myschool.manageops.event;

import com.myschool.commons.event.NewInstituteEvent;
import com.myschool.commons.event.SystemMonitorEvent;
import com.myschool.constants.Events;
import com.myschool.constants.event.Situation;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventPublisher {
    private final KafkaTemplate<String, SystemMonitorEvent> kafkaSme;
    private final KafkaTemplate<String, NewInstituteEvent> kafkaNie;

    public void publishNewInstituteEvent(UUID instituteId) {
        NewInstituteEvent newInstituteEvent = new NewInstituteEvent();
        newInstituteEvent.setInstituteId(instituteId);
        kafkaNie.send(Events.NEW_INSTITUTE, newInstituteEvent);
    }

    public void publishSystemMonitorEvent(Class<?> klass, String method, String description, Situation situation) {
        SystemMonitorEvent systemMonitorEvent = new SystemMonitorEvent();
        systemMonitorEvent.setThreadId(Thread.currentThread().getName());
        systemMonitorEvent.setTime(new Date());
        systemMonitorEvent.setKlassName(klass.getName());
        systemMonitorEvent.setMethodName(method);
        systemMonitorEvent.setSituation(situation);
        systemMonitorEvent.setDescription(description);
        kafkaSme.send(Events.SYSTEM_MONITOR, systemMonitorEvent);
    }
}
