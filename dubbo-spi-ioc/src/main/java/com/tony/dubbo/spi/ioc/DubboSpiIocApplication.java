package com.tony.dubbo.spi.ioc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DubboSpiIocApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboSpiIocApplication.class, args);
    }

    @Bean
    public Weapon weapon(){
        Weapon gun = new Weapon();
        gun.setName("gun");
        return gun;
    }
}
