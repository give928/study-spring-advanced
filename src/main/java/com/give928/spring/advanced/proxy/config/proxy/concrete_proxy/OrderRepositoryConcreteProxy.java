package com.give928.spring.advanced.proxy.config.proxy.concrete_proxy;

import com.give928.spring.advanced.proxy.app.v7.OrderRepositoryV7;
import com.give928.spring.advanced.trace.TraceStatus;
import com.give928.spring.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryConcreteProxy extends OrderRepositoryV7 {
    private final OrderRepositoryV7 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.save()");
            //target 호출
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
