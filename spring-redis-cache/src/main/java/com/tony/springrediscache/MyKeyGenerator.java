package com.tony.springrediscache;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tony老师
 * @create 2021-05-17
 * Description:
 */
@Component
public class MyKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        return target.getClass().getName() + "." + method.getName() + "(" +
                Stream.of(params).map(Object::toString).collect(Collectors.joining(",")) + ")";
    }
}