package com.give928.spring.advanced.proxy.app.v8;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV8 {
    private final OrderRepositoryV8 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
