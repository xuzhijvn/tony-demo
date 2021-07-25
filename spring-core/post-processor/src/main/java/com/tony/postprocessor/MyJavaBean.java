/*
 *       Copyright© (2020) Lalamove Co., Ltd.
 */
package com.tony.postprocessor;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @author tony
 * @create 2021-07-25
 * @description:
 */

public class MyJavaBean implements InitializingBean, DisposableBean {
    private String desc;
    private String remark;

    public MyJavaBean() {
        System.out.println("2 Bean的无参构造函数");
    }

    public MyJavaBean(String desc, String remark) {
        this.desc = desc;
        this.remark = remark;
        System.out.println("2 Bean的全参构造函数");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("4. 调用PostConstruct方法");
    }


    public String getDesc() {
        return desc;
    }


    public void setDesc(String desc) {
        System.out.println("调用setDesc方法");
        this.desc = desc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        System.out.println("调用setRemark方法");
        this.remark = remark;
        System.out.println("remark = " + this.remark);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("5. 调用InitializingBean.afterPropertiesSet方法");
        this.desc = "afterPropertiesSet中修改之后的desc";
    }

    public void initMethod() {
        System.out.println("6. 调用Bean的init方法");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("8. 调用DisposableBean.destroy");
    }

    public void destroyMethod() {
        System.out.println("9. 调用Bean的destroy方法");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[desc：").append(desc);
        builder.append("， remark：").append(remark).append("]");
        return builder.toString();
    }


}