package com.give928.spring.advanced;

import com.give928.spring.advanced.proxy.config.AppV6Config;
import com.give928.spring.advanced.proxy.config.AppV7Config;
import com.give928.spring.advanced.proxy.config.aop.AopConfig;
import com.give928.spring.advanced.proxy.config.autoproxy.AutoProxyConfig;
import com.give928.spring.advanced.proxy.config.dynamicproxy.DynamicProxyBasicConfig;
import com.give928.spring.advanced.proxy.config.dynamicproxy.DynamicProxyFilterConfig;
import com.give928.spring.advanced.proxy.config.postprocessor.BeanPostProcessorConfig;
import com.give928.spring.advanced.proxy.config.proxy.ConcreteProxyConfig;
import com.give928.spring.advanced.proxy.config.proxy.InterfaceProxyConfig;
import com.give928.spring.advanced.proxy.config.proxyfactory.ProxyFactoryConfigV6;
import com.give928.spring.advanced.proxy.config.proxyfactory.ProxyFactoryConfigV7;
import com.give928.spring.advanced.trace.config.LogTraceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

// baisc 패키지 설정
//@SpringBootApplication(scanBasePackages = {"com.give928.spring.advanced.trace", "com.give928.spring.advanced.basic"})

// proxy 패키지 설정
//@Import({AppV6Config.class})
//@Import({AppV6Config.class, AppV7Config.class})
//@Import({InterfaceProxyConfig.class})
//@Import({ConcreteProxyConfig.class})
//@Import({DynamicProxyBasicConfig.class})
//@Import({DynamicProxyFilterConfig.class})
//@Import({ProxyFactoryConfigV6.class})
//@Import({ProxyFactoryConfigV7.class})
//@Import({BeanPostProcessorConfig.class})
//@Import(AutoProxyConfig.class)
//@Import(AopConfig.class)
//@SpringBootApplication(scanBasePackages = {"com.give928.spring.advanced.trace", "com.give928.spring.advanced.proxy.app"})

// aop 패키지 설정
//@SpringBootApplication(scanBasePackages = {"com.give928.spring.advanced.aop"})

// 예제
//@SpringBootApplication(scanBasePackages = {"com.give928.spring.advanced.exam"})

// 주의
@SpringBootApplication(scanBasePackages = {"com.give928.spring.advanced.caution"})
public class SpringAdvancedApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedApplication.class, args);
    }
}
