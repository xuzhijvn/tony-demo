 /*
  *       Copyright© (2020) TONY Co., Ltd.
  */
 package com.tony.annotationstrategy;

 import org.springframework.stereotype.Service;

 import java.lang.annotation.*;

 /**
  * @author tony老师
  * @create 2021-05-24
  * @description:
  */
 @Target(ElementType.TYPE)
 @Retention(RetentionPolicy.RUNTIME)
 @Documented
 @Service
 public @interface OrderHandlerType {
  String source();
  String payMethod();
 }
