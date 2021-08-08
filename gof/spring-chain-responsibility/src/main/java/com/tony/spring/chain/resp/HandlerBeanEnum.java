/*
 *       Copyright© (2020).
 */
package com.tony.spring.chain.resp;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tony
 * @create 2021-08-08
 * @description:
 */
@Getter
@AllArgsConstructor
public enum HandlerBeanEnum {

    AHandler("aHandler"),
    BHandler("bHandler"),
    CHandler("cHandler");

    private String beanName;
}
