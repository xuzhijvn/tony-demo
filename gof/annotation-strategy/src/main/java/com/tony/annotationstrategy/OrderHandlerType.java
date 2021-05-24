 /*
  *       Copyright© (2020) Lalamove Co., Ltd.
  */
 package com.tony.annotationstrategy;

 import org.springframework.stereotype.Service;

 import java.lang.annotation.*;

 /**
  * @author tony121.xu@huolala.cn
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
