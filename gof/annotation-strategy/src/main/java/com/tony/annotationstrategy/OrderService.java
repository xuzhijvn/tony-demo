 /*
  *       Copyright© (2020) TONY Co., Ltd.
  */
 package com.tony.annotationstrategy;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.core.annotation.AnnotationUtils;
 import org.springframework.stereotype.Service;

 import java.util.List;
 import java.util.Map;
 import java.util.stream.Collectors;

 /**
  * @author tony老师
  * @create 2021-05-24
  * @description:
  */
 @Service
 public class OrderService {
     private Map<OrderHandlerType, OrderHandler> orderHandleMap;

     @Autowired
     public void setOrderHandleMap(List<OrderHandler> orderHandlers) {
         // 注入各种类型的订单处理类
         orderHandleMap = orderHandlers.stream().collect(
                 Collectors.toMap(orderHandler -> AnnotationUtils.findAnnotation(orderHandler.getClass(), OrderHandlerType.class),
                         v -> v, (v1, v2) -> v1));
     }
     public void orderService(Order order) {
         // ...一些前置处理

         // 通过订单来源确以及支付方式获取对应的handler
         OrderHandlerType orderHandlerType = new OrderHandlerTypeImpl(order.getSource(), order.getPayMethod());
         OrderHandler orderHandler = orderHandleMap.get(orderHandlerType);
         orderHandler.handle(order);

         // ...一些后置处理
     }
 }