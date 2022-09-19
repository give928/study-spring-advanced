package com.give928.spring.advanced.pureproxy.proxy.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProxyPatternClient {
    private final Subject subject;

    public void execute() {
        subject.operation();
    }
}
