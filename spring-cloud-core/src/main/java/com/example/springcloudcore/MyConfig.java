package com.example.springcloudcore;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    @RefreshScope
    public User user(@Value("${user.age}") int age) {
        System.out.println("config: " + age);
        return new User(age);
    }

}
