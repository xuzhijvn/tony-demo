package com.tony.demo3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tony老师
 * @create 2021-05-01
 * Description:
 */
@RestController
@Slf4j
public class TestController {
    @Resource
    HelloService2 helloService2;

    @RequestMapping("/aspect")
    public String retry(){
        log.info("测试日志格式");
        String res = helloService2.sayHello();
        return res;
    }
}
