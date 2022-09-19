package com.give928.spring.advanced.proxy.config.proxy;

import com.give928.spring.advanced.proxy.app.v7.OrderControllerV7;
import com.give928.spring.advanced.proxy.app.v7.OrderRepositoryV7;
import com.give928.spring.advanced.proxy.app.v7.OrderServiceV7;
import com.give928.spring.advanced.proxy.config.proxy.concrete_proxy.OrderControllerConcreteProxy;
import com.give928.spring.advanced.proxy.config.proxy.concrete_proxy.OrderRepositoryConcreteProxy;
import com.give928.spring.advanced.proxy.config.proxy.concrete_proxy.OrderServiceConcreteProxy;
import com.give928.spring.advanced.trace.config.LogTraceConfig;
import com.give928.spring.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({LogTraceConfig.class})
public class ConcreteProxyConfig {
    @Bean
    public OrderControllerV7 orderControllerV7(LogTrace logTrace) {
        OrderControllerV7 controllerImpl = new OrderControllerV7(orderServiceV7(logTrace));
        return new OrderControllerConcreteProxy(controllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV7 orderServiceV7(LogTrace logTrace) {
        OrderServiceV7 serviceImpl = new OrderServiceV7(orderRepositoryV7(logTrace));
        return new OrderServiceConcreteProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV7 orderRepositoryV7(LogTrace logTrace) {
        OrderRepositoryV7 repositoryImpl = new OrderRepositoryV7();
        return new OrderRepositoryConcreteProxy(repositoryImpl, logTrace);
    }
}
