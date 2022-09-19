package com.give928.spring.advanced.proxy.config.proxy.concrete_proxy;

import com.give928.spring.advanced.proxy.app.v7.OrderControllerV7;
import com.give928.spring.advanced.trace.TraceStatus;
import com.give928.spring.advanced.trace.logtrace.LogTrace;

public class OrderControllerConcreteProxy extends OrderControllerV7 {
    private final OrderControllerV7 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(OrderControllerV7 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.request()");
            //target 호출
            String result = target.request(itemId);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
