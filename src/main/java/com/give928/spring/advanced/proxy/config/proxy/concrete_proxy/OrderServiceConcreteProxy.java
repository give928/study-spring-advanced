package com.give928.spring.advanced.proxy.config.proxy.concrete_proxy;

import com.give928.spring.advanced.proxy.app.v7.OrderServiceV7;
import com.give928.spring.advanced.trace.TraceStatus;
import com.give928.spring.advanced.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV7 {
    private final OrderServiceV7 target;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderServiceV7 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.orderItem()");
            //target 호출
            target.orderItem(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
