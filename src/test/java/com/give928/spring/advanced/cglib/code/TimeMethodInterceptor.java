package com.give928.spring.advanced.cglib.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
@RequiredArgsConstructor
public class TimeMethodInterceptor implements MethodInterceptor {
    private final Object target;

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("TimeMethodInterceptor Proxy 실행");
        long startTime = System.currentTimeMillis();

//        Object result = method.invoke(target, args);
        Object result = methodProxy.invoke(target, args); // method 를 사용해도 되지만, CGLIB 는 성능상 MethodProxy proxy 를 사용하는 것을 권장한다.

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("TimeMethodInterceptor Proxy 종료 resultTime={}", resultTime);
        return result;
    }
}
