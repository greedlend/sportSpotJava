package com.andy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MonitorAOP {

    @Pointcut("execution(public * com.andy.controller..*(..))")
    public void Pointcut() {

    }

    @Before("Pointcut()") public void beforeMethod(JoinPoint joinPoint){ log.info("調用了前置通知"); }

    @AfterReturning(value="Pointcut()",returning="result") public void afterReturningMethod(JoinPoint joinPoint, Object result){ log.info("調用了返回通知"); }

    @AfterThrowing(value="Pointcut()",throwing="e") public void afterReturningMethod(JoinPoint joinPoint, Exception e){ log.info("調用了異常通知"); }

    //@Around：環繞通知
    @Around("Pointcut()") public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("around執行方法之前");
        Object object = pjp.proceed();
        log.info("around執行方法之後--返回值：" +object);
        return object;
    }

}
