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
@Order(2)
@Component("cHandler")
public class CHandler extends Handler {

    @Override
    public void dealRequest(Integer num) {
        System.out.println("C责任链处理");
        nextHandler.dealRequest(num);
    }
}