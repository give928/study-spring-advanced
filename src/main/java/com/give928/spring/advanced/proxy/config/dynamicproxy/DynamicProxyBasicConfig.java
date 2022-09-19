package com.give928.spring.advanced.proxy.config.dynamicproxy;

import com.give928.spring.advanced.proxy.app.v6.*;
import com.give928.spring.advanced.proxy.config.dynamicproxy.handler.LogTraceBasicHandler;
import com.give928.spring.advanced.trace.config.LogTraceConfig;
import com.give928.spring.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.reflect.Proxy;

@Configuration
@Import({LogTraceConfig.class})
public class DynamicProxyBasicConfig {
    @Bean
    public OrderControllerV6 orderControllerV6(LogTrace logTrace) {
        OrderControllerV6 orderController = new OrderControllerV6Impl(orderServiceV6(logTrace));
        OrderControllerV6 proxy = (OrderControllerV6) Proxy.newProxyInstance(OrderControllerV6.class.getClassLoader(),
                                                                             new Class[]{OrderControllerV6.class},
                                                                             new LogTraceBasicHandler(orderController, logTrace));
        return proxy;
    }

    @Bean
    public OrderServiceV6 orderServiceV6(LogTrace logTrace) {
        OrderServiceV6 orderService = new OrderServiceV6Impl(orderRepositoryV6(logTrace));
        OrderServiceV6 proxy = (OrderServiceV6) Proxy.newProxyInstance(OrderServiceV6.class.getClassLoader(),
                                                                       new Class[]{OrderServiceV6.class},
                                                                       new LogTraceBasicHandler(orderService,
                                                                                                logTrace));
        return proxy;
    }

    @Bean
    public OrderRepositoryV6 orderRepositoryV6(LogTrace logTrace) {
        OrderRepositoryV6 orderRepository = new OrderRepositoryV6Impl();
        OrderRepositoryV6 proxy = (OrderRepositoryV6) Proxy.newProxyInstance(OrderRepositoryV6.class.getClassLoader(),
                                                                             new Class[]{OrderRepositoryV6.class},
                                                                             new LogTraceBasicHandler(orderRepository, logTrace));
        return proxy;
    }
}
