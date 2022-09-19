package com.give928.spring.advanced.proxy.config.proxy.interface_proxy;

import com.give928.spring.advanced.proxy.app.v6.OrderRepositoryV6;
import com.give928.spring.advanced.trace.TraceStatus;
import com.give928.spring.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV6 {
    private final OrderRepositoryV6 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepositoryV6.request()");
            //target 호출
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
