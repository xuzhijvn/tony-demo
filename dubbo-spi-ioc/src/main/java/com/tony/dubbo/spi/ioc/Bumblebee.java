package com.tony.dubbo.spi.ioc;

/**
 * @author 徐植君
 * @date 2023/7/7 0:01
 */
public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}