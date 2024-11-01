package com.bluu.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class LoggingAspect {

    @Around("execution(* com.bluu.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("======> @Around on: " + joinPoint.getSignature());
        long begin = System.currentTimeMillis();
        Object result = null;
        try{
            result = joinPoint.proceed();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println("\n Duration: " + duration / 1000.0 + " seconds");
        System.out.println("======> @Around finished");
        return result;

    }

    @Before("com.bluu.aopdemo.aspect.BluuAOPExpressions.forDaoPackageNoGetterNoSetter()")
    public void performApiAnalytics() {
        System.out.println("===> @Before analytics");
    }


    @AfterReturning(
            pointcut = "execution(com.bluu.aopdemo.dao.**.addAccount(..))",
            returning = "name")
    public void afterReturningFindAccountName(JoinPoint joinPoint, String name){
        System.out.println("\n====> @AfterReturning\n " + joinPoint.getSignature());
        System.out.println("returning: " + name.toUpperCase());

    }


    public void performApiAnalyticsAfterReturning() {

    }
}
