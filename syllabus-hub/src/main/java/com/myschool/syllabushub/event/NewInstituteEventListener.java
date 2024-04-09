package com.myschool.syllabushub.event;

import com.myschool.commons.event.NewInstituteEvent;
import com.myschool.constants.Events;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NewInstituteEventListener {
    @KafkaListener(topics = Events.NEW_INSTITUTE)
    public void onApplicationEvent(NewInstituteEvent newInstituteEvent) {
        System.out.println("even called");
    }
}
