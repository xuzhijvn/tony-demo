package com.tony.mysql.tx.isolation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tony.mysql.tx.isolation.**.mapper.**")
public class MysqlTxIsolationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlTxIsolationApplication.class, args);
    }

}
