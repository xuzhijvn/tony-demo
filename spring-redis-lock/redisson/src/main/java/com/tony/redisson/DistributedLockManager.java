package com.tony.redisson;

import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * @author tony121.xu@huolala.cn
 * @create 2021-05-17
 * Description:
 */
@Component
public class DistributedLockManager {

    @DistributedLock(lockName = "lock", lockNamePost = ".lock")
    public int aspect(Supplier<Integer> supplier) {
        return supplier.get();
    }

}
