package com.give928.spring.advanced.trace.config;

import com.give928.spring.advanced.trace.callback.TraceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(LogTraceConfig.class)
@RequiredArgsConstructor
public class TraceTemplateConfig {
    private final LogTraceConfig logTraceConfig;

    @Bean
    public TraceTemplate traceTemplate() {
        return new TraceTemplate(logTraceConfig.logTrace());
    }
}
