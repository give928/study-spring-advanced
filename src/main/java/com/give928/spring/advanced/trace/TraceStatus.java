package com.give928.spring.advanced.trace;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TraceStatus {
    private TraceId traceId;
    private Long startTimeMs;
    private String message;
}
