/*
 *       Copyright© (2020) TONY Co., Ltd.
 */
package com.tony.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author tony
 * @create 2021-07-25
 * @description:
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("myJavaBean".equals(beanName)){
            System.out.println("3. 调用BeanPostProcessor.postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("myJavaBean".equals(beanName)){
            System.out.println("7. 调用BeanPostProcessor.postProcessAfterInitialization");
        }
        return bean;
    }
}