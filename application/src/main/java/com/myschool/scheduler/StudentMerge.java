package com.myschool.scheduler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentMerge implements Scheduler {
    @Override
    public void trigger() {
        log.info("those students, which institute will add manually but wont verify, scheduler should send notification that this student alredy exist and institute should get him verified.");
        log.info("once verified, the entry for dummy student will be deleted and institutes student will point to actual student where data for both student and insti will be in sink");
        log.info("need to brief this");
    }
}
