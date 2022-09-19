package com.give928.spring.advanced.proxy.config.aop;

import com.give928.spring.advanced.proxy.config.AppV6Config;
import com.give928.spring.advanced.proxy.config.AppV7Config;
import com.give928.spring.advanced.proxy.config.aop.aspect.LogTraceAspect;
import com.give928.spring.advanced.trace.config.LogTraceConfig;
import com.give928.spring.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({LogTraceConfig.class, AppV6Config.class, AppV7Config.class})
public class AopConfig {
    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace) {
        return new LogTraceAspect(logTrace);
    }
}
