package com.give928.spring.advanced.exam;

import com.give928.spring.advanced.exam.annotation.Trace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;

    @Trace
    public String request(String itemId) {
        return examRepository.save(itemId);
    }
}
