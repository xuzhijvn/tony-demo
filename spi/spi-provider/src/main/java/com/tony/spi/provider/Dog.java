 /*
  *       Copyright© (2020) Lalamove Co., Ltd.
  */
 package com.tony.spi.provider;

 import com.tony.spi.service.IShout;

 /**
  * @author tony老师
  * @create 2021-05-31
  * @description:
  */
 public class Dog implements IShout {
     @Override
     public void shout() {
         System.out.println("wang wang");
     }
 }