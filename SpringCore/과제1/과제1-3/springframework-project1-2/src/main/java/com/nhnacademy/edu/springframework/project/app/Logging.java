package com.nhnacademy.edu.springframework.project.app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class Logging {

    @Around("@annotation(com.nhnacademy.edu.springframework.project.annotation.Timer)")
    public Object loggingExecutionTime(ProceedingJoinPoint pjp) {

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object rt = null;

        try {
            rt = pjp.proceed();
        } catch( Throwable e) {
            e.printStackTrace();
        } finally {
            stopWatch.stop();
            long totalTimeMillis = stopWatch.getTotalTimeMillis();
            MethodSignature signature = (MethodSignature) pjp.getSignature();

            String className = signature.getClass().getSimpleName();
            String methodName = signature.getMethod().getName();

            System.out.println(className +"." + methodName +" " +totalTimeMillis + "ms");
        }
        return rt;
    }


}
