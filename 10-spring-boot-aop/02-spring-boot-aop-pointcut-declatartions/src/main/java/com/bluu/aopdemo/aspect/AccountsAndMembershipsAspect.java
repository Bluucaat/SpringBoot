package com.bluu.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Order(1)
@Component
public class AccountsAndMembershipsAspect {
    @Before("com.bluu.aopdemo.aspect.BluuAOPExpressions.forDaoPackageNoGetterNoSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n ====> Method: " + joinPoint.getSignature());
        Object[] args = joinPoint.getArgs();
        for(Object arg : args) {
            System.out.println(arg);
        }
    }
}
