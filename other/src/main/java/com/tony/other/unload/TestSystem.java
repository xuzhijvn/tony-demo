/*
*       Copyright© (2020).
*/
package com.tony.other.unload;

/**
* @author tony
* @create 2022-03-01
* @description:
*/
public class TestSystem {

    public static void main(String[] args) throws Exception {
        System.out.println("第一次开始加载Sample类");
        System.out.println(Sample.class.getName());
        Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(Sample.class.getName());
        Object obj = clazz.newInstance();
        System.out.println(clazz.hashCode());
        obj = null;
        clazz = null;
        System.gc();
        System.out.println("第二次开始加载Sample类");
        clazz = ClassLoader.getSystemClassLoader().loadClass(Sample.class.getName());
        System.out.println(clazz.hashCode());
        Thread.sleep(2000);
        System.out.println("执行结束....");
    }

}
