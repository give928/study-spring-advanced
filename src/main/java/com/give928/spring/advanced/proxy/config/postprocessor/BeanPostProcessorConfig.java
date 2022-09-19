package com.give928.spring.advanced.proxy.config.postprocessor;

import com.give928.spring.advanced.proxy.config.AppV6Config;
import com.give928.spring.advanced.proxy.config.AppV7Config;
import com.give928.spring.advanced.proxy.config.postprocessor.postprocessor.PackageLogTraceProxyPostProcessor;
import com.give928.spring.advanced.proxy.config.proxyfactory.advice.LogTraceAdvice;
import com.give928.spring.advanced.trace.config.LogTraceConfig;
import com.give928.spring.advanced.trace.logtrace.LogTrace;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({LogTraceConfig.class, AppV6Config.class, AppV7Config.class})
public class BeanPostProcessorConfig {
    @Bean
    public PackageLogTraceProxyPostProcessor logTraceProxyPostProcessor(LogTrace logTrace) {
        return new PackageLogTraceProxyPostProcessor("com.give928.spring.advanced.proxy.app", getAdvisor(logTrace));
    }

    private Advisor getAdvisor(LogTrace logTrace) {
        //pointcut
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        //advice
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        //advisor = pointcut + advice
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
