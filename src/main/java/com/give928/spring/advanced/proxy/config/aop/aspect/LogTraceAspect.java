package com.give928.spring.advanced.proxy.config.aop.aspect;

import com.give928.spring.advanced.trace.TraceStatus;
import com.give928.spring.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
@RequiredArgsConstructor
public class LogTraceAspect {
    private final LogTrace logTrace;

    @Around("execution(* com.give928.spring.advanced.proxy.app..*(..)) && !execution(* com.give928.spring.advanced.proxy.app..noLog(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        TraceStatus status = null;

//        log.info("target={}", joinPoint.getTarget()); // 실제 호출 대상
//        log.info("getArgs={}", joinPoint.getArgs()); // 전달인자
//        log.info("getSignature={}", joinPoint.getSignature()); // join point 시그니처

        try {
            String message = joinPoint.getSignature().toShortString();
            status = logTrace.begin(message);

            //로직 호출
            Object result = joinPoint.proceed();

            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
