 /*
  *       Copyright© (2020) TONY Co., Ltd.
  */
 package com.tony;

 /**
  * @author tony老师
  * @create 2021-06-11
  * @description:
  */
 public class Main {
     public static void main(String[] args) {
//         String str = "12,13";
//         String[] sa = str.split(",");
//         test1(sa);
//
//         long a = 100000 / 31;
//         int b = 100000 / 31;
//         System.out.println(a);
//         System.out.println(b);
//
//         int c = (int) Math.ceil((double) 12395 / 100);
//         System.out.println(c);

         System.out.println(flag1() && flag2());
     }

     public static void test1(Object... objects) {
         for (Object o : objects) {
             System.out.println(o);
         }
     }

     public static boolean flag1(){
         System.out.println("flag1");
         return false;
     }

     public static boolean flag2(){
         System.out.println("flag2");
         return false;
     }
 }
