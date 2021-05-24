package com.tony.springstrategy;

import lombok.Data;

/**
 * 订单信息
 * @author: 栈长
 * @from: Java技术栈
 */
@Data
public class Order {

    /**
     * 金额
     */
    private int amount;

    /**
     * 支付类型
     */
    private String paymentType;

}