package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){
    }

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){
    }

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDAOPackage(){
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() {
    }

        @Before("forAppFlow()")
        public void before(JoinPoint joinPoint) {
            System.out.println("====> @Before: " + joinPoint.getSignature().getName());
            Object[] args = joinPoint.getArgs();
            for(Object arg : args){
                logger.info("\n===> Arg: " + arg);
            }
        }

        @AfterReturning(
                pointcut = "forAppFlow()",
                returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("====> @AfterReturning: " + joinPoint.getSignature().getName());
        logger.info("===> Result: " + result);
        }
}
