package com.tony.demo3;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author tony121.xu@huolala.cn
 * @create 2021-05-08
 * Description:
 */
@Aspect
@Slf4j
@Component
@Order(2)
public class HelloAspect2 {
    @Pointcut("execution(* com.tony.demo3.HelloService2.sayHello(..))")
    public void sayHello() {
    }

    @Before("sayHello()")
    public void beforeSayHello(){
        System.out.println("Before: 我切到了sayHello方法");
    }

    @Around("sayHello()")
    public Object sayHello(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            System.out.println("Around: 我切到了sayHello方法");
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable ex) {
            log.error("失败: {},{}", ex.getClass().getName(), ex.getMessage());
        }
        return "sayHello方法执行失败";
    }

    @After("sayHello()")
    public void afterSayHello(){
        System.out.println("After: 我切到了sayHello方法");
    }
}
