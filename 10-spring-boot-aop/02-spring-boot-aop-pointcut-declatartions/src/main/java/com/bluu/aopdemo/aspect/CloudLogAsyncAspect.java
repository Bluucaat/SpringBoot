package com.bluu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class CloudLogAsyncAspect {
    @Before("com.bluu.aopdemo.aspect.BluuAOPExpressions.forDaoPackageNoGetterNoSetter()")
    public void logToCloudAsync(){
        System.out.println("===> @Before logging to cloud in async");
    }
}
