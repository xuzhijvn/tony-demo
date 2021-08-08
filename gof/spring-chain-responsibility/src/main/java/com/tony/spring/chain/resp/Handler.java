/*
 *       Copyright© (2020).
 */
package com.tony.spring.chain.resp;

/**
 * @author tony
 * @create 2021-08-08
 * @description:
 */
public abstract class Handler {

    protected Handler nextHandler;

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    abstract void dealRequest(Integer num);
}
