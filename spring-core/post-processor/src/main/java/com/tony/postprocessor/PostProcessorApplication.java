package com.tony.postprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class PostProcessorApplication {


    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(PostProcessorApplication.class, args);
        MyJavaBean bean = (MyJavaBean) applicationContext.getBean("myJavaBean");
        System.out.println("=======================结果====================");
        System.out.println("desc：" + bean.getDesc());
        System.out.println("remark：" + bean.getRemark());
        System.out.println("======================结果====================");

    }

}
