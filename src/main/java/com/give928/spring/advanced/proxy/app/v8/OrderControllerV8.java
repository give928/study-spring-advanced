package com.give928.spring.advanced.proxy.app.v8;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderControllerV8 {
    private final OrderServiceV8 orderService;

    @GetMapping("/proxy/v8/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/proxy/v8/no-log")
    public String noLog() {
        return "ok";
    }
}
