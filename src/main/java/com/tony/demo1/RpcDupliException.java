package com.tony.demo1;

/**
 * @author tony121.xu@huolala.cn
 * @create 2021-04-24
 * Description:
 */
public class RpcDupliException extends RpcException {

    public RpcDupliException() {
        super("不能重复调用接口!");
    }

    public RpcDupliException(String message) {
        super("不能重复调用接口: " + message);
    }

    public RpcDupliException(String message, Throwable cause) {
        super("不能重复调用接口: " + message, cause);
    }

    public RpcDupliException(Throwable cause) {
        super("不能重复调用接口!", cause);
    }

    protected RpcDupliException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}