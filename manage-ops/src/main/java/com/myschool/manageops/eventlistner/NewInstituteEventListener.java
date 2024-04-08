package com.myschool.manageops.eventlistner;

import com.myschool.manageops.events.NewInstituteEvent;
import com.myschool.manageops.service.BatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@Component
public class NewInstituteEventListener {
    private final BatchService batchService;

    @EventListener
    public void onApplicationEvent(NewInstituteEvent event) {
        log.info("new institute even triggered");
        this.addDefaultBranch(event.getInstituteId());
    }

    private void addDefaultBranch(UUID instituteId) {
        System.out.println("hi");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("bye");
        batchService.addDefaultBranch(instituteId);
    }
}
