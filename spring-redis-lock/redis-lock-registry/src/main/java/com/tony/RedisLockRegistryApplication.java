package com.tony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisLockRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisLockRegistryApplication.class, args);
    }

}
