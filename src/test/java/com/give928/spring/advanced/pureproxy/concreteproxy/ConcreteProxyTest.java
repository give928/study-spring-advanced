package com.give928.spring.advanced.pureproxy.concreteproxy;

import com.give928.spring.advanced.pureproxy.concreteproxy.code.ConcreteClient;
import com.give928.spring.advanced.pureproxy.concreteproxy.code.ConcreteLogic;
import com.give928.spring.advanced.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

class ConcreteProxyTest {
    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
