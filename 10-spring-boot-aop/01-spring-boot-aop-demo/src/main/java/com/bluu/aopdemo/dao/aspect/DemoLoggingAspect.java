package com.bluu.aopdemo.dao.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
    @Before("execution(public void com.bluu.aopdemo.dao.*.add*(String, ..))")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n===> @Before DAO add*(String, ..)");
    }
}
