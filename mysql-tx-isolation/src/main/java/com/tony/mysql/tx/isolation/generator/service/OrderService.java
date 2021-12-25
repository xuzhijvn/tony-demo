package com.tony.mysql.tx.isolation.generator.service;

import com.tony.mysql.tx.isolation.generator.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface OrderService extends IService<Order> {

    void doOrder() throws InterruptedException;

}
