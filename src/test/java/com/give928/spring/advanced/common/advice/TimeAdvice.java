package com.give928.spring.advanced.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimeAdvice Proxy 실행");
        long startTime = System.currentTimeMillis();

        Object result = invocation.proceed(); // target 의 메서드 실행

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("TimeAdvice Proxy 종료 resultTime={}ms", resultTime);
        return result;
    }
}
