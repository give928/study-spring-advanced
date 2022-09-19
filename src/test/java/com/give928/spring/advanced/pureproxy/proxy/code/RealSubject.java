package com.give928.spring.advanced.pureproxy.proxy.code;

import com.give928.spring.advanced.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject {
    @Override
    public String operation() {
        log.info("실제 객체 호출");
        ThreadUtil.sleep(1000);
        return "data";
    }
}
