package com.give928.spring.advanced.proxy.app.v7;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceV7 {
    private final OrderRepositoryV7 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
