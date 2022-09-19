package com.give928.spring.advanced.pureproxy.proxy;

import com.give928.spring.advanced.pureproxy.proxy.code.CacheProxy;
import com.give928.spring.advanced.pureproxy.proxy.code.ProxyPatternClient;
import com.give928.spring.advanced.pureproxy.proxy.code.RealSubject;
import com.give928.spring.advanced.pureproxy.proxy.code.Subject;
import org.junit.jupiter.api.Test;

class ProxyPatternTest {
    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest() {
        Subject realSubject = new RealSubject();
        Subject cacheProxy = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);
        client.execute();
        client.execute();
        client.execute();
    }
}
