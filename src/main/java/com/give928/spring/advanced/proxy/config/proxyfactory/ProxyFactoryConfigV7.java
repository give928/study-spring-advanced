package com.give928.spring.advanced.proxy.config.proxyfactory;

import com.give928.spring.advanced.proxy.app.v7.OrderControllerV7;
import com.give928.spring.advanced.proxy.app.v7.OrderRepositoryV7;
import com.give928.spring.advanced.proxy.app.v7.OrderServiceV7;
import com.give928.spring.advanced.proxy.config.proxyfactory.advice.LogTraceAdvice;
import com.give928.spring.advanced.trace.config.LogTraceConfig;
import com.give928.spring.advanced.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@Import({LogTraceConfig.class})
public class ProxyFactoryConfigV7 {
    @Bean
    public OrderControllerV7 orderControllerV7(LogTrace logTrace) {
        OrderControllerV7 orderController = new OrderControllerV7(orderServiceV7(logTrace));
        ProxyFactory factory = new ProxyFactory(orderController);
        factory.addAdvisor(getAdvisor(logTrace));
        OrderControllerV7 proxy = (OrderControllerV7) factory.getProxy();
        log.info("ProxyFactory proxy={}, target={}", proxy.getClass(), orderController.getClass());
        return proxy;
    }

    @Bean

    public OrderServiceV7 orderServiceV7(LogTrace logTrace) {
        OrderServiceV7 orderService = new OrderServiceV7(orderRepositoryV7(logTrace));
        ProxyFactory factory = new ProxyFactory(orderService);
        factory.addAdvisor(getAdvisor(logTrace));
        OrderServiceV7 proxy = (OrderServiceV7) factory.getProxy();
        log.info("ProxyFactory proxy={}, target={}", proxy.getClass(), orderService.getClass());
        return proxy;
    }

    @Bean
    public OrderRepositoryV7 orderRepositoryV7(LogTrace logTrace) {
        OrderRepositoryV7 orderRepository = new OrderRepositoryV7();
        ProxyFactory factory = new ProxyFactory(orderRepository);
        factory.addAdvisor(getAdvisor(logTrace));
        OrderRepositoryV7 proxy = (OrderRepositoryV7) factory.getProxy();
        log.info("ProxyFactory proxy={}, target={}", proxy.getClass(), orderRepository.getClass());
        return proxy;
    }

    private Advisor getAdvisor(LogTrace logTrace) {
        //pointcut
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        //advice
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        //advisor = pointcut + advice
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
