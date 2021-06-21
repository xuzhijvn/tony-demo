 /*
  *       Copyright© (2020) Lalamove Co., Ltd.
  */
 package com.tony.hello.test;

 import com.tony.hello.service.HelloService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 /**
  * @author tony老师
  * @create 2021-06-02
  * @description:
  */

 @RestController
 @RequestMapping(value = "hello")
 public class HelloController {

     @Autowired
     private HelloService helloService;

     @GetMapping(value = "say")
     public void say(){
         helloService.say();
     }
 }
