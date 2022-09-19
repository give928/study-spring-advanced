package com.give928.spring.advanced.proxy.config.proxy;

import com.give928.spring.advanced.proxy.app.v6.*;
import com.give928.spring.advanced.proxy.config.proxy.interface_proxy.OrderControllerInterfaceProxy;
import com.give928.spring.advanced.proxy.config.proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import com.give928.spring.advanced.proxy.config.proxy.interface_proxy.OrderServiceInterfaceProxy;
import com.give928.spring.advanced.trace.config.LogTraceConfig;
import com.give928.spring.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({LogTraceConfig.class})
public class InterfaceProxyConfig {
    @Bean
    public OrderControllerV6 orderController(LogTrace logTrace) {
        OrderControllerV6Impl controllerImpl = new OrderControllerV6Impl(orderService(logTrace));
        return new OrderControllerInterfaceProxy(controllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV6 orderService(LogTrace logTrace) {
        OrderServiceV6Impl serviceImpl = new OrderServiceV6Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV6 orderRepository(LogTrace logTrace) {
        OrderRepositoryV6Impl repositoryImpl = new OrderRepositoryV6Impl();
        return new OrderRepositoryInterfaceProxy(repositoryImpl, logTrace);
    }
}
