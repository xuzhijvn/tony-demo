/*
 *       Copyright© (2020) TONY Co., Ltd.
 */
package com.tony.annotation.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tony
 * @create 2021-07-25
 * @description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";
}