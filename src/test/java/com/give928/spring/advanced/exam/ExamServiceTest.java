package com.give928.spring.advanced.exam;

import com.give928.spring.advanced.exam.aop.RetryAspect;
import com.give928.spring.advanced.exam.aop.TraceAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Slf4j
@ComponentScan(basePackages = "com.give928.spring.advanced.exam")
@Import({TraceAspect.class, RetryAspect.class})
@SpringBootTest
class ExamServiceTest {
    @Autowired
    ExamService examService;

    @Test
    void test() {
        for (int i = 0; i < 5; i++) {
            String result = examService.request("data" + (i + 1));
            log.info("result{} = {}", (i + 1), result);
        }
    }
}
