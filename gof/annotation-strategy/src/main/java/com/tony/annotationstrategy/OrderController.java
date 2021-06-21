 /*
  *       Copyright© (2020) Lalamove Co., Ltd.
  */
 package com.tony.annotationstrategy;

 import lombok.extern.slf4j.Slf4j;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 /**
  * @author tony老师
  * @create 2021-05-24
  * @description:
  */
 @RestController
 @RequestMapping("annotation-strategy")
 @Slf4j
 public class OrderController {

     @Autowired
     OrderService orderService;

     @PostMapping("pay1")
     @ResponseBody
     public Order pay1(@RequestBody Order order) {
         log.info("订单:[{}]", order);
         orderService.orderService(order);
         return order;
     }

     @PostMapping("pay2")
     public Order pay2(Order order) {
         log.info("订单:[{}]", order);
         orderService.orderService(order);
         return order;
     }
 }