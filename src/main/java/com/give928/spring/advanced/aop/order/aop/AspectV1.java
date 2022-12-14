package com.give928.spring.advanced.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class AspectV1 {
    @Around("execution(* com.give928.spring.advanced.aop.order..*(..))") // pointcut
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable { // advice
        log.info("[log] {}", joinPoint.getSignature()); // join point ์๊ทธ๋์ฒ
        return joinPoint.proceed();
    }
}
