package com.give928.spring.advanced.cglib;

import com.give928.spring.advanced.cglib.code.TimeMethodInterceptor;
import com.give928.spring.advanced.common.service.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
class CglibTest {
    @Test
    void cglib() {
        ConcreteService target = new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));
        ConcreteService proxy = (ConcreteService) enhancer.create();
        log.info("targetClass={}", target.getClass()); // class com.give928.spring.advanced.common.service.ConcreteService
        log.info("proxyClass={}", proxy.getClass()); // class com.give928.spring.advanced.common.service.ConcreteService$$EnhancerByCGLIB$$c9145c17

        proxy.call();
    }
}
