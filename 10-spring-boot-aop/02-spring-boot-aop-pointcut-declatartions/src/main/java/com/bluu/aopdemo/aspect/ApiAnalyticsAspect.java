package com.bluu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class ApiAnalyticsAspect {
    @Before("com.bluu.aopdemo.aspect.BluuAOPExpressions.forDaoPackageNoGetterNoSetter()")
    public void performApiAnalytics(){
        System.out.println("===> @Before analytics");
    }

}
