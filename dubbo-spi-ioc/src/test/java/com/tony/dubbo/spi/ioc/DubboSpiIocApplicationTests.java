package com.tony.dubbo.spi.ioc;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.config.spring.extension.SpringExtensionFactory;
import org.apache.dubbo.rpc.Filter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DubboSpiIocApplicationTests {

    @Autowired
    public ApplicationContext applicationContext;

    @Test
    void contextLoads() {
    }

    @Test
    public void sayHello() throws Exception {

        SpringExtensionFactory.addApplicationContext(applicationContext);

        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}
