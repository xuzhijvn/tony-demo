/*
*       Copyright© (2020).
*/
package com.tony.chain.resp;

/**
* @author tony
* @create 2021-08-08
* @description:
*/
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}