package com.give928.spring.advanced.proxy.app.v7;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequestMapping
@ResponseBody
@RequiredArgsConstructor
public class OrderControllerV7 {
    private final OrderServiceV7 orderService;

    @GetMapping("/proxy/v7/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/proxy/v7/no-log")
    public String noLog() {
        return "ok";
    }
}
