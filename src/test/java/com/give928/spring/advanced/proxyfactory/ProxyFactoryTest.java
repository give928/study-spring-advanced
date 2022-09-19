package com.give928.spring.advanced.proxyfactory;

import com.give928.spring.advanced.common.advice.TimeAdvice;
import com.give928.spring.advanced.common.service.ConcreteService;
import com.give928.spring.advanced.common.service.ServiceImpl;
import com.give928.spring.advanced.common.service.ServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.aop.Advice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class ProxyFactoryTest {
    @Test
    @DisplayName("인터페이스가 있으면 JDK 동적 프록시 사용")
    void interfaceProxy() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        Advice advice = new TimeAdvice();
        proxyFactory.addAdvice(advice);
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("targetClass={}", target.getClass()); // class com.give928.spring.advanced.common.service.ServiceImpl
        log.info("proxyClass={}", proxy.getClass()); // class com.sun.proxy.$Proxy10

        proxy.save();

        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isTrue();
        assertThat(AopUtils.isCglibProxy(proxy)).isFalse();
    }

    @Test
    @DisplayName("구체 클래스만 있으면 CGLIB 사용")
    void concreteProxy() {
        ConcreteService target = new ConcreteService();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        Advice advice = new TimeAdvice();
        proxyFactory.addAdvice(advice);
        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();
        log.info("targetClass={}",
                 target.getClass()); // class com.give928.spring.advanced.common.service.ConcreteService
        log.info("proxyClass={}",
                 proxy.getClass()); // class com.give928.spring.advanced.common.service.ConcreteService$$EnhancerBySpringCGLIB$$9c22fa70

        proxy.call();

        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isFalse();
        assertThat(AopUtils.isCglibProxy(proxy)).isTrue();
    }

    @Test
    @DisplayName("ProxyTargetClass 옵션을 사용하면 인터페이스가 있어도 CGLIB를 사용하고, 클래스 기반 프록시 사용")
    void proxyTargetClass() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true); // 중요 - 인터페이스가 있어도 CGLIB를 사용하게 설정
        Advice advice = new TimeAdvice();
        proxyFactory.addAdvice(advice);
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("targetClass={}", target.getClass()); // class com.give928.spring.advanced.common.service.ServiceImpl
        log.info("proxyClass={}", proxy.getClass()); // class com.give928.spring.advanced.common.service.ServiceImpl$$EnhancerBySpringCGLIB$$dde004e9

        proxy.save();

        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isFalse();
        assertThat(AopUtils.isCglibProxy(proxy)).isTrue();
    }
}
