 /*
  *       Copyright© (2020) Lalamove Co., Ltd.
  */
 package com.tony.spit.test;

 import com.tony.spi.service.IShout;

 import java.util.ServiceLoader;

 /**
  * @author tony老师
  * @create 2021-05-31
  * @description:
  */
 public class Main {

     public static void main(String[] args) {
         ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
         for (IShout s : shouts) {
             s.shout();
         }
     }
 }
