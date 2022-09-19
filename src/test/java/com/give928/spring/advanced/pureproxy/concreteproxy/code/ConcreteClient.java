package com.give928.spring.advanced.pureproxy.concreteproxy.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConcreteClient {
    private final ConcreteLogic concreteLogic;

    public void execute() {
        concreteLogic.operation();
    }
}
