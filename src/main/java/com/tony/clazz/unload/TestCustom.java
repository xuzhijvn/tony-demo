/*
 *       Copyright© (2020).
 */
package com.tony.clazz.unload;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author tony
 * @create 2022-03-01
 * @description:
 */
public class TestCustom {

    public static void main(String[] args) throws Exception {
        System.out.println("开始加载Sample类");
        FileClassLoader myClassLoader = new FileClassLoader("/Users/tony/workspace/tony-demo/src/main/java");
        //URLClassLoader myClassLoader = new URLClassLoader(new URL[]{new URL("file:/Users/tony/workspace/tony-demo/src/main/java/")});
        //Class<?> clazz = myClassLoader.loadClass("com.tony.clazz.unload.Sample");
        Class<?> clazz = myClassLoader.findClass("com.tony.clazz.unload.Sample");
        Object obj = clazz.newInstance();
        // 当代表类的Class对象不在被引用时，Class对象就会结束生命周期，类在方法区内的数据也会被卸载
        obj = null;
        clazz = null;
        myClassLoader = null;
        System.gc();
        Thread.sleep(2000);
        System.out.println("执行结束....");
    }

}
