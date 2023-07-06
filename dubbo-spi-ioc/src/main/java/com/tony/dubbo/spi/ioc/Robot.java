package com.tony.dubbo.spi.ioc;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author 徐植君
 * @date 2023/7/7 0:00
 */

@SPI
public interface Robot {
    void sayHello();
}