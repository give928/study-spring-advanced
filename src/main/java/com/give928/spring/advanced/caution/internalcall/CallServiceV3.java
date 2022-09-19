package com.give928.spring.advanced.caution.internalcall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 구조를 변경(분리)
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CallServiceV3 {
    private final InternalServiceV3 internalServiceV3;

    public void external() {
        log.info("call external");
        internalServiceV3.internal(); //외부 메서드 호출
    }
}