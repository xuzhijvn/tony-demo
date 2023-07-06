package com.tony.dubbo.spi.ioc;

import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcException;

/**
 * @author 徐植君
 * @date 2023/7/7 0:52
 */
public class TraceFilter implements Filter {

    private Weapon weapon;

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        // before filter ...
        System.out.println("before filter ...");

        System.out.println("weapon = " + weapon);

        Result result = invoker.invoke(invocation);
        // after filter ...
        System.out.println("after filter ...");

        return result;
    }
}