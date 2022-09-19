package com.give928.spring.advanced.jdkdynamic;

import com.give928.spring.advanced.jdkdynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
class JdkDynamicProxyTest {
    @Test
    void dynamicA() {
        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(),
                                                               new Class[]{AInterface.class}, handler);
        proxy.call();
        log.info("targetClass={}", target.getClass()); // class com.give928.spring.advanced.jdkdynamic.code.AImpl
        log.info("proxyClass={}", proxy.getClass()); // class com.sun.proxy.$Proxy9
    }

    @Test
    void dynamicB() {
        BInterface target = new BImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(),
                                                               new Class[]{BInterface.class}, handler);
        proxy.call();
        log.info("targetClass={}", target.getClass()); // class com.give928.spring.advanced.jdkdynamic.code.BImpl
        log.info("proxyClass={}", proxy.getClass()); // class com.sun.proxy.$Proxy10
    }
}
