package com.give928.spring.advanced.caution.typecasting;

import com.give928.spring.advanced.aop.member.MemberService;
import com.give928.spring.advanced.aop.member.MemberServiceImpl;
import com.give928.spring.advanced.caution.typecasting.code.ProxyDIAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Slf4j
@ComponentScan(basePackages = "com.give928.spring.advanced.aop.member")
//@SpringBootTest(properties = {"spring.aop.proxy-target-class=false"}) // JDK 동적 프록시, DI 예외 발생
//@SpringBootTest(properties = {"spring.aop.proxy-target-class=true"}) // CGLIB 프록시, 성공
@SpringBootTest
@Import(ProxyDIAspect.class)
class ProxyDITest {
    @Autowired
    MemberService memberService; // JDK 동적 프록시 OK, CGLIB OK

    @Autowired
    MemberServiceImpl memberServiceImpl; // JDK 동적 프록시 X, CGLIB OK

    @Test
    void go() {
        log.info("memberService class={}", memberService.getClass());
        log.info("memberServiceImpl class={}", memberServiceImpl.getClass());
        memberServiceImpl.hello("hello");
    }
}
