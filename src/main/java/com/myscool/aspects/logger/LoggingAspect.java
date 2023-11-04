package com.myscool.aspects.logger;

import com.myscool.aspects.annotation.Loggable;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Before("execution(* com.myscool..*(..)) && @annotation(loggable)")
    public void logMethodCall(JoinPoint joinPoint, Loggable loggable) {
        log.info("this will run for method which is annotated with logable");
    }
}
