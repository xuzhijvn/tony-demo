/*
 *       Copyright© (2020) Lalamove Co., Ltd.
 */
package com.tony.annotation.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author tony
 * @create 2021-07-25
 * @description:
 */
@Aspect
@Component
@Slf4j
public class SysLogAspect {

    @Pointcut("@annotation(com.tony.annotation.aspect.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 目标方法
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        Log syslog = method.getAnnotation(Log.class);
        if (syslog != null) {
            // 注解上的描述
            log.info(syslog.value() + " :" + time);
        }
        return result;
    }
}