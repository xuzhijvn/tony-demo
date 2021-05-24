package com.tony.redisson;

import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * @author tony121.xu@huolala.cn
 * @create 2021-05-17
 * Description:
 */
@Component
public class TestService {

    @RedissonLock(lockName = "lock", lockNamePost = ".lock")
    public int doSomething1(Supplier<Integer> supplier) {
        return supplier.get();
    }

    @RedissonLock(lockName = "lock", lockNamePost = ".lock")
    public void doSomething2(Action action) {
        action.action();
    }

    @RedissonLock(lockNamePre = "lock", lockName = "#person.id", lockNamePost = "redisson")
    public int doSomething3(Supplier<Integer> supplier, Person person) {
        return supplier.get();
    }

}
