package com.tony.other.demo3;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author tony老师
 * @create 2021-05-08
 * Description:
 */
@Aspect
@Slf4j
@Component
@Order(1)
public class HelloAspect {
    @Pointcut("execution(* com.tony.other.demo3.HelloService.say(..))")
    public void say() {
    }

    @Around("say()")
    public Object say(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            System.out.println("我切到了say方法");
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable ex) {
            log.error("失败: {},{}", ex.getClass().getName(), ex.getMessage());
        }
        return null;
    }
    @Pointcut("execution(* com.tony.other.demo3.HelloService.say2(..))")
    public void say2() {
    }

    @Around("say2()")
    public Object say2(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            System.out.println("我切到了say2方法");
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable ex) {
            log.error("失败: {},{}", ex.getClass().getName(), ex.getMessage());
        }
        return null;
    }
}
