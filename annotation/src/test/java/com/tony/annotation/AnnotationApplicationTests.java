package com.tony.annotation;

import com.tony.annotation.aspect.HelloLog;
import com.tony.annotation.aspect.Log;
import com.tony.annotation.beanpostprocessor.HelloBoy;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class AnnotationApplicationTests {

    @Autowired
    HelloBoy helloBoy;

    @Autowired
    HelloLog helloLog;

    @Test
    public void HelloBoyTest() {
        helloBoy.sayHello();
    }


    @Test
    public void HelloLogTest(){
        helloLog.sayHello();
    }

}
