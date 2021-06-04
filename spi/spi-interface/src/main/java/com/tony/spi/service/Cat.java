 /*
  *       Copyright© (2020) Lalamove Co., Ltd.
  */
 package com.tony.spi.service;

 /**
  * @author tony121.xu@huolala.cn
  * @create 2021-05-31
  * @description:
  */
 public class Cat implements IShout {
     @Override
     public void shout() {
         System.out.println("miao miao");
     }
 }