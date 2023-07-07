package com.tony.other.demo3;

import org.springframework.stereotype.Service;

/**
 * @author tony老师
 * @create 2021-05-08
 * Description:
 */
@Service
public class HelloService2Impl extends HelloServiceTimeOut implements HelloService2{

    @Override
    public String sayHello() {
        int i = 1/0;
        handle();
        return "hello aspect";
    }
}
