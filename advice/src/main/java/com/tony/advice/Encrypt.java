 /*
  *       Copyright© (2020) Lalamove Co., Ltd.
  */
 package com.tony.advice;

 import java.lang.annotation.*;

 /**
  * @author tony老师
  * @create 2021-05-24
  * @description: 加解密
  */
 @Target({ElementType.PARAMETER, ElementType.METHOD})
 @Retention(RetentionPolicy.RUNTIME)
 @Documented
 public @interface Encrypt {
 }
