package com.myschool.manageops.event;

import com.myschool.commons.event.SystemMonitorEvent;
import com.myschool.constants.Events;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SystemMonitorEventListener {
//    @KafkaListener(topics = Events.SYSTEM_MONITOR)
//    public void onApplicationEvent(SystemMonitorEvent systemMonitorEvent) {
//        System.out.println("even called");
//    }
}
