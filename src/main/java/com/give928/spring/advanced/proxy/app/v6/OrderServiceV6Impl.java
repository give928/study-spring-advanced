package com.give928.spring.advanced.proxy.app.v6;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceV6Impl implements OrderServiceV6 {
    private final OrderRepositoryV6 orderRepository;

    @Override
    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
