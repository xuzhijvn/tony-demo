package com.tony.demo3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author tony121.xu@huolala.cn
 * @create 2021-05-08
 * Description:
 */
@Slf4j
@Component
public abstract class BaseHelloService implements HelloService{


    @Override
    public String say() {
        return say2();
    }

    @Override
    public String say2() {
        return "I am say2";
    }

    @Resource
    ApplicationContext applicationContext;

    protected String mySay2(){
        return applicationContext.getBean(this.getClass()).say2();
    }
}
