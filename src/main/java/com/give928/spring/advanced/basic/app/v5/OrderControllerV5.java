package com.give928.spring.advanced.basic.app.v5;

import com.give928.spring.advanced.trace.callback.TraceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {
    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    @GetMapping("/basic/v5/request")
    public String request(String itemId) {
        return template.execute("OrderControllerV5.request()", () -> {
            orderService.orderItem(itemId);
            return "ok";
        });
    }
}
