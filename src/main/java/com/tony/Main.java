 /*
  *       Copyright© (2020) Lalamove Co., Ltd.
  */
 package com.tony;

 /**
  * @author tony121.xu@huolala.cn
  * @create 2021-06-11
  * @description:
  */
 public class Main {
     public static void main(String[] args) {
         String str = "12,13";
         String[] sa = str.split(",");
         test1(sa);
     }

     public static void test1(Object... objects){
         for (Object o: objects){
             System.out.println(o);
         }
     }
 }
