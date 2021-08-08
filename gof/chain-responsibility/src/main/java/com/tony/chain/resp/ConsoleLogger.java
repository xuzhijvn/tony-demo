/*
*       Copyright© (2020).
*/
package com.tony.chain.resp;

/**
* @author tony
* @create 2021-08-08
* @description:
*/
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}