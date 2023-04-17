package com.nhnacademy.edu.springframework.app;

import com.nhnacademy.edu.springframework.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
@Aspect
@Component
public class DoorayLogging {

    @Around("@annotation(com.nhnacademy.edu.springframework.annotation.DoorayTimer)")
    public Object loggingExecutionTime(ProceedingJoinPoint pjp) {

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object rt =null;

        try {
            rt = pjp.proceed();
        } catch(Throwable e) {
            e.printStackTrace();

        } finally {
            stopWatch.stop();
            long totalTimeMillis = stopWatch.getTotalTimeMillis();
            MethodSignature signature = (MethodSignature) pjp.getSignature();

            String methodName = signature.getMethod().getName();
            System.out.println("실행메서드: " + methodName + " "+"실행시간: " + totalTimeMillis + "ms");
        }


        return rt;
    }
}