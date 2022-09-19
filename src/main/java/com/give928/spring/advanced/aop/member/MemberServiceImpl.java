package com.give928.spring.advanced.aop.member;

import com.give928.spring.advanced.aop.member.annotation.ClassAop;
import com.give928.spring.advanced.aop.member.annotation.MethodAop;
import org.springframework.stereotype.Component;

@ClassAop
@Component
public class MemberServiceImpl implements MemberService {
    @Override
    @MethodAop("test value")
    public String hello(String param) {
        System.out.println("MemberServiceImpl.hello param=" + param);
        return "ok";
    }

    public String internal(String param) {
        System.out.println("MemberServiceImpl.internal param=" + param);
        return "ok";
    }
}
