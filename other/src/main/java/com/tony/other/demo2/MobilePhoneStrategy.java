package com.tony.other.demo2;

import org.springframework.stereotype.Component;

/**
 * @author tony老师
 * @create 2021-05-07
 * Description:
 */
@Component
public class MobilePhoneStrategy implements SensitiveStrategy {

    @Override
    public SensitiveType getSensitiveType() {
        return SensitiveType.MOBILE_PHONE;
    }

    @Override
    public String maskingData(String str) {
        return "155******";
    }
}