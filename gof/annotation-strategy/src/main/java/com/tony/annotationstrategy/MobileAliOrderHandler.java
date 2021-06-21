 /*
  *       Copyright© (2020) Lalamove Co., Ltd.
  */
 package com.tony.annotationstrategy;

 /**
  * @author tony老师
  * @create 2021-05-24
  * @description:
  */
 @OrderHandlerType(source = "mobile", payMethod = "ali")
 public class MobileAliOrderHandler implements OrderHandler {
     @Override
     public void handle(Order order) {
         System.out.println("处理移动端alipay订单");
     }
 }
