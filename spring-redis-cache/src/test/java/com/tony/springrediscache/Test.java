package com.tony.springrediscache;

import org.springframework.util.Assert;

/**
 * @author tony老师
 * @create 2021-05-17
 * Description:
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void test(){
        try {
            testAssert();
        }catch (Exception e){
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    public void testAssert(){
        String in = null;
        Assert.notNull(in, "输入不能为空哦");
    }
}
