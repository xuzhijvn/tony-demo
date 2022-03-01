/*
 *       Copyright© (2020).
 */
package com.tony.clazz.unload;

import java.io.*;

/**
 * @author tony
 * @create 2022-03-01
 * @description:
 */
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/") + ".class";
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(classPath);
            outputStream = new ByteArrayOutputStream();
            int temp = 0;
            while ((temp = inputStream.read()) != -1) {
                outputStream.write(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byte[] bytes = outputStream.toByteArray();
        return defineClass(name, bytes, 0, bytes.length);
    }
}