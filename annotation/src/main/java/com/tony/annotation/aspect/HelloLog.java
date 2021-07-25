/*
 *       Copyright© (2020) Lalamove Co., Ltd.
 */
package com.tony.annotation.aspect;

import com.tony.annotation.beanpostprocessor.Boy;
import org.springframework.stereotype.Service;

/**
 * @author tony
 * @create 2021-07-25
 * @description:
 */
@Service
public class HelloLog {



    @Log("测试自定义注解")
    public void sayHello() {
        System.out.println("hello, log" );
    }
}