 /*
  *       Copyright© (2020) Lalamove Co., Ltd.
  */
 package com.tony.hello.starter;

 import com.tony.hello.service.HelloService;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
 import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
 import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
 import org.springframework.boot.context.properties.EnableConfigurationProperties;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;

 /**
  * @author tony老师
  * @create 2021-06-02
  * @description:
  */
 @Configuration
 @ConditionalOnClass(HelloService.class)
 @EnableConfigurationProperties(HelloProperties.class)
 @Slf4j
 public class HelloAutoConfigure {

     @Bean
     @ConditionalOnMissingBean(HelloService.class)
     @ConditionalOnProperty(prefix = "tony.hello", value = "enabled", havingValue = "true")
     HelloService helloService(HelloProperties helloProperties) {
         return new HelloService(helloProperties.getName(), helloProperties.getAge());
     }
 }
