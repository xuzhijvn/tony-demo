/*
 *       Copyright© (2020).
 */
package com.tony.spring.chain.resp;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author tony
 * @create 2021-08-08
 * @description:
 */
@Order(1)
@Component("bHandler")
public class BHandler extends Handler {

    @Override
    public void dealRequest(Integer num) {
        if (num > 200) {
            System.out.println("num > 200,B责任链处理");
        }
        nextHandler.dealRequest(num);
    }
}