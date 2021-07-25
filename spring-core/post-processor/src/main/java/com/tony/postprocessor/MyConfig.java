/*
 *       Copyright© (2020) TONY Co., Ltd.
 */
package com.tony.postprocessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tony
 * @create 2021-07-25
 * @description:
 */
@Configuration
public class MyConfig {
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public MyJavaBean myJavaBean() {
        MyJavaBean bean = new MyJavaBean();
        bean.setRemark("原始remark");
        return bean;
    }

    @Bean
    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor(){
        return new MyBeanFactoryPostProcessor();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }
}
