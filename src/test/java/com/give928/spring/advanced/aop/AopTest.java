package com.give928.spring.advanced.aop;

import com.give928.spring.advanced.aop.order.OrderRepository;
import com.give928.spring.advanced.aop.order.OrderService;
import com.give928.spring.advanced.aop.order.aop.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
@ComponentScan(basePackages = "com.give928.spring.advanced.aop.order")
//@Import(AspectV1.class)
//@Import(AspectV2.class)
//@Import(AspectV3.class)
//@Import(AspectV4Pointcut.class)
//@Import({AspectV5Order.LogAspect.class, AspectV5Order.TxAspect.class})
@Import(AspectV6Advice.class)
@SpringBootTest
class AopTest {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    void aopInfo() {
        boolean isServiceAopProxy = AopUtils.isAopProxy(orderService);
        boolean isRepositoryAopProxy = AopUtils.isAopProxy(orderRepository);
        log.info("isAopProxy, orderService={}", isServiceAopProxy);
        log.info("isAopProxy, orderRepository={}", isRepositoryAopProxy);
        assertThat(isServiceAopProxy).isTrue();
//        assertThat(isRepositoryAopProxy).isTrue(); // AspectV6Advice.class 에서는 service 만 포인트컷에 등록해서 이 테스트는 실패한다.
    }

    @Test
    void success() {
        String result = orderService.orderItem("itemA");
        assertThat(result).isEqualTo("ok");
    }

    @Test
    void exception() {
        assertThatThrownBy(() -> orderService.orderItem("ex")).isInstanceOf(IllegalStateException.class);
    }
}
