package com.andy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Order(-99) // 控制多個Aspect的執行順序，越小越先執行
@Component
@Slf4j
public class MonitorAOP {


    // controller及其子包中所有的類的所有方法切面
    @Pointcut("execution(public * com.andy.controller..*.*(..))")
    public void Pointcut() {
    }

    // controller包中所有的類的所有方法切面
//    @Pointcut("execution(public * com.andy.controller.*.*(..))")
//    public void Pointcut() {
//    }

    //只針對 SpotController 類切面
    //@Pointcut("execution(public * com.andy.controller.SpotController.*(..))")


    @Before("Pointcut()") public void beforeMethod(JoinPoint joinPoint){ log.info("調用了前置通知"); }

    @AfterReturning(value="Pointcut()",returning="result") public void afterReturningMethod(JoinPoint joinPoint, Object result){ log.info("調用了返回通知"); }

    @AfterThrowing(value="Pointcut()",throwing="e") public void afterReturningMethod(JoinPoint joinPoint, Exception e){ log.info("調用了異常通知"); }

    //@Around：環繞通知
    @Around("Pointcut()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        log.info(":: around執行方法之前");
//        Object object = pjp.proceed();
//        log.info("around執行方法之後--返回值：" +object);
//        return object;


        Map<String,Object> data = new HashMap<>();
        //獲取目標類名稱
        String clazzName = pjp.getTarget().getClass().getName();
        //獲取目標類方法名稱
        String methodName = pjp.getSignature().getName();
        //記錄類名稱
        data.put("clazzName",clazzName);
        //記錄對應方法名稱
        data.put("methodName",methodName);
        //記錄請求參數
        data.put("params",pjp.getArgs());
        //開始調用時間 // 計時並調用目標函數
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        Long time = System.currentTimeMillis() - start;
        //記錄返回參數
        data.put("result",result);
        //設置消耗總時間
        data.put("consumeTime",time);
//        System.out.println(data);
        log.info(":: message:{}", data);
        return result;

    }

}
