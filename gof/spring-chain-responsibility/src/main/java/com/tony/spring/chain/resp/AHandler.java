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

@Order(3)
@Component("aHandler")
public class AHandler extends Handler {


    @Override
    public void dealRequest(Integer num) {
        if (num > 100) {
            System.out.println("num > 100,A责任链处理");
        }
        nextHandler.dealRequest(num);
    }
}