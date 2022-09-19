package com.give928.spring.advanced.aop.pointcut;

import com.give928.spring.advanced.aop.member.annotation.ClassAop;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Slf4j
@Import(AtArgsTest.Config.class)
@SpringBootTest
class AtArgsTest {
    @Autowired
    Form form;

    @Test
    void success() {
        log.info("form Proxy={}", form.getClass());
        form.submit(new Check());
    }

    static class Config {
        @Bean
        public Form form() {
            return new Form();
        }

        @Bean
        public AtArgsTestAspect atArgsTestAspect() {
            return new AtArgsTestAspect();
        }
    }

    @ClassAop
    static class Check {
    }

    static class Form {
        public void submit(Check check) {
            System.out.println("Form.submit");
        }
    }

    @Slf4j
    @Aspect
    static class AtArgsTestAspect {
        @Around("execution(* com.give928.spring.advanced.aop..*(..)) && @args(com.give928.spring.advanced.aop.member.annotation.ClassAop)")
        public Object doAtAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("[@args] {}", joinPoint.getSignature());
            return joinPoint.proceed();
        }
    }
}
