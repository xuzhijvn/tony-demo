/*
 *       Copyright© (2020).
 */
package com.tony.mysql.tx.isolation;

import com.tony.mysql.tx.isolation.generator.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tony
 * @create 2021-09-22
 * @description:
 */

@RestController
@RequestMapping(value = "tx")
public class Controller {

    @Resource
    OrderService orderService;

    @GetMapping(value = "order1")
    public void order1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ": 收到请求1");
        orderService.doOrder();
    }

    @GetMapping(value = "order2")
    public void order2() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ": 收到请求2");
        orderService.doOrder();
    }
}
