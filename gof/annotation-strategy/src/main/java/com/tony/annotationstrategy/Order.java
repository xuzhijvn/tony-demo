 /*
  *       Copyright© (2020) TONY Co., Ltd.
  */
 package com.tony.annotationstrategy;

 import lombok.Data;

 import java.math.BigDecimal;

 /**
  * @author tony老师
  * @create 2021-05-24
  * @description:
  */
 @Data
 public class Order {
     /**
      * 订单来源
      */
     private String source;
     /**
      * 支付方式
      */
     private String payMethod;
     /**
      * 订单编号
      */
     private String code;
     /**
      * 订单金额
      */
     private BigDecimal amount;
     // ...其他的一些字段
 }
