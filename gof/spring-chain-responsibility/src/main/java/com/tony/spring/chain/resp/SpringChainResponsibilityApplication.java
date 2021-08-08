package com.tony.spring.chain.resp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SpringChainResponsibilityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringChainResponsibilityApplication.class, args);
    }

    @Autowired
    private ExecuteHandler executeHandler;
    /**
     * 测试责任链模式
     * @return
     */
    @GetMapping("/test/{num}")
    public String testHandler(@PathVariable Integer num){
        Handler handler = executeHandler.getHandler();
        handler.dealRequest(num);
        return "123";
    }

}
