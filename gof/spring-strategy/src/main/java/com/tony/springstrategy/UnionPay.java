package com.tony.springstrategy;

import org.springframework.stereotype.Service;

/**
 * 银联云闪付
 * @author: 栈长
 * @from: Java技术栈
 */
@Service("UnionPay")
public class UnionPay implements IPayment {

    @Override
    public PayResult pay(Order order) {
        return new PayResult("云闪付支付成功");
    }

}
