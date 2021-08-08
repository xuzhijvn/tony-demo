/*
*       Copyright© (2020).
*/
package com.tony.chain.resp;

/**
* @author tony
* @create 2021-08-08
* @description:
*/
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}