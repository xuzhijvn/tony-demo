/*
 *       Copyright© (2020) TONY Co., Ltd.
 */
package com.tony.annotation.beanpostprocessor;

import org.springframework.stereotype.Service;

/**
 * @author tony
 * @create 2021-07-25
 * @description:
 */
@Service
public class HelloBoy {

    @Boy("tony")
    String name = "world";

    public void sayHello() {
        System.out.println("hello, " + name);
    }
}