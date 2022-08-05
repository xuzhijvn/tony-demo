package com.example.springcloudcore;

import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
public class User {
    private int age;

    public User(int age){
        System.out.println("user: " + age);
        this.age = age;
    }

}
