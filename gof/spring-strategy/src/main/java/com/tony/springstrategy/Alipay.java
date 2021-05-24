package com.tony.springstrategy;

import org.springframework.stereotype.Service;

/**
 * 支付宝
 * @author: 栈长
 * @from: Java技术栈
 */
@Service("Alipay")
public class Alipay implements IPayment {

    @Override
    public PayResult pay(Order order) {
        return new PayResult("支付宝支付成功");
    }

}