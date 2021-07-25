/*
 *       Copyright© (2020) Lalamove Co., Ltd.
 */
package com.tony.annotation.beanpostprocessor;

/**
 * @author tony
 * @create 2021-07-25
 * @description:
 */

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.FIELD}) //声明应用在属性上
@Retention(RetentionPolicy.RUNTIME) //运行期生效
@Documented //Java Doc
@Component
public @interface Boy {
    String value() default "";
}