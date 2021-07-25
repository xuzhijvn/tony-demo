/*
 *       Copyright© (2020) TONY Co., Ltd.
 */
package com.tony.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author tony
 * @create 2021-07-25
 * @description:
 */

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("1. 调用BeanFactoryPostProcessor的postProcessBeanFactory");
        BeanDefinition bd = beanFactory.getBeanDefinition("myJavaBean");
        MutablePropertyValues pv = bd.getPropertyValues();
        pv.addPropertyValue("remark", "BeanFactoryPostProcessor中修改之后的remark");
    }
}