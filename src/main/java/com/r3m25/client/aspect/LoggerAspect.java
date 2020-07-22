package com.r3m25.client.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Aspect
@Component
public class LoggerAspect {

    private static Logger logger;

    @Pointcut("@annotation(com.r3m25.client.configuration.anotation.Logger)")
    public void logger(){}

    @Around("logger()")
    public Object aroundLogger(ProceedingJoinPoint pjp) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        long endTime   = System.currentTimeMillis();

        logger = LoggerFactory.getLogger(pjp.getSignature().getClass());
        logger.info("method: " + pjp.getSignature().getName());
        logger.info("elapsedTime:" + (endTime - startTime));

        return proceed;
    }

    @Before("logger()")
    public void beforeLogger(JoinPoint jp) {
        logger = LoggerFactory.getLogger(jp.getSignature().getClass());
        Stream.of(jp.getArgs()).forEach(o -> logger.info("arguments: " + o.toString()));
        logger.info("action method before: " + jp.getSignature().getName());
    }

    @AfterReturning("logger()")
    public void afterLogger(JoinPoint jp) {
        logger = LoggerFactory.getLogger(jp.getSignature().getClass());
        Stream.of(jp.getArgs()).forEach(o -> logger.info("arguments: " + o.toString()));
        logger.info("action method after: " + jp.getSignature().getName());
    }

    @AfterThrowing(value = "logger()", throwing = "ex")
    public void afterThrowingLogger(JoinPoint jp, Exception ex ) {
        logger = LoggerFactory.getLogger(jp.getSignature().getClass());
        Stream.of(jp.getArgs()).forEach(o -> logger.error("arguments: " + o.toString()));
        logger.error("action method: " + jp.getSignature().getName());
        logger.error("error message: " + ex.getMessage());
    }
}
