package com.bluu.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class BluuAOPExpressions {
    @Pointcut("execution(public void com.bluu.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(public void com.bluu.aopdemo.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(public void com.bluu.aopdemo.dao.*.set*(..))")
    public void setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterNoSetter() {
    }
}
