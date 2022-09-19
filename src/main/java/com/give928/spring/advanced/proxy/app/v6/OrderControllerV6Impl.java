package com.give928.spring.advanced.proxy.app.v6;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OrderControllerV6Impl implements OrderControllerV6 {
    private final OrderServiceV6 orderService;

    @Override
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    @Override
    public String noLog() {
        return "ok";
    }
}
