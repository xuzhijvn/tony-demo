package com.tony.redisson;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.beanutils.PropertyUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author tony老师
 * @create 2021-05-17
 * Description:
 */
@Aspect
@Component
public class RedissonLockAspect {

    @Autowired
    private RedissonLockTemplate redissonLockTemplate;


    @Around(value = "@annotation(redissonLock)")
    public Object doAround(ProceedingJoinPoint pjp, RedissonLock redissonLock) throws Throwable {
        //切点所在的类
        Class targetClass = pjp.getTarget().getClass();
        //使用了注解的方法
        String methodName = pjp.getSignature().getName();
        Class[] parameterTypes = ((MethodSignature) pjp.getSignature()).getMethod().getParameterTypes();
        Method method = targetClass.getMethod(methodName, parameterTypes);
        Object[] arguments = pjp.getArgs();
        final String lockName = getLockName(redissonLock, method, arguments);
        return lock(pjp, method, lockName);
    }

    @AfterThrowing(value = "@annotation(redissonLock)", throwing = "ex")
    public void afterThrowing(Throwable ex, RedissonLock redissonLock) {
        throw new RuntimeException(ex);
    }


    private String getLockName(RedissonLock redissonLock, Method method, Object[] arguments) {
        String lockName = SpELUtil.parseSpel(redissonLock.lockName(), method, arguments).toString();
        if (StrUtil.isNotBlank(lockName)) {
            String preLockName = redissonLock.lockNamePre(),
                    postLockName = redissonLock.lockNamePost(),
                    separator = redissonLock.separator();
            StringBuilder lName = new StringBuilder();
            if (StrUtil.isNotBlank(preLockName)) {
                lName.append(preLockName).append(separator);
            }
            lName.append(lockName);
            if (StrUtil.isNotBlank(postLockName)) {
                lName.append(separator).append(postLockName);
            }
            lockName = lName.toString();
            return lockName;
        }
        throw new IllegalArgumentException("Can't get or generate lockName accurately!");
    }

    public Object lock(ProceedingJoinPoint pjp, Method method, final String lockName) {
        RedissonLock annotation = method.getAnnotation(RedissonLock.class);
        boolean fairLock = annotation.fairLock();
        boolean tryLock = annotation.tryLock();
        if (tryLock) {
            return tryLock(pjp, annotation, lockName, fairLock);
        } else {
            return lock(pjp, lockName, fairLock);
        }
    }

    public Object lock(ProceedingJoinPoint pjp, final String lockName, boolean fairLock) {
        return redissonLockTemplate.lock(new RedissonLockCallback<Object>() {
            @Override
            public Object process() {
                return proceed(pjp);
            }

            @Override
            public String getLockName() {
                return lockName;
            }
        }, fairLock);
    }

    public Object tryLock(ProceedingJoinPoint pjp, RedissonLock annotation, final String lockName, boolean fairLock) {
        long waitTime = annotation.waitTime(),
                leaseTime = annotation.leaseTime();
        TimeUnit timeUnit = annotation.timeUnit();
        return redissonLockTemplate.tryLock(new RedissonLockCallback<Object>() {
            @Override
            public Object process() {
                return proceed(pjp);
            }

            @Override
            public String getLockName() {
                return lockName;
            }
        }, waitTime, leaseTime, timeUnit, fairLock);
    }

    public Object proceed(ProceedingJoinPoint pjp) {
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
}