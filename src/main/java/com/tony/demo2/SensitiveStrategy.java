package com.tony.demo2;

/**
 * @author tony121.xu@huolala.cn
 * @create 2021-05-07
 * Description:
 */
public interface SensitiveStrategy {

    SensitiveType getSensitiveType();

    String maskingData(String str);
}