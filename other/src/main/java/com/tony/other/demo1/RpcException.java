package com.tony.other.demo1;

/**
 * @author tony老师
 * @create 2021-04-24
 * Description:
 */
public class RpcException extends Exception {

    public RpcException() {
        super("rpc异常");
    }

    public RpcException(String message) {
        super("rpc异常: " + message);
    }

    public RpcException(String message, Throwable cause) {
        super("rpc异常: " + message, cause);
    }

    public RpcException(Throwable cause) {
        super("rpc异常", cause);
    }

    protected RpcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}