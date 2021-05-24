 /*
  *       Copyright© (2020) Lalamove Co., Ltd.
  */
 package com.tony.annotationstrategy;

 /**
  * @author tony121.xu@huolala.cn
  * @create 2021-05-24
  * @description:
  */
 @OrderHandlerType(source = "pc", payMethod = "wechat")
 public class PCWechatOrderHandler implements OrderHandler {
     @Override
     public void handle(Order order) {
         System.out.println("处理PC端wechat订单");
     }
 }
