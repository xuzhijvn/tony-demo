 /*
  *       Copyright© (2020) Lalamove Co., Ltd.
  */
 package com.tony.hello.starter;

 import lombok.Data;
 import org.springframework.boot.context.properties.ConfigurationProperties;

 /**
  * @author tony老师
  * @create 2021-06-02
  * @description:
  */
 @Data
 @ConfigurationProperties("tony.hello")
 public class HelloProperties {

     private String name;

     private int age;
 }