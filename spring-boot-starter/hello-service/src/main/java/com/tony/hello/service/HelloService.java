 /*
  *       Copyright© (2020) Lalamove Co., Ltd.
  */
 package com.tony.hello.service;

 import lombok.AllArgsConstructor;
 import lombok.Data;

 /**
  * @author tony老师
  * @create 2021-06-02
  * @description:
  */
 @Data
 @AllArgsConstructor
 public class HelloService {
     private String name;
     private Integer age;

     public void say() {
         System.out.println("hello " + name + " you have " + age + " old");
     }
 }
