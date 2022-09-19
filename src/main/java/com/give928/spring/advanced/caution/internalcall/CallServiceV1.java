package com.give928.spring.advanced.caution.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 참고: 생성자 주입은 순환 사이클을 만들기 때문에 실패한다.
 * 스프링 부트 2.6부터는 순환 참조를 기본적으로 금지하도록 정책이 변경되었다.
 * 이 문제를 해결하려면 application.properties 에 다음을 추가해야 한다.
 * spring.main.allow-circular-references=true
 */
@Slf4j
@Component
public class CallServiceV1 {
    /*private CallServiceV1 proxy;

    @Autowired
    public void setCallServiceV1(CallServiceV1 callServiceV1) {
        this.proxy = callServiceV1;
    }

    public void external() {
        log.info("call external");
        proxy.internal(); //외부 메서드 호출
    }*/
    public void external() {
        log.info("call external");
        internal();
    }

    public void internal() {
        log.info("call internal");
    }
}
